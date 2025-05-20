package pbo.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.*;

public class Executor {
    private EntityManager entityManager;
    public Executor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cleanUpTables() {
        String[] sql = {
            "DELETE FROM Student",
            "DELETE FROM Dorm "
        };
        entityManager.getTransaction().begin();
        for(String s : sql){
            entityManager.createQuery(s).executeUpdate();
        }
        entityManager.getTransaction().commit();  
    }

    public void addCourse(String[] data) {
        entityManager.getTransaction().begin();
        Course courses = new Course(data[1], data[2], data[3]);
        entityManager.persist(courses);
        entityManager.getTransaction().commit();
    }

    public void addStudent(String[] data){
        entityManager.getTransaction().begin();
        Student tempStudent;
        if((tempStudent = entityManager.find(Student.class, data[1])) == null){
            Student student = new Student(data[1], data[2], data[3]);
            entityManager.persist(student);
        }else{
            if(!tempStudent.getNim().equals(data[1])){
                Student student = new Student(data[1], data[2], data[3]);
                entityManager.persist(student);
            }
        }
        entityManager.getTransaction().commit();
    }

    public void assignStudentToCourse(String[] data) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, data[1]);
        Course courses = entityManager.find(Course.class, data[2]);
        if (student != null && courses != null && student.getNama().equals(courses.getNama())) {
            student.getCourses().add(courses);
            courses.getStudents().add(student);
            courses.setKode(courses.getKode());
            entityManager.persist(student);
            entityManager.persist(courses);
            entityManager.getTransaction().commit();
        } else {
            entityManager.getTransaction().rollback();
        }
    }

    public void displayAllCourse() {
        String courseSql = "SELECT g FROM Dorm g ORDER BY g.name";
        List<Course> courses = entityManager.createQuery(courseSql, Course.class).getResultList();
        for (Course course : courses) {
            System.out.println(courses);
            List<Student> students = course.getStudents();
            Collections.sort(students, Comparator.comparing(Student::getNama));

            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    
    public void displayAllStudent() {
        String courseSql = "SELECT g FROM Dorm g ORDER BY g.name";
        List<Student> students = entityManager.createQuery(courseSql, Student.class).getResultList();
        for (Student student : students) {
            System.out.println(students);
            Collections.sort(students, Comparator.comparing(Student::getNama));

            
        }
    }

}


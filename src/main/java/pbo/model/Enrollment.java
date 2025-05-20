package pbo.model;

import javax.persistence.*;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public Enrollment() {}

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
}

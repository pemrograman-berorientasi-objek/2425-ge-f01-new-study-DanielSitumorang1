package pbo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "student")
public class Student {

    @Id
    @Column (name = "nim", nullable = false, length = 20)
    private String nim;
    @Column (name = "nama", nullable = false, length = 30)
    private String nama;
    @Column (name = "prodi", nullable = false, length = 20)
    private String prodi;


    @ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_nim", referencedColumnName = "nim"), 
    inverseJoinColumns = @JoinColumn(name = "course_name", referencedColumnName = "name"))
    private List<Course> courses;
    
    @ManyToMany(targetEntity = Enrollment.class, cascade = CascadeType.ALL)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "Enrollment_nim", referencedColumnName = "nim"), 
    inverseJoinColumns = @JoinColumn(name = "course_name", referencedColumnName = "name"))
    private List<Enrollment> enrollments;
    public Student(){

    }

    public Student (String nim, String nama, String prodi){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public Student (String nim, String nama, String prodi, List<Course> courses){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.courses = courses;
    }

    public Student (List<Enrollment> enrollments){
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim (){
        return nim;
    }
     public String getNama (){
        return nama;
    }
     public String getProdi (){
        return prodi;
     }
    public List<Course> getCourses (){
        return courses;
     }
    public void setNim (String nim){
        this.nim = nim;
    }
      public void setNama (String nama){
        this.nama = nama;
    }
      public void setProdi (String prodi){
        this.prodi = prodi;
    }



    @Override
    public String toString(){
        return nim + "|" + nama + "|" + prodi;
    }
    
}

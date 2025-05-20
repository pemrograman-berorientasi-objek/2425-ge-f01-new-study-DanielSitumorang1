package pbo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "course")
public class Course {

    @Id
    @Column (name = "kode", nullable = false, length = 20)
    private String kode;
    @Column (name = "nama", nullable = false, length = 30)
    private String nama;
    @Column (name = "semester", nullable = false, length = 2)
    private String semester;
    @Column (name = "kredit", nullable = false)
    private int kredit;

    @ManyToMany(mappedBy = "Course", cascade = CascadeType.ALL)
    private List<Student> students;

    public Course(){

    }

    public Course(String kode, String nama, String semester){
        this.kode = kode;
        this.nama = nama;
        this.semester = semester;
        this.kredit = 0;
    }

    public Course(String kode, String nama, String semester, List<Student> students){
        this.kode = kode;
        this.nama = nama;
        this.semester = semester;
        this.students = students;
        this.kredit = students.size();
    }

    public String getKode (){
        return kode;
    }
     public String getNama (){
        return nama;
    }
     public String getSemester (){
        return semester;
    }
     public List<Student> getStudents (){
        return students;
    }
     public int getKredit (){
        return kredit;
    }

    public void setKode (String kode){
        this.kode = kode;
    }
      public void setNama (String nama){
        this.nama = nama;
    }
      public void setSemester (String semester){
        this.semester = semester;
    }
      public void setStudents (List<Student> students){
        this.students = students;
        this.kredit = students.size();
    }

    @Override
    public String toString(){
        return kode + "|" + nama + "|" + semester + kredit;
    }
    
}

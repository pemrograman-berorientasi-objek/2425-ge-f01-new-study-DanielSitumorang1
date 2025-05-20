package pbo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "Enrollment")
public class Enrollment {

    @Id
    @Column (name = "nim", nullable = false, length = 20)
    private String nim;
    @Column (name = "kode", nullable = false, length = 20)
    private String kode;

    @ManyToMany(mappedBy = "Enrollment", cascade = CascadeType.ALL)
    private List<Student> students;

    public Enrollment(){

    }

    public Enrollment (String nim, String kode){
        this.nim = nim;
        this.kode = kode;
    }

    public Enrollment(String nim, String kode, List<Student> students){
        this.nim = nim;
        this.kode = kode;
        this.students = students;
    }

    public String getNim (){
        return nim;
    }
     public String getKode (){
        return kode;
    }
     public List<Student> getStudents (){
        return students;
    }

    public void setNim (String nim){
        this.nim = nim;
    }
      public void setKode (String kode){
        this.kode = kode;
    }
    
    
      public void setStudents (List<Student> students){
        this.students = students;
    }

    @Override
    public String toString(){
        return nim + "|" + kode;
    }
    
}

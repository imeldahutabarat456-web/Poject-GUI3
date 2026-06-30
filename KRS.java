/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author IMELDA
 */
public class KRS {

    private Student student;
    private Course course;
    private String semester;
    private double sikap;
    private double uts;
    private double uas;
    
   private double nilaiAkhir;
   private String nilaiHuruf;
   
   public KRS() {} // Constructor kosong untuk DAO

    public KRS(Student student,Course course,
               String semester,
               double sikap,
               double uts,
               double uas) {

        this.student = student;
        this.course = course;
        this.semester = semester;
        this.sikap = sikap;
        this.uts = uts;
        this.uas = uas;
        
        hitungNilai();
    }
    public void hitungNilai() {

        nilaiAkhir =
                (sikap * 0.2)
              + (uts * 0.3)
              + (uas * 0.5);

        if (nilaiAkhir >= 85)
            nilaiHuruf = "A";
        else if (nilaiAkhir >= 70)
            nilaiHuruf = "B";
        else if (nilaiAkhir >= 60)
            nilaiHuruf = "C";
        else if (nilaiAkhir >= 50)
            nilaiHuruf = "D";
        else
            nilaiHuruf = "E";
    }
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public double getNilaiSikap() {
        return sikap;
    }

    public double getNilaiUts() {
        return uts;
    }

    public double getNilaiUas() {
        return uas;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir;
    }

    public String getNilaiHuruf() {
        return nilaiHuruf;
    }



    // Setter & Getter lainnya
public void setStudent(Student student) {
    this.student = student;
}

public void setCourse(Course course) {
    this.course = course;
}

public void setSemester(String semester) {
    this.semester = semester;
}

public void setNilaiSikap(double sikap) {
    this.sikap = sikap;
}

public void setNilaiUts(double uts) {
    this.uts = uts;
}

public void setNilaiUas(double uas) {
    this.uas = uas;
}
public void setNilaiAkhir(double nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    public void setNilaiHuruf(String nilaiHuruf) {
        this.nilaiHuruf = nilaiHuruf;
    }

 @Override
    public String toString() {
        // Pastikan memanggil getNamaMK() sesuai dengan kelas Course Anda
        String namaMhs = (student != null) ? student.getNama() : "Mahasiswa ";
        String namaMk = (course != null) ? course.getNamaMK() : "Matakuliah";
        return namaMhs + " - " + namaMk;
    }
    
}

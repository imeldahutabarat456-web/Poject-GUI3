 package model;

public class Course {
   private String kode;
    private String namaMK;
    private int sks;
    private String semesterAngka; // Ubah ke String agar match dengan database VARCHAR dan Form

    // PERBAIKAN 1: Tambahkan Constructor Kosong (Wajib ada untuk alur DAO/Controller)
    public Course() {
    }

    // Constructor Utama 
    public Course(String kode, String namaMK, int sks, String semesterAngka) {
        this.kode = kode;
        this.namaMK = namaMK;
        this.sks = sks;
        this.semesterAngka = semesterAngka;
    }

    // Getter dan Setter
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    // PERBAIKAN 2: Getter & Setter Semester diubah ke String
    public String getSemesterAngka() {
        return semesterAngka;
    }

    public void setSemesterAngka(String semesterAngka) {
        this.semesterAngka = semesterAngka;
    }

    @Override
    public String toString() {
        return namaMK;
    }
}
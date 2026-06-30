/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.KRS;
import java.util.ArrayList;

/**
 *
 * @author IMELDA
 */

public class Student {
    private String idCard;
    private String nim;
    private String nama;
    private String prodi;
    private ArrayList<KRS> daftarKRS = new ArrayList<>();

    // 1. Constructor Kosong (Wajib ada untuk penggunaan di DAO)
    public Student() {
    }

    // 2. Constructor dengan 4 Parameter
    public Student(String idCard, String nim, String nama, String prodi) {
        this.idCard = idCard;
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    // --- Getter ---
    public String getIdCard() { return idCard; }
    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getProdi() { return prodi; }

    // --- Setter ---
    public void setIdCard(String idCard) { this.idCard = idCard; }
    public void setNim(String nim) { this.nim = nim; }
    public void setNama(String nama) { this.nama = nama; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    // --- Method KRS ---
    public void addKRS(KRS krs) {
        daftarKRS.add(krs);
    }

    public ArrayList<KRS> getDaftarKRS() {
        return daftarKRS;
    }

    @Override
    public String toString() {
        return nama;
    }
}
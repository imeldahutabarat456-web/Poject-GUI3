/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Person {
    protected String nama;

    // Constructor
    public Person(String nama) {
        this.nama = nama;
    }

    // Getter untuk mengambil data nama
    public String getNama() {
        return nama;
    }
    @Override
    public String toString() {
        return this.nama;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.LecturerDAO;
import model.Lecturer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 *
 * @author IMELDA
 */
public class LecturerController {
    private final LecturerDAO lecturerDao;

    public LecturerController() {
        this.lecturerDao = new LecturerDAO(); // Menghubungkan ke database lewat DAO
    }

    // Mengambil semua data dosen
    public List<Lecturer> getAllLecturers() {
        return lecturerDao.getAll();
    }

    // PENAMBAHAN FITUR PAGINATION: Menghubungkan halaman pointer view ke DAO dosen
    public List<Lecturer> getLecturersByPage(int page, int limit) {
        int offset = (page - 1) * limit;
        return lecturerDao.getLecturersByPage(limit, offset);
    }

    // Method untuk menyimpan data dosen
    public boolean insert(JFrame view, String idCard, String nama, String nidn, String expertise) {
        if (idCard.isEmpty() || nama.isEmpty() || nidn.isEmpty() || expertise.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(view, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        Lecturer l = new Lecturer(idCard, nama, nidn, expertise);
        boolean sukses = lecturerDao.simpan(l);
        
        if (sukses) {
            JOptionPane.showMessageDialog(view, "Data Dosen Berhasil Disimpan ke Database!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Menyimpan Data Dosen!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Method untuk menghapus data dosen
    public boolean delete(JFrame view, String idCard) {
         boolean sukses = lecturerDao.hapus(idCard);
        if (sukses) {
            JOptionPane.showMessageDialog(view, "Data Dosen Berhasil Dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Menghapus Data Dosen!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Method untuk logika mengubah data dosen
    public boolean update(JFrame view, String idCard, String nama, String nidn, String expertise) {
        if (idCard.isEmpty() || nama.isEmpty() || nidn.isEmpty() || expertise.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        Lecturer l = new Lecturer(idCard, nama, nidn, expertise);
        boolean sukses = lecturerDao.ubah(l);
        
        if (sukses) {
            JOptionPane.showMessageDialog(view, "Data Dosen Berhasil Diubah!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Mengubah Data Dosen!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Method untuk logika pencarian data dosen
    public List<Lecturer> searchLecturers(String keyword) {
        return lecturerDao.cari(keyword);
    }
}
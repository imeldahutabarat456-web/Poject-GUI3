/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CourseDAO;
import model.Course;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author IMELDA
 */
public class CourseController {
   private final CourseDAO courseDao = new CourseDAO();

    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }

    public boolean insert(JFrame frame, String kode, String nama, String sksStr, String smt) {
        try {
            int sks = Integer.parseInt(sksStr);
            Course course = new Course();
            course.setKode(kode);
            
            // PERBAIKAN: Disamakan dengan struktur model Course milikmu
            course.setNamaMK(nama);         // Gunakan setNamaMK jika get-nya getNamaMK
            course.setSks(sks);
            course.setSemesterAngka(smt);   // Gunakan setSemesterAngka jika get-nya getSemesterAngka

            if (courseDao.simpan(course)) {
                JOptionPane.showMessageDialog(frame, "Mata kuliah berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(frame, "Gagal menyimpan ke database!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "SKS harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean update(JFrame frame, String kode, String nama, String sksStr, String smt) {
        return insert(frame, kode, nama, sksStr, smt);
    }

    public boolean delete(JFrame frame, String kode) {
        if (courseDao.hapus(kode)) {
            JOptionPane.showMessageDialog(frame, "Mata kuliah berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Gagal menghapus data dari database!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Course> searchCourses(String keyword) {
        return courseDao.getAll(); 
    }
}
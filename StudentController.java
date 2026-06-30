/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.StudentDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Student;
/**
 *
 * @author IMELDA
 */
public class StudentController {
    // Hubungkan ke StudentDAO untuk interaksi dengan MySQL
    private final StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentDAO();
    }

    public List<Student> getAllStudents() {

        return studentDAO.getAllStudents(); 
    }
    public List<Student> getStudentsByPage(int page, int limit) {
        // Menghitung nilai OFFSET SQL berdasarkan halaman aktif saat ini
        int offset = (page - 1) * limit;
        return studentDAO.getStudentsByPage(limit, offset);
    }

    public boolean insert(JFrame frame, String idCard, String nim, String nama, String prodi) {
        // 1. Validasi input sederhana
        if (idCard.isEmpty() || nim.isEmpty() || nama.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // 2. Simpan ke MySQL asli lewat StudentDAO
        boolean sukses = studentDAO.insert(idCard, nim, nama, prodi);
        
        if (sukses) {
            JOptionPane.showMessageDialog(frame, "Data mahasiswa berhasil disimpan ke MySQL!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Gagal menyimpan data ke MySQL (Cek duplikasi NIM/NIK)!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean update(JFrame frame, String idCard, String nim, String nama, String prodi) {
        if (nama.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nama dan Prodi tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
       boolean sukses = studentDAO.update(idCard, nim, nama, prodi);
        if (sukses) {
            JOptionPane.showMessageDialog(frame, "Data mahasiswa berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Gagal memperbarui data mahasiswa!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } 

    public boolean delete(JFrame frame, String nim) {
      if (nim == null || nim.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "NIM tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    boolean sukses = studentDAO.delete(nim);
    if (sukses) {
        JOptionPane.showMessageDialog(frame, "Data mahasiswa berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        return true;
    } else {
        JOptionPane.showMessageDialog(frame, "Gagal menghapus data mahasiswa!", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    public List<Student> searchStudents(String keyword) {
        // TODO: Jika ingin fitur Cari berfungsi di database, tambahkan method search di StudentDAO
        return new ArrayList<>();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
/**
 *
 * @author IMELDA
 */
public class StudentDAO {
  private final Connection conn;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());

    public StudentDAO() {
        this.conn = Koneksi.getKoneksi(); // Memanggil koneksi database
    }

    // 1. Fungsi Tambah Data (Insert)
    public boolean insert(String nik, String nim, String nama, String prodi) {
        String query = "INSERT INTO mahasiswa (nik, nim, nama, prodi) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nik);
            ps.setString(2, nim);
            ps.setString(3, nama);
            ps.setString(4, prodi);
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error saat simpan data mahasiswa", ex);
            return false;
        }
    }

    // 2. Fungsi Ambil Semua Data (Disesuaikan penamaannya dengan Controller)
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM mahasiswa";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Student s = new Student(
                    rs.getString("nik"),
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("prodi")
                );
                list.add(s);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error saat mengambil semua data mahasiswa", ex);
        }
        return list;
    }

    // 3. Fungsi Pagination (Mendukung LIMIT dan OFFSET untuk tombol Prev/Next)
    public List<Student> getStudentsByPage(int limit, int offset) {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM mahasiswa LIMIT ? OFFSET ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Student s = new Student(
                        rs.getString("nik"),
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("prodi")
                    );
                    list.add(s);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error saat mengambil pagination mahasiswa", ex);
        }
        return list;
    }

    // 4. Fungsi Ubah Data (Update) berdasarkan NIM sebagai Primary Key
    public boolean update(String nik, String nim, String nama, String prodi) {
        String query = "UPDATE mahasiswa SET nik = ?, nama = ?, prodi = ? WHERE nim = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nik);
            ps.setString(2, nama);
            ps.setString(3, prodi);
            ps.setString(4, nim);
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error saat memperbarui data mahasiswa", ex);
            return false;
        }
    }

    // 5. Fungsi Hapus Data (Delete) berdasarkan NIM
    public boolean delete(String nim) {
        String query = "DELETE FROM mahasiswa WHERE nim = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nim);
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error saat menghapus data mahasiswa", ex);
            return false;
        }
    }

    // 6. Fungsi Cari Data berdasarkan Nama atau NIM
    public List<Student> searchStudents(String keyword) {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM mahasiswa WHERE nama LIKE ? OR nim LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            String wildcard = "%" + keyword + "%";
            ps.setString(1, wildcard);
            ps.setString(2, wildcard);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Student s = new Student(
                        rs.getString("nik"),
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("prodi")
                    );
                    list.add(s);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error saat mencari data mahasiswa", ex);
        }
        return list;
    }
}  
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Config.Koneksi; // Mengimpor koneksi database utama kamu
import model.Lecturer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author IMELDA
 */
public class LecturerDAO {
   private final Connection conn;
    private static final Logger logger = Logger.getLogger(LecturerDAO.class.getName());

    public LecturerDAO() {
        this.conn = Koneksi.getKoneksi(); // Menggunakan koneksi terpusat dari Config.Koneksi
    }

    // 1. Ambil Semua Data Dosen (Untuk JTable)
    public List<Lecturer> getAll() {
        List<Lecturer> list = new ArrayList<>();
        String sql = "SELECT * FROM dosen"; 
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Lecturer l = new Lecturer(
                    rs.getString("id_card"), 
                    rs.getString("nama"),
                    rs.getString("nidn"),
                    rs.getString("expertise")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error saat mengambil semua data dosen", e);
        }
        return list;
    }

    // 2. Fungsi Pagination (Mendukung tombol Prev & Next halaman)
    public List<Lecturer> getLecturersByPage(int limit, int offset) {
        List<Lecturer> list = new ArrayList<>();
        String sql = "SELECT * FROM dosen LIMIT ? OFFSET ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Lecturer l = new Lecturer(
                        rs.getString("id_card"),
                        rs.getString("nama"),
                        rs.getString("nidn"),
                        rs.getString("expertise")
                    );
                    list.add(l);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error saat mengambil pagination data dosen", e);
        }
        return list;
    }

    // 3. Simpan Data Dosen Baru (Tombol Simpan)
    public boolean simpan(Lecturer l) {
        String sql = "INSERT INTO dosen (id_card, nama, nidn, expertise) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getIdCard());
            ps.setString(2, l.getNama());
            ps.setString(3, l.getNidn());
            ps.setString(4, l.getExpertise());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error saat menyimpan data dosen", e);
            return false;
        }
    }

    // 4. Hapus Data Dosen (Tombol Hapus)
    public boolean hapus(String idCard) {
        String sql = "DELETE FROM dosen WHERE id_card = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idCard);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error saat menghapus data dosen", e);
            return false;
        }
    }

    // 5. Ubah Data Dosen (Tombol Edit)
    public boolean ubah(Lecturer l) {
        String sql = "UPDATE dosen SET nama = ?, nidn = ?, expertise = ? WHERE id_card = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getNama());
            ps.setString(2, l.getNidn());
            ps.setString(3, l.getExpertise());
            ps.setString(4, l.getIdCard());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error saat mengubah data dosen", e);
            return false;
        }
    }

    // 6. Cari Data Dosen (Kolom Pencarian)
    public List<Lecturer> cari(String keyword) {
        List<Lecturer> list = new ArrayList<>();
        String sql = "SELECT * FROM dosen WHERE nama LIKE ? OR id_card LIKE ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            String wildcard = "%" + keyword + "%";
            ps.setString(1, wildcard);
            ps.setString(2, wildcard);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Lecturer l = new Lecturer(
                        rs.getString("id_card"),
                        rs.getString("nama"),
                        rs.getString("nidn"),
                        rs.getString("expertise")
                    );
                    list.add(l);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error saat mencari data dosen", e);
        }
        return list;
    }
}
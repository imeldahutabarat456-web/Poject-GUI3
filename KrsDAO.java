package DAO;

import Config.Koneksi;
import model.KRS;
import model.Course;
import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KrsDAO {

    // CREATE: Simpan Data
    public boolean simpan(KRS krs) {
      String sql =
        "INSERT INTO krs " +
        "(nim,kode_mk,semester,nilai_sikap,nilai_uts,nilai_uas,nilai_akhir,nilai_huruf) " +
        "VALUES (?,?,?,?,?,?,?,?)";

    try(
        Connection conn = Koneksi.getKoneksi();
        PreparedStatement ps =
            conn.prepareStatement(sql))
    {

        System.out.println("DATABASE = "
                + conn.getCatalog());

        System.out.println("NIM = "
                + krs.getStudent().getNim());

        System.out.println("KODE = "
                + krs.getCourse().getKode());

        System.out.println("SEMESTER = "
                + krs.getSemester());

        System.out.println("SIKAP = "
                + krs.getNilaiSikap());

        System.out.println("UTS = "
                + krs.getNilaiUts());

        System.out.println("UAS = "
                + krs.getNilaiUas());

        System.out.println("AKHIR = "
                + krs.getNilaiAkhir());

        System.out.println("HURUF = "
                + krs.getNilaiHuruf());

        ps.setString(1,
                krs.getStudent().getNim());

        ps.setString(2,
                krs.getCourse().getKode());

        ps.setString(3,
                krs.getSemester());

        ps.setDouble(4,
                krs.getNilaiSikap());

        ps.setDouble(5,
                krs.getNilaiUts());

        ps.setDouble(6,
                krs.getNilaiUas());

        ps.setDouble(7,
                krs.getNilaiAkhir());

        ps.setString(8,
                krs.getNilaiHuruf());

        int hasil = ps.executeUpdate();

        System.out.println(
                "BARIS TERSIMPAN = "
                + hasil);

        return hasil > 0;

    } catch(Exception e){
        e.printStackTrace();
        return false;
    }
}
   
    // READ: Ambil Semua Data
    public List<KRS> ambilSemua() {
        List<KRS> list = new ArrayList<>();

    String sql =
            "SELECT " +
            "k.nim, " +
            "k.kode_mk, " +
            "k.semester, " +
            "k.nilai_sikap, " +
            "k.nilai_uts, " +
            "k.nilai_uas, " +
            "k.nilai_akhir, " +
            "k.nilai_huruf, " +
            "m.nama AS nama_mhs, " +
            "m.prodi, " +
            "mk.nama_mk " +
            "FROM krs k " +
            "INNER JOIN mahasiswa m ON k.nim=m.nim " +
            "INNER JOIN matakuliah mk ON k.kode_mk=mk.kode_mk";

    try(
            Connection conn = Koneksi.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)
    ){

        while(rs.next()){

            Student mhs = new Student();
            mhs.setNim(rs.getString("nim"));
            mhs.setNama(rs.getString("nama_mhs"));
            mhs.setProdi(rs.getString("prodi"));

            Course mk = new Course();
            mk.setKode(rs.getString("kode_mk"));
            mk.setNamaMK(rs.getString("nama_mk"));

            KRS k = new KRS();

            k.setStudent(mhs);
            k.setCourse(mk);
            k.setSemester(rs.getString("semester"));
            k.setNilaiSikap(rs.getDouble("nilai_sikap"));
            k.setNilaiUts(rs.getDouble("nilai_uts"));
            k.setNilaiUas(rs.getDouble("nilai_uas"));
            k.setNilaiAkhir(rs.getDouble("nilai_akhir"));
            k.setNilaiHuruf(rs.getString("nilai_huruf"));

            System.out.println(
                    mhs.getNama() + " | " +
                    mk.getNamaMK() + " | " +
                    k.getNilaiHuruf());

            list.add(k);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return list;
    }

    // UPDATE: Update Data Nilai
    public boolean update(KRS krs) {
        String sql =  "UPDATE krs SET "
                + "nilai_sikap=?, "
                + "nilai_uts=?, "
                + "nilai_uas=?, "
                + "nilai_akhir=?, "
                + "nilai_huruf=? "
                + "WHERE nim=? AND kode_mk=?";
        try (Connection conn = Koneksi.getKoneksi(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, krs.getNilaiSikap());
            ps.setDouble(2, krs.getNilaiUts());
            ps.setDouble(3, krs.getNilaiUas());
            ps.setDouble(4, krs.getNilaiAkhir());
            ps.setString(5, krs.getNilaiHuruf());
            ps.setString(6, krs.getStudent().getNim());
            ps.setString(7, krs.getCourse().getKode());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) { 
             e.printStackTrace();
             return false; }
    }

    // DELETE: Hapus Data
    public boolean hapus(String nim, String kodeMk) {
        String sql = "DELETE FROM krs WHERE nim = ? AND kode_mk = ?";
        try (Connection conn = Koneksi.getKoneksi(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nim);
            ps.setString(2, kodeMk);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { 
             e.printStackTrace();
             return false; }
    }
}
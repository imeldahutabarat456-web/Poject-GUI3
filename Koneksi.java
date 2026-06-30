package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    // konfigurasi database
    private static final String URL =
            "jdbc:mysql://localhost:3306/db_akademik"
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=Asia/Jakarta";

    private static final String USER = "root";
    private static final String PASSWORD = "Imelda456";

    // method koneksi
    public static Connection getKoneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println(
                    "Berhasil terkoneksi ke database : "
                    + conn.getCatalog());

            return conn;

        } catch (ClassNotFoundException e) {
            System.out.println(
                    "Driver MySQL tidak ditemukan!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println(
                    "Gagal koneksi database!");
            e.printStackTrace();
        }

        return null;
    }

    // untuk testing
    public static void main(String[] args) {
        Connection conn = getKoneksi();

        if (conn != null) {
            System.out.println("Koneksi sukses");
        } else {
            System.out.println("Koneksi gagal");
        }
    }
}
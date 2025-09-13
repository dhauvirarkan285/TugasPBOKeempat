import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    protected Connection conn;

    public Koneksi() {
        try {
            // Sesuaikan nama DB, user, password
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Database_PBO";
            String user = "postgres";
            String password = "ABCDE12345VWXYZ";  
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi berhasil!");
            } catch (ClassNotFoundException e) {
        System.out.println("Driver PostgreSQL tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }
}
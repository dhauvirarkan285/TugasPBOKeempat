import java.sql.Statement;

public class MembuatTabel extends Koneksi {
    public void buatTabel() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS siswa("
                    + "nis CHAR(10) PRIMARY KEY, "
                    + "nama VARCHAR(100), "
                    + "kelas VARCHAR(50), "
                    + "umur INT)";
            stmt.executeUpdate(sql);
            System.out.println("Tabel berhasil dibuat!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

import java.sql.ResultSet;
import java.sql.Statement;

public class MembacaData extends Koneksi {
    public void tampilkanData() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM siswa";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("nis") + " | "
                        + rs.getString("nama") + " | "
                        + rs.getString("kelas") + " | "
                        + rs.getInt("umur"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

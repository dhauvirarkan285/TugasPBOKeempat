import java.sql.PreparedStatement;

public class MenghapusData extends Koneksi {
    public void hapusData(String nis) {
        try {
            String sql = "DELETE FROM siswa WHERE nis=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nis);
            pst.executeUpdate();
            System.out.println("Data berhasil dihapus!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

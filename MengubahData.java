import java.sql.PreparedStatement;

public class MengubahData  extends Koneksi {
    public void ubahData(String nis, String namaBaru) {
    try {
        String sql = "UPDATE siswa SET nama=? WHERE nis=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, namaBaru);
        pst.setString(2, nis);
        pst.executeUpdate();
        System.out.println("Data berhasil diupdate!");
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

}

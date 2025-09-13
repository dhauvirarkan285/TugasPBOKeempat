import java.sql.PreparedStatement;

public class MenambahkanData extends Koneksi {
    public void tambahData(String nis, String nama, String kelas, int umur) {
        try {
            String sql = "INSERT INTO siswa (nis, nama, kelas, umur) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nis);
            pst.setString(2, nama);
            pst.setString(3, kelas);
            pst.setInt(4, umur);
            pst.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


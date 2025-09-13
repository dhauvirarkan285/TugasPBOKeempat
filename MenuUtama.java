import java.util.Scanner;

public class MenuUtama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MembuatTabel bt = new MembuatTabel();
        MenambahkanData td = new MenambahkanData();
        MengubahData ud = new MengubahData();
        MembacaData bd = new MembacaData();
        MenghapusData xyz = new MenghapusData();

        bt.buatTabel(); // pastikan tabel dibuat dulu

        int pilih;
        do {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Read Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine(); // biar ga ke-skip

            switch (pilih) {
                case 1:
                    System.out.print("NIS: "); String nis = sc.nextLine();
                    System.out.print("Nama: "); String nama = sc.nextLine();
                    System.out.print("Kelas: "); String kelas = sc.nextLine();
                    System.out.print("Umur: "); int umur = sc.nextInt();
                    td.tambahData(nis, nama, kelas, umur);
                    break;
                case 2:
                    System.out.print("NIS yang mau diupdate: "); String nisS = sc.nextLine();
                    System.out.print("Nama baru: "); String namaBaru = sc.nextLine();
                    ud.ubahData(nisS, namaBaru);
                    break;
                case 3:
                    System.out.print("NIS yang mau dihapus: "); String nisX = sc.nextLine();
                    xyz.hapusData(nisX);
                    break;
                case 4:
                    bd.tampilkanData();
                    break;
                case 0:
                    System.out.println("Keluar program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);
    }
}

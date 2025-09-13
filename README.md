Sistem Manajemen Data Siswa
1. Deskripsi
Program ini dibuat untuk mengelola data siswa menggunakan Java (NetBeans) yang terhubung dengan PostgreSQL.  
Fitur utama: menambah (Insert), membaca (Read), mengubah (Update), dan menghapus (Delete) data siswa.

2. Tujuan
- Memahami koneksi database dengan Java (JDBC)
- Menerapkan konsep inheritance dalam OOP
- Membuat sistem CRUD sederhana dengan menu interaktif

3. Dasar Teori
- Inheritance: Class `Koneksi` sebagai parent, diturunkan ke class CRUD (`MembuatTabel`, `MenambahkanData`, dll).  
- CRUD: Operasi dasar database (Create, Read, Update, Delete).  
- ResultSet: Digunakan hanya untuk `SELECT` (membaca data).  

4. Alat & Bahan
- NetBeans IDE 8.2
- PostgreSQL 16.10
- pgAdmin 4
- PostgreSQL JDBC Driver (42.x.x)

5. Struktur Database
Database: `Database_PBO`  
Tabel: `siswa`  

| Kolom | Tipe Data    | Keterangan   |
|-------|--------------|--------------|
| nis   | CHAR(10)     | Primary Key  |
| nama  | VARCHAR(100) | Nama lengkap |
| kelas | VARCHAR(50)  | Kelas siswa  |
| umur  | INT          | Umur siswa   |

6. Implementasi
   a. Buat database `Database_PBO` di PostgreSQL
   b. Hubungkan ke Java dengan JDBC (`Koneksi.java`)
   c. Buat tabel `siswa` otomatis lewat class `MembuatTabel`
   d. Jalankan menu utama (`MenuUtama.java`) dengan pilihan:  
   - 1: Insert Data  
   - 2: Update Data  
   - 3: Delete Data  
   - 4: Read Data  
   - 0: Keluar  

7. Contoh Output
=== MENU MAHASISWA ===
1. Insert Data
2. Update Data
3. Delete Data
4. Read Data
0. Keluar
Pilih:

8. Kesimpulan
Dari tugas ini saya belajar:
- Cara menghubungkan Java dengan PostgreSQL
- Cara membuat operasi CRUD dengan PreparedStatement
- Cara menerapkan inheritance di Java
- Pentingnya ResultSet hanya untuk operasi SELECT

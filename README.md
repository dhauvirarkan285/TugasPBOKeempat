# TugasPBOKeempat
Pada kesempatan kali ini, saya akan membahas mengenai apa sih Tugas PBO pertemuan keempat. Dimana tugasnya adalah menghubungkan NetBeans dengan PostgreSQL. Pada NetBeans membuat Class yang berisi: Create untuk 
membuat tabel, Insert untuk menambahkan data, Update untuk memperbarui atau mengubah isi data, Read/Selection untuk menampilkan data, serta berupa Menu Interaktif yang berisi empat pilihan untuk membuat tabel, 
menambahkan data, memperbarui/mengubah isi data, atau menampilkan data. Connected menggunakan extends dan result set hanya untuk select
Sistem Manajemen Data Siswa dengan Koneksi PostgreSQL

1. Deskripsi Project
Project ini adalah implementasi Pemrograman Berorientasi Objek (PBO) yang menghubungkan aplikasi Java NetBeans dengan database PostgreSQL. Sistem ini dirancang untuk mengelola data siswa dengan operasi CRUD (Create, Read, Update, Delete) lengkap menggunakan konsep inheritance dan encapsulation.

2. Tujuan Pembelajaran
Tugas ini bertujuan untuk:
- Memahami konsep Inheritance dalam PBO dengan penggunaan extends
- Mengimplementasikan koneksi database PostgreSQL dengan Java
- Menerapkan operasi CRUD dengan prepared statements dan statement
- Membangun interface menu interaktif untuk user
- Mengelola ResultSet dengan baik (khusus untuk operasi SELECT)

3. Struktur Project
3.1. Class Organization
src/
├── Koneksi.java                    # Base class (Parent Class) untuk koneksi DB
├── MembuatTabel.java              # Class untuk membuat tabel siswa
├── MenambahkanData.java           # Class untuk menambah data siswa
├── MengubahData.java              # Class untuk mengubah data siswa
├── MembacaData.java               # Class untuk membaca/menampilkan data
├── MenghapusData.java             # Class untuk menghapus data siswa
└── MenuUtama.java                 # Main class dengan menu interaktif

4. Implementasi Konsep PBO
a. Inheritance (Pewarisan)
Semua class operasi database mewarisi dari class Koneksi:
java// Parent Class - Base Connection
public class Koneksi {
    protected Connection conn;  // Protected agar bisa diakses child class
    public Koneksi() {
        // Inisialisasi koneksi PostgreSQL
        // Database: Database_PBO
        // User: postgres
        // Password: ABCDE12345VWXYZ
    }
}
// Child Classes - Semua extends dari Koneksi
public class MembuatTabel extends Koneksi { ... }
public class MenambahkanData extends Koneksi { ... }
public class MengubahData extends Koneksi { ... }
public class MembacaData extends Koneksi { ... }
public class MenghapusData extends Koneksi { ... }
Keuntungan inheritance ini:
- Semua child class otomatis memiliki akses ke database connection (conn)
- Code reusability yang tinggi - tidak perlu tulis ulang kode koneksi
- Maintenance yang lebih mudah - hanya update di satu tempat
- Konsistensi dalam pengelolaan koneksi database

b. Encapsulation
Database connection (conn) di-protected agar hanya bisa diakses oleh child class
Setiap class memiliki responsibility yang spesifik
Method-method dibuat public untuk interface yang jelas

c. Abstraction
User tidak perlu tahu detail implementasi database connection
Interface yang sederhana melalui method calls

5. Struktur Database
Database: Database_PBO
Tabel: siswa
Kolom, Tipe Data, Keterangan.
- nis, CHAR(10) PRIMARY KEY, Nomor Induk Siswa (unik)
- nama, VARCHAR(100), Nama lengkap siswa
- kelas, VARCHAR(50), Kelas siswa
- umur, INTEGER, Umur siswa
Total: 4 kolom (sesuai minimal 4 kolom yang diminta)

6. Fitur Aplikasi
Menu Interaktif
Aplikasi menyediakan menu pilihan yang user-friendly:
=== MENU MAHASISWA ===
1. Insert Data
2. Update Data  
3. Delete Data
4. Read Data
0. Keluar
a. CREATE - Pembuatan Tabel (MembuatTabel.java)

Extends: Koneksi
Fungsi: Membuat tabel siswa jika belum ada
SQL: CREATE TABLE IF NOT EXISTS
Auto-run: Dijalankan otomatis saat aplikasi dimulai

javapublic class MembuatTabel extends Koneksi {
    public void buatTabel() {
        // Menggunakan Statement untuk DDL
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS siswa(...)";
        stmt.executeUpdate(sql);
    }
}
b. INSERT - Menambah Data (MenambahkanData.java)

Extends: Koneksi
Input: NIS, Nama, Kelas, Umur
SQL: Menggunakan PreparedStatement untuk keamanan
Validasi: Primary key constraint pada NIS

javapublic class MenambahkanData extends Koneksi {
    public void tambahData(String nis, String nama, String kelas, int umur) {
        // Menggunakan PreparedStatement untuk mencegah SQL injection
        PreparedStatement pst = conn.prepareStatement(sql);
        // Parameter binding untuk keamanan
    }
}
c. READ/SELECT - Menampilkan Data (MembacaData.java)
Extends: Koneksi
Penggunaan ResultSet: Hanya di class ini (sesuai requirement)
Output: Format yang rapi dengan separator "|"
javapublic class MembacaData extends Koneksi {
    public void tampilkanData() {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM siswa";
        ResultSet rs = stmt.executeQuery(sql);  // HANYA di sini ResultSet digunakan
        
        while (rs.next()) {
            // Mengambil data dengan rs.getString() dan rs.getInt()
            System.out.println(rs.getString("nis") + " | " + 
                             rs.getString("nama") + " | " + 
                             rs.getString("kelas") + " | " + 
                             rs.getInt("umur"));
        }
    }
}
d. UPDATE - Mengubah Data (MengubahData.java)
Extends: Koneksi
Fitur: Update nama siswa berdasarkan NIS
SQL: PreparedStatement dengan WHERE clause
Validasi: Cek NIS yang akan diupdate

javapublic class MengubahData extends Koneksi {
    public void ubahData(String nis, String namaBaru) {
        // Update hanya field nama berdasarkan NIS
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, namaBaru);
        pst.setString(2, nis);
    }
}
e. DELETE - Menghapus Data (MenghapusData.java)
Extends: Koneksi
Fitur: Hapus siswa berdasarkan NIS
SQL: PreparedStatement dengan WHERE clause
Keamanan: Parameter binding untuk mencegah SQL injection

javapublic class MenghapusData extends Koneksi {
    public void hapusData(String nis) {
        // Hapus data berdasarkan NIS
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nis);
    }
}

7. Setup dan Instalasi
Prerequisites
A. NetBeans IDE
B. PostgreSQL Database
C. PostgreSQL JDBC Driver
D. Java JDK 8 atau lebih tinggi

Langkah Instalasi
1. Setup Database PostgreSQL
sql-- Buat database baru
CREATE DATABASE Database_PBO;
-- Connect ke database
\c Database_PBO;

2. Konfigurasi Koneksi (sudah sesuai dengan kode)
File Koneksi.java sudah dikonfigurasi dengan:
javaString url = "jdbc:postgresql://localhost:5432/Database_PBO";
String user = "postgres";
String password = "ABCDE12345VWXYZ";

4. Add PostgreSQL JDBC Driver ke NetBeans
Download postgresql-42.x.x.jar
Right-click project → Properties
Libraries → Add JAR/Folder
Select PostgreSQL JDBC driver

5. Run Application
Set MenuUtama.java sebagai main class
Run → Program akan:
Otomatis membuat tabel siswa
Menampilkan menu interaktif
Siap untuk operasi CRUD

8. Cara Penggunaan
a. First Run
- Jalankan MenuUtama.java
- Tabel siswa akan dibuat otomatis
- Menu utama akan muncak
- Siap untuk input data

b. Navigasi Menu
- Pilihan 1: Insert Data - Tambah siswa baru dengan input NIS, Nama, Kelas, Umur
- Pilihan 2: Update Data - Update nama siswa berdasarkan NIS
- Pilihan 3: Delete Data - Hapus siswa berdasarkan NIS
- Pilihan 4: Read Data - Tampilkan semua data siswa
- Pilihan 0: Keluar dari aplikasi

9. Contoh Flow Penggunaan
   a. Pilih "4" untuk melihat data siswa (awalnya kosong)
   b. Pilih "1" untuk menambah data siswa:
   - NIS: 010
   - Nama: Jerikho
   - Kelas: XI-J
   - Umur: 17
   c. Pilih "4" lagi untuk melihat data yang baru ditambah
   d. Pilih "2" untuk update nama siswa dengan NIS tertentu
   e. Pilih "3" untuk menghapus data siswa

10. Compliance dengan Requirements
Requirement, Status, Implementation
- Connect NetBeans & PostgreSQL, DONE, Koneksi.java dengan driver PostgreSQL
- Class Create, DONE, MembuatTabel.java extends Koneksi
- Class Insert, DONE, MenambahkanData.java extends Koneksi
- Class Update, DONE, MengubahData.java extends Koneksi
- Class Read/Select, DONE, MembacaData.java extends Koneksi
- Class Delete, DONE, MenghapusData.java extends Koneksi
- Menu Interaktif, DONE, MenuUtama.java dengan switch-case menu
- Insert 10 data, READY, Bisa dilakukan manual via menu pilihan 1
- Minimal 4 kolom, DONE, 4 kolom: nis, nama, kelas, umur
- Pakai Extends, DONE, Semua operation class extends Koneksi
- ResultSet hanya untuk SELECT, DONE, Hanya digunakan di MembacaData.java

11. Security & Best Practices
SQL Injection Prevention
- PreparedStatement: Digunakan untuk INSERT, UPDATE, DELETE
- Parameter Binding: Semua input user di-bind sebagai parameter
- Input Validation: Tipe data sesuai dengan database schema

Connection Management
- Single Connection: Dikelola di parent class Koneksi
- Error Handling: Try-catch untuk semua database operations
- Resource Management: Proper handling untuk Statement dan ResultSet

12. Keunggulan Design
Code Organization
- Separation of Concerns: Setiap class memiliki tanggung jawab spesifik
- Single Responsibility Principle: Satu class, satu fungsi utama
- DRY (Don't Repeat Yourself): Inheritance mengurangi code duplication

Database Design
- Primary Key: NIS sebagai unique identifier
- Data Types: Sesuai dengan kebutuhan (CHAR untuk NIS, VARCHAR untuk text)
- Constraints: Primary key constraint untuk data integrity

User Experience
- Simple Menu: Easy navigation dengan angka
- Clear Output: Format output yang rapi dengan separator
- Input Validation: Scanner untuk input yang aman
- Error Messages: Informative error handling

13. Pembelajaran yang Dicapai
Melalui project ini, mahasiswa telah berhasil:
- Menerapkan Inheritance: Semua operation class mewarisi dari Koneksi
- Memahami Database Connectivity: JDBC PostgreSQL implementation
- Mengimplementasikan CRUD Operations:
  a. CREATE: MembuatTabel.java
  b. INSERT: MenambahkanData.java
  c. READ: MembacaData.java
  d. UPDATE: MengubahData.java
  e. DELETE: MenghapusData.java
- Mengelola ResultSet dengan baik: Hanya digunakan untuk SELECT operations di MembacaData.java
- Membangun User Interface: Menu interaktif yang user-friendly di MenuUtama.java
- Security Awareness: Menggunakan PreparedStatement untuk mencegah SQL injection
- Code Organization: Clean separation of concerns dengan inheritance pattern

14. Teknologi yang Digunakan
- Bahasa Pemrograman: Java
- IDE: NetBeans
- Database: PostgreSQL
- Database: Database_PBO
- JDBC Driver: PostgreSQL JDBC Driver
- Design Pattern: Inheritance pattern
- Architecture: Simple layered architecture dengan base class

15. Detail Implementasi
- Connection String
javaString url = "jdbc:postgresql://localhost:5432/Database_PBO";
String user = "postgres";
String password = "ABCDE12345VWXYZ";
- Table Structure
sqlCREATE TABLE IF NOT EXISTS siswa(
    nis CHAR(10) PRIMARY KEY, 
    nama VARCHAR(100), 
    kelas VARCHAR(50), 
    umur INT
)
- Inheritance Pattern
Koneksi (Base Class)
├── MembuatTabel extends Koneksi
├── MenambahkanData extends Koneksi  
├── MengubahData extends Koneksi
├── MembacaData extends Koneksi
└── MenghapusData extends Koneksi

16. Kesimpulan
Project Sistem Manajemen Siswa ini berhasil mengimplementasikan semua requirement tugas PBO dengan menggabungkan konsep inheritance, database connectivity, dan user interaction yang baik.
Key Achievements:
- Inheritance Implementation: Semua class operation extends dari Koneksi
- CRUD Operations: Complete Create, Read, Update, Delete functionality
- ResultSet Management: Hanya digunakan di MembacaData.java untuk SELECT
- Interactive Menu: User-friendly menu system di MenuUtama.java
- Database Integration: Successfully connected to PostgreSQL
- Security: PreparedStatement untuk prevent SQL injection

Sistem ini tidak hanya memenuhi requirement teknis tetapi juga menunjukkan pemahaman yang baik tentang konsep OOP melalui inheritance pattern, serta implementasi database programming yang aman dan efisien.

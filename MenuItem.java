// Kelas MenuItem adalah kelas abstrak yang menjadi dasar untuk semua item menu
// Konsep OOP yang digunakan: Abstraksi dan Enkapsulasi
abstract class MenuItem {

    // Atribut private (enkapsulasi) agar tidak bisa diakses langsung di luar kelas
    private String nama;      // Nama item menu
    private double harga;     // Harga item
    private String kategori;  // Kategori item (Makanan, Minuman, Diskon)

    // Constructor untuk mengisi nilai atribut saat objek dibuat
    public MenuItem(String nama, double harga, String kategori) {
        this.nama = nama;          // Set nama item
        this.harga = harga;        // Set harga item
        this.kategori = kategori;  // Set kategori item
    }

    // Getter untuk mengambil nama item
    public String getNama() {
        return nama;
    }

    // Getter untuk mengambil harga item
    public double getHarga() {
        return harga;
    }

    // Getter untuk kategori item (digunakan untuk cek tipe item)
    public String getKategori() {
        return kategori;
    }

    // Metode abstrak yang wajib diimplementasikan oleh kelas turunan
    // Polymorphism terjadi saat setiap kelas turunan memiliki cara sendiri menampilkan menu
    public abstract void tampilMenu();

    // Mengubah objek menjadi format teks untuk disimpan ke file
    @Override
    public String toString() {
        return nama + ";" + harga + ";" + kategori;
    }
}

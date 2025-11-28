// Kelas Minuman adalah subkelas dari MenuItem
// Menggunakan konsep Inheritance
class Minuman extends MenuItem {

    // Atribut tambahan khusus untuk minuman
    private String jenisMinuman;

    // Constructor dengan atribut tambahan
    public Minuman(String nama, double harga, String jenisMinuman) {
        super(nama, harga, "Minuman"); // Set kategori = Minuman
        this.jenisMinuman = jenisMinuman;
    }

    // Implementasi metode tampilMenu
    @Override
    public void tampilMenu() {
        System.out.println("[Minuman] " + getNama() + " - Rp" + getHarga() + " (" + jenisMinuman + ")");
    }

    // Format penyimpanan ke file
    @Override
    public String toString() {
        return "Minuman;" + getNama() + ";" + getHarga() + ";" + jenisMinuman;
    }
}

// Kelas Makanan adalah subkelas dari MenuItem
// Menggunakan konsep Inheritance
class Makanan extends MenuItem {

    // Atribut tambahan khusus untuk makanan
    private String jenisMakanan;

    // Constructor Makanan akan memanggil constructor MenuItem menggunakan super()
    public Makanan(String nama, double harga, String jenisMakanan) {
        super(nama, harga, "Makanan");  // Mengisi data ke MenuItem
        this.jenisMakanan = jenisMakanan; // Mengisi atribut khusus makanan
    }

    // Implementasi metode abstrak tampilMenu dari MenuItem
    // Menampilkan detail makanan ke layar
    @Override
    public void tampilMenu() {
        System.out.println("[Makanan] " + getNama() + " - Rp" + getHarga() + " (" + jenisMakanan + ")");
    }

    // Digunakan untuk menyimpan data ke file menu.txt
    @Override
    public String toString() {
        return "Makanan;" + getNama() + ";" + getHarga() + ";" + jenisMakanan;
    }
}

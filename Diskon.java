// Kelas Diskon adalah subkelas dari MenuItem
// Berfungsi untuk menambahkan potongan harga ke pesanan
class Diskon extends MenuItem {

    // Atribut tambahan: besar diskon dalam persen
    private double diskon;

    // Constructor Diskon
    public Diskon(String nama, double harga, double diskon) {
        super(nama, harga, "Diskon"); // Harga bisa diisi 0, karena diskon bukan item fisik
        this.diskon = diskon;
    }

    // Implementasi tampilMenu
    @Override
    public void tampilMenu() {
        System.out.println("[Diskon] " + getNama() + " - Potongan " + diskon + "%");
    }

    // Getter diskon
    public double getDiskon() {
        return diskon;
    }

    // Format penyimpanan ke file
    @Override
    public String toString() {
        return "Diskon;" + getNama() + ";" + getHarga() + ";" + diskon;
    }
}

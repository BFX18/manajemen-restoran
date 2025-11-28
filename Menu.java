import java.util.*;
import java.io.*;

// Kelas Menu mengatur seluruh daftar item menu restoran
// Menyimpan item dalam ArrayList
class Menu {

    // ArrayList digunakan sebagai struktur dinamis
    private ArrayList<MenuItem> daftarMenu = new ArrayList<>();

    // Menambahkan item baru ke daftar menu
    public void tambahItem(MenuItem item) {
        daftarMenu.add(item);
    }

    // Menampilkan semua item menu
    public void tampilkanMenu() {
        for (MenuItem item : daftarMenu) {
            item.tampilMenu(); // Polymorphism: setiap item menampilkan cara berbeda
        }
    }

    // Mencari item menu berdasarkan nama
    public MenuItem cariMenu(String nama) {
        for (MenuItem m : daftarMenu) {
            if (m.getNama().equalsIgnoreCase(nama)) {
                return m;
            }
        }
        return null; // Jika tidak ditemukan
    }

    // Menyimpan daftar menu ke file menu.txt
    public void simpanKeFile() throws Exception {
        PrintWriter pw = new PrintWriter(new FileWriter("menu.txt"));

        // Setiap item diubah menjadi teks (melalui toString)
        for (MenuItem m : daftarMenu) {
            pw.println(m.toString());
        }

        pw.close(); // Tutup file
    }

    // Memuat daftar menu dari file menu.txt
    public void muatDariFile() throws Exception {

        daftarMenu.clear(); // Kosongkan list lama

        BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
        String line;

        // Membaca setiap baris
        while ((line = br.readLine()) != null) {
            String[] data = line.split(";"); // Format: Tipe;Nama;Harga;AtributTambahan

            String tipe = data[0];    // Makanan / Minuman / Diskon
            String nama = data[1];
            double harga = Double.parseDouble(data[2]);

            // Membuat object sesuai tipe
            switch (tipe) {
                case "Makanan":
                    daftarMenu.add(new Makanan(nama, harga, data[3]));
                    break;

                case "Minuman":
                    daftarMenu.add(new Minuman(nama, harga, data[3]));
                    break;

                case "Diskon":
                    double diskonValue = Double.parseDouble(data[3]);
                    daftarMenu.add(new Diskon(nama, harga, diskonValue));
                    break;
            }
        }

        br.close(); // Tutup file
    }
}

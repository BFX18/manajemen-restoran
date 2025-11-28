import java.util.*;
import java.io.*;

// Kelas Pesanan mencatat semua item yang dipesan pelanggan
class Pesanan {

    // Menyimpan daftar pesanan
    private ArrayList<MenuItem> listPesanan = new ArrayList<>();

    // Menambahkan item yang dipesan ke list
    public void tambahPesanan(MenuItem item) {
        listPesanan.add(item);
    }

    // Menampilkan isi pesanan
    public void tampilkanPesanan() {
        for (MenuItem item : listPesanan) {
            item.tampilMenu();
        }
    }

    // Menghitung total pesanan + diskon
    public double hitungTotal() {
        double total = 0;        // Total harga makanan/minuman
        double totalDiskon = 0;  // Total diskon persen

        for (MenuItem item : listPesanan) {

            // Jika item adalah diskon
            if (item instanceof Diskon) {
                totalDiskon += ((Diskon) item).getDiskon();

            // Jika bukan diskon, tambahkan harga item
            } else {
                total += item.getHarga();
            }
        }

        // Jika ada diskon, kurangi total sesuai presentase
        if (totalDiskon > 0) {
            total = total - (total * totalDiskon / 100);
        }

        return total;
    }

    // Menyimpan struk ke file struk.txt
    public void simpanStruk() throws Exception {
        PrintWriter pw = new PrintWriter(new FileWriter("struk.txt"));

        pw.println("=== STRUK PEMBELIAN ===");

        // Tulis setiap item
        for (MenuItem m : listPesanan) {
            pw.println(m.getNama() + " - Rp" + m.getHarga());
        }

        // Total harga
        pw.println("\nTOTAL BAYAR: Rp" + hitungTotal());

        pw.close(); // Tutup file
    }
}

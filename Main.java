import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Scanner untuk input user
        Menu menu = new Menu();                 // Objek menu restoran
        Pesanan pesanan = new Pesanan();        // Objek pesanan pelanggan

        // Perulangan menu utama
        while (true) {

            // Tampilan menu utama
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Tambah Item Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Buat Pesanan");
            System.out.println("4. Hitung Total & Tampilkan Struk");
            System.out.println("5. Simpan Menu ke File");
            System.out.println("6. Muat Menu dari File");
            System.out.println("7. Keluar");
            System.out.print("Pilih: ");

            int pilih = input.nextInt();   // Pilihan user
            input.nextLine();              // Membersihkan buffer

            try {
                switch (pilih) {

                    // Tambah item baru
                    case 1:
                        System.out.println("Tambah: 1=Makanan, 2=Minuman, 3=Diskon");
                        int jenis = input.nextInt();
                        input.nextLine();

                        System.out.print("Nama: ");
                        String nama = input.nextLine();

                        System.out.print("Harga: ");
                        double harga = input.nextDouble();
                        input.nextLine();

                        if (jenis == 1) { // Tambah Makanan
                            System.out.print("Jenis makanan: ");
                            menu.tambahItem(new Makanan(nama, harga, input.nextLine()));

                        } else if (jenis == 2) { // Tambah Minuman
                            System.out.print("Jenis minuman: ");
                            menu.tambahItem(new Minuman(nama, harga, input.nextLine()));

                        } else if (jenis == 3) { // Tambah Diskon
                            System.out.print("Diskon (%): ");
                            double diskon = input.nextDouble();
                            menu.tambahItem(new Diskon(nama, harga, diskon));
                        }
                        break;

                    // Tampilkan menu restoran
                    case 2:
                        menu.tampilkanMenu();
                        break;

                    // Tambah item ke pesanan pelanggan
                    case 3:
                        System.out.print("Masukkan nama item: ");
                        MenuItem item = menu.cariMenu(input.nextLine());

                        // Jika item tidak ditemukan → exception
                        if (item == null) {
                            throw new Exception("Item tidak ditemukan!");
                        }

                        pesanan.tambahPesanan(item);
                        break;

                    // Hitung total dan tampilkan struk
                    case 4:
                        pesanan.tampilkanPesanan();
                        System.out.println("Total: Rp" + pesanan.hitungTotal());
                        pesanan.simpanStruk();
                        break;

                    // Simpan menu ke file menu.txt
                    case 5:
                        menu.simpanKeFile();
                        System.out.println("Menu disimpan!");
                        break;

                    // Muat menu dari file
                    case 6:
                        menu.muatDariFile();
                        System.out.println("Menu berhasil dimuat dari file!");
                        break;

                    // Keluar program
                    case 7:
                        return;
                }

            // Menangkap semua error
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

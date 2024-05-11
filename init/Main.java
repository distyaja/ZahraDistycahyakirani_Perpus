package init;

import init.Buku;
import utils.Data;
import utils.Siswa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean Loop = true;
        new Data().Memuat();
        while (Loop){
            System.out.println("Pilihan yang tersedia:");
            System.out.println("0. Keluar dan Simpan");
            System.out.println("1. Tampilkan List Peminjaman");
            System.out.println("2. Tambah Peminjam");
            System.out.println("3. Kembalikan Peminjaman");
            System.out.println("4. Tampilkan List Siswa");
            System.out.println("5. Tampilkan List Petugas");
            System.out.println("6. Tampilkan List Buku");
            System.out.println("7. Tambah Siswa");
            System.out.println("8. Tambah Petugas");
            System.out.println("9. Tambah Buku");
            System.out.println("10. Simpan");
            System.out.print("Pilih Nomer?:");
            int choice = input.nextInt();
            switch (choice) {
                case 0 -> {
                    Loop = false;
                    new Data().Simpan();
                }
                case 1 -> TampilListPeminjaman();
                case 2 -> TambahPeminjam();
                case 3 -> Kembalikan();
                case 4 -> TampilListSiswa();
                case 5 -> TampilListPetugas();
                case 6 -> TampilListBuku();
                case 7 -> TambahSiswa();
                case 8 -> TambahPetugas();
                case 9 -> TambahBuku();
                case 10 -> new Data().Simpan();
                default -> System.out.println("Input tidak valid");
            }
        }
    }

    private static void TampilListSiswa(){
        ArrayList<String> namaSiswa = init.Siswa.getNama();
        ArrayList<String> alamatSiswa = init.Siswa.getAlamat();
        ArrayList<String> teleponSiswa = init.Siswa.getTelepon();
        ArrayList<Boolean> statusSiswa = init.Siswa.getStatus();

        System.out.println("==========================================================================");
        System.out.printf("| %-5s | %-15s | %-20s | %-15s | %-10s |\n", "No", "Nama", "Alamat", "Telepon", "Status");
        System.out.println("==========================================================================");

        for (int i = 0; i < namaSiswa.size(); i++) {
            System.out.printf("| %-5d | %-15s | %-20s | %-15s | %-10s |\n", i, namaSiswa.get(i), alamatSiswa.get(i), teleponSiswa.get(i), statusSiswa.get(i) ? "Masih Meminjam" : "Tidak Meminjam");
        }

        System.out.println("==========================================================================");
    }

    private static void TampilListPetugas(){
        ArrayList<String> namaPetugas = init.Petugas.getNama();
        ArrayList<String> alamatPetugas = init.Petugas.getAlamat();
        ArrayList<String> teleponPetugas = init.Petugas.getTelepon();

        System.out.println("============================================================");
        System.out.printf("| %-5s | %-15s | %-20s | %-15s |\n", "No", "Nama", "Alamat", "Telepon");
        System.out.println("============================================================");

        for (int i = 0; i < namaPetugas.size(); i++) {
            System.out.printf("| %-5d | %-15s | %-20s | %-15s |\n", i, namaPetugas.get(i), alamatPetugas.get(i), teleponPetugas.get(i));
        }

        System.out.println("============================================================");
    }

    private static void TampilListBuku(){
        ArrayList<String> namaBuku =  Buku.getNamaBuku();
        ArrayList<Integer> stokBuku =  Buku.getStokBuku();
        ArrayList<Integer> hargaBuku =  Buku.getHargaBuku();

        System.out.println("==========================================================================");
        System.out.printf("| %-5s | %-20s | %-5s | %-10s |\n", "No", "Judul Buku", "Stok", "Harga");
        System.out.println("==========================================================================");

        for (int i = 0; i < namaBuku.size(); i++) {
            System.out.printf("| %-5d | %-20s | %-5d | %-10d |\n", i, namaBuku.get(i), stokBuku.get(i), hargaBuku.get(i));
        }

        System.out.println("==========================================================================");
    }

    private static void TampilListPeminjaman(){
        ArrayList<Integer> idSiswa = init.Peminjaman.getIdSiswa();
        ArrayList<Integer> idBuku = init.Peminjaman.getIdBuku();
        System.out.println("=====================================================================");
        System.out.printf("| %-14s | %-15s | %-20s |\n", "No. Peminjaman", "Nama Siswa", "Judul Buku");
        System.out.println("=====================================================================");

        for (int i = 0; i < idSiswa.size(); i++) {
            String namaSiswa = init.Siswa.getNama().get(i);
            String judulBuku = init.Buku.getNamaBuku().get(idBuku.get(i));
            System.out.printf("| %-14d | %-15s | %-20s |\n", i, namaSiswa, judulBuku);
        }
        System.out.println("=====================================================================");
    }

    private static void TambahPeminjam() {
        System.out.println("Tambah Peminjaman");
        TampilListSiswa();
        System.out.print("Input Nomer Tabel: ");
        int idSiswa = input.nextInt();

        Boolean status = init.Siswa.getStatus().get(idSiswa);
        if(status){
            System.out.println("Siswa sedang meminjam buku.");
        } else {
            TampilListBuku();
            System.out.print("Input Nomer Tabel: ");
            int idBuku = input.nextInt();
            System.out.print("Input Banyak buku yang di input: ");
            int Banyak = input.nextInt();
            ArrayList<Integer> idsiswa = init.Peminjaman.getIdSiswa();
            ArrayList<Integer> idbuku = init.Peminjaman.getIdBuku();
            ArrayList<Integer> banyak = init.Peminjaman.getBanyak();
            idsiswa.add(idSiswa);
            idbuku.add(idBuku);
            banyak.add(Banyak);
            Siswa.setStatus(idSiswa, true);
            utils.Buku.KurangStok(idBuku, Banyak);
            init.Peminjaman.setIdBuku(idbuku);
            init.Peminjaman.setIdSiswa(idsiswa);
            init.Peminjaman.setBanyak(banyak);
            new utils.Peminjaman().Simpan();
        }
    }


    private static void Kembalikan(){
        TampilListPeminjaman();
        System.out.print("Input Nomor Tabel yang Mengembalikan: ");
        new utils.Peminjaman().KembalikanBuku(input.nextInt());
        new utils.Peminjaman().Simpan();
    }

    private static void TambahSiswa(){
        System.out.println("Tambah Siswa");
        System.out.print("Nama :");
        input.nextLine();
        String Nama = input.nextLine();
        System.out.print("Alamat :");
        String Alamat = input.nextLine();
        System.out.print("Telp :");
        String Telp = input.nextLine();
        utils.Siswa.tambahSiswa(Nama,Alamat,Telp);
        new utils.Siswa().Simpan();
        System.out.println("Berhasil di Tambahkan");
        System.out.println();
    }
    private static void TambahBuku(){
        System.out.print("Nama :");
        input.nextLine();
        String Nama = input.nextLine();
        System.out.print("Stok :");
        int stok = input.nextInt();
        System.out.print("Harga :");
        int harga = input.nextInt();
        new utils.Buku().TambahBuku(Nama,stok,harga);
        new utils.Buku().Simpan();
        System.out.println("Berhasil di Tambahkan");
        System.out.println();
    }
    private static void TambahPetugas(){
        System.out.println("Tambah Petugas");
        input.nextLine();
        System.out.print("Nama :");
        String Nama = input.nextLine();
        System.out.print("Alamat :");
        String Alamat = input.nextLine();
        System.out.print("Telp :");
        String Telp = input.nextLine();
        utils.Petugas.tambahPetugas(Nama,Alamat,Telp);
        new utils.Petugas().Simpan();
        System.out.println("Berhasil di Tambahkan");
        System.out.println();
    }
}
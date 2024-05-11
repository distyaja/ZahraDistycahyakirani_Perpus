package utils;

public class Data {

    public void Simpan(){
        new Siswa().Simpan();
        new Petugas().Simpan();
        new Peminjaman().Simpan();
        new Buku().Simpan();
        System.out.println("Data Sudah Tersimpan");
    }

    public void Memuat(){
        System.out.println("Memuat Data");
        new Siswa().Memuat();
        new Petugas().Memuat();
        new Buku().Memuat();
        new Peminjaman().Memuat();
    }
}
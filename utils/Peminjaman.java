package utils;

import java.io.*;
import java.util.ArrayList;

public class Peminjaman extends Data{


    public void KembalikanBuku(int index){
        ArrayList<Integer> idsiswa = init.Peminjaman.getIdSiswa();
        ArrayList<Integer> idbuku = init.Peminjaman.getIdBuku();
        ArrayList<Integer> banyak = init.Peminjaman.getBanyak();
        Buku.TambahStok(idbuku.get(index),banyak.get(index));
        idbuku.remove(index);
        Siswa.setStatus(idsiswa.get(index), false);
        idsiswa.remove(index);
        banyak.remove(index);
        init.Peminjaman.setIdBuku(idbuku);
        init.Peminjaman.setIdSiswa(idsiswa);
        init.Peminjaman.setBanyak(banyak);
        new Peminjaman().Simpan();
    }

    @Override
    public void Simpan(){
        SimpanBanyak();
        SimpanIdBuku();
        SimpanIdSiswa();
    }

    @Override
    public void Memuat(){
        MemuatIdBuku();
        MemuatIdSiswa();
        MemuatBanyak();
    }

    private void MemuatIdSiswa(){
        java.io.File file = new java.io.File("IdSiswa.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IdSiswa.data"))) {
                init.Peminjaman.setIdSiswa((ArrayList<Integer>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void SimpanIdSiswa(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IdSiswa.data"))) {
            oos.writeObject(init.Peminjaman.getIdSiswa());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void MemuatIdBuku(){
        java.io.File file = new java.io.File("IdBuku.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IdBuku.data"))) {
                init.Peminjaman.setIdBuku((ArrayList<Integer>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void SimpanIdBuku(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IdBuku.data"))) {
            oos.writeObject(init.Peminjaman.getIdBuku());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void MemuatBanyak(){
        java.io.File file = new java.io.File("Banyak.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Banyak.data"))) {
                init.Peminjaman.setBanyak((ArrayList<Integer>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void SimpanBanyak(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Banyak.data"))) {
            oos.writeObject(init.Peminjaman.getBanyak());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
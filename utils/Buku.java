package utils;

import java.io.*;
import java.util.ArrayList;

public class Buku extends Data{

    public void TambahBuku(String NamaBuku,int Stok, int Harga){
        ArrayList<String> listNamaBuku = init.Buku.getNamaBuku();
        listNamaBuku.add(NamaBuku);
        ArrayList<Integer> liststokBuku = init.Buku.getStokBuku();
        liststokBuku.add(Stok);
        ArrayList<Integer> listHargaBuku = init.Buku.getStokBuku();
        listHargaBuku.add(Harga);
        init.Buku.setNamaBuku(listNamaBuku);
        init.Buku.setHarga(listHargaBuku);
        init.Buku.setStokBuku(liststokBuku);
    }

    public static void TambahStok(int index, int jumlah){
        ArrayList<Integer> liststokBuku = init.Buku.getStokBuku();
        liststokBuku.set(index, liststokBuku.get(index) + jumlah);
        init.Buku.setStokBuku(liststokBuku);
        new Buku().Simpan();
    }

    public static void KurangStok(int index, int jumlah){
        ArrayList<Integer> liststokBuku = init.Buku.getStokBuku();
        liststokBuku.set(index, liststokBuku.get(index) - jumlah);
        init.Buku.setStokBuku(liststokBuku);
    }

    private void MemuatNamaBuku(){
        java.io.File file = new java.io.File("NamaBuku.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NamaBuku.data"))) {
                init.Buku.setNamaBuku((ArrayList<String>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void SimpanNamaBuku(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NamaBuku.data"))) {
            oos.writeObject(init.Buku.getNamaBuku());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void MemuatStokBuku(){
        java.io.File file = new java.io.File("StokBuku.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StokBuku.data"))) {
                init.Buku.setStokBuku((ArrayList<Integer>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void SimpanStokBuku(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StokBuku.data"))) {
            oos.writeObject(init.Buku.getStokBuku());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void MemuatHargaBuku(){
        java.io.File file = new java.io.File("HargaBuku.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HargaBuku.data"))) {
                init.Buku.setHarga((ArrayList<Integer>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void SimpanHargaBuku(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("HargaBuku.data"))) {
            oos.writeObject(init.Buku.getHargaBuku());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Simpan() {
        SimpanHargaBuku();
        SimpanNamaBuku();
        SimpanStokBuku();
    }
    @Override
    public void Memuat(){
        MemuatHargaBuku();
        MemuatNamaBuku();
        MemuatStokBuku();
    }
}
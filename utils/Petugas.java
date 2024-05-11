package utils;

import java.io.*;
import java.util.ArrayList;

public class Petugas extends Data{

    public static void tambahPetugas(String nama, String alamat, String telepon) {
        ArrayList<String> Nama = init.Petugas.getNama();
        ArrayList<String> Alamat = init.Petugas.getAlamat();
        ArrayList<String> Telepon = init.Petugas.getTelepon();
        Nama.add(nama);
        Alamat.add(alamat);
        Telepon.add(telepon);
        init.Petugas.setNama(Nama);
        init.Petugas.setAlamat(Alamat);
        init.Petugas.setTelepon(Telepon);
    }
    @Override
    public void Simpan() {
        SimpanNama();
        SimpanAlamat();
        SimpanTelepon();
    }

    @Override
    public void Memuat() {
        MemuatNama();
        MemuatAlamat();
        MemuatTelepon();
    }

    private void MemuatNama(){
        java.io.File file = new java.io.File("NamaPetugas.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NamaPetugas.data"))) {
                init.Petugas.setNama((ArrayList<String>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void MemuatAlamat(){
        java.io.File file = new java.io.File("AlamatPetugas.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AlamatPetugas.data"))) {
                init.Petugas.setAlamat((ArrayList<String>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void MemuatTelepon(){
        java.io.File file = new java.io.File("TeleponPetugas.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TeleponPetugas.data"))) {
                init.Petugas.setTelepon((ArrayList<String>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void SimpanNama(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NamaPetugas.data"))) {
            oos.writeObject(init.Petugas.getNama());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SimpanAlamat(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AlamatPetugas.data"))) {
            oos.writeObject(init.Petugas.getAlamat());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SimpanTelepon(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TeleponPetugas.data"))) {
            oos.writeObject(init.Petugas.getTelepon());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
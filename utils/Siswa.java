package utils;

import java.io.*;
import java.util.ArrayList;

public class Siswa extends Data {

    public static void tambahSiswa(String nama, String alamat, String telepon) {
        ArrayList<String> Nama = init.Siswa.getNama();
        ArrayList<String> Alamat = init.Siswa.getAlamat();
        ArrayList<String> Telepon = init.Siswa.getTelepon();
        ArrayList<Boolean> status = init.Siswa.getStatus();
        status.add(false);
        Nama.add(nama);
        Alamat.add(alamat);
        Telepon.add(telepon);
        init.Siswa.setNama(Nama);
        init.Siswa.setAlamat(Alamat);
        init.Siswa.setTelepon(Telepon);
        init.Siswa.setStatus(status);
    }

    public static void setStatus(int index, boolean status){
        ArrayList<Boolean> tmpstatus = init.Siswa.getStatus();
        tmpstatus.set(index, status);
        init.Siswa.setStatus(tmpstatus);
        new utils.Data().Simpan();
    }

    @Override
    public void Simpan() {
        SimpanNama();
        SimpanAlamat();
        SimpanTelepon();
        SimpanStatus();
    }

    @Override
    public void Memuat() {
        MemuatNama();
        MemuatAlamat();
        MemuatTelepon();
        MemuatStatus();
    }

    private void MemuatNama(){
        java.io.File file = new java.io.File("NamaSiswa.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NamaSiswa.data"))) {
                init.Siswa.setNama((ArrayList<String>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void MemuatAlamat(){
        java.io.File file = new java.io.File("AlamatSiswa.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AlamatSiswa.data"))) {
                init.Siswa.setAlamat((ArrayList<String>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void MemuatTelepon(){
        java.io.File file = new java.io.File("TeleponSiswa.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TeleponSiswa.data"))) {
                init.Siswa.setTelepon((ArrayList<String>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void MemuatStatus(){
        java.io.File file = new java.io.File("StatusSiswa.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StatusSiswa.data"))) {
                init.Siswa.setStatus((ArrayList<Boolean>) ois.readObject());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    private void SimpanNama(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NamaSiswa.data"))) {
            oos.writeObject(init.Siswa.getNama());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SimpanAlamat(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AlamatSiswa.data"))) {
            oos.writeObject(init.Siswa.getAlamat());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SimpanTelepon(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TeleponSiswa.data"))) {
            oos.writeObject(init.Siswa.getTelepon());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SimpanStatus(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StatusSiswa.data"))) {
            oos.writeObject(init.Siswa.getStatus());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
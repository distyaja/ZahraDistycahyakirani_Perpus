package init;

import java.util.ArrayList;

public class Petugas implements biografi {

    private static ArrayList<String> namaKaryawan = new ArrayList<>();
    private static ArrayList<String> alamat = new ArrayList<>();
    private static ArrayList<String> telepon = new ArrayList<>();

    public static ArrayList<String> getNama() {
        return namaKaryawan;
    }

    public static void setNama(ArrayList<String> namaPetugas) {
        namaKaryawan = namaPetugas;
    }

    public static ArrayList<String> getAlamat() {
        return alamat;
    }

    public static void setAlamat(ArrayList<String> Alamat) {
        alamat = Alamat;
    }

    public static ArrayList<String> getTelepon() {
        return telepon;
    }

    public static void setTelepon(ArrayList<String> Telepon) {
        telepon = Telepon;
    }
}
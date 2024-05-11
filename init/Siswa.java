package init;

import java.util.ArrayList;

public class Siswa implements biografi {

    private static ArrayList<String> namaSiswa = new ArrayList<>();
    private static ArrayList<String> alamat = new ArrayList<>();
    private static ArrayList<String> telepon = new ArrayList<>();
    private static ArrayList<Boolean> status = new ArrayList<>();

    public static ArrayList<String> getNama() {
        return namaSiswa;
    }

    public static void setNama(ArrayList<String> NamaSiswa) {
        namaSiswa = NamaSiswa;
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

    public static ArrayList<Boolean> getStatus() {
        return status;
    }

    public static void setStatus(ArrayList<Boolean> Status) {
        status = Status;
    }
}
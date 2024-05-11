package init;

import java.util.ArrayList;

public class Peminjaman {

    private static ArrayList<Integer> idSiswa = new ArrayList<>();
    private static ArrayList<Integer> idBuku = new ArrayList<>();
    private static ArrayList<Integer> banyak = new ArrayList<>();
    public static ArrayList<Integer> getIdSiswa() {
        return idSiswa;
    }

    public static void setIdSiswa(ArrayList<Integer> idSiswa) {
        idSiswa = idSiswa;
    }

    public static ArrayList<Integer> getIdBuku() {
        return idBuku;
    }

    public static void setIdBuku(ArrayList<Integer> idbuku) {
        idBuku = idbuku;
    }

    public static ArrayList<Integer> getBanyak() {
        return banyak;
    }

    public static void setBanyak(ArrayList<Integer> Banyak) {
        banyak = Banyak;
    }
}
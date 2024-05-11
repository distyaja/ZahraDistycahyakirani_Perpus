package init;

import java.util.ArrayList;

public class Buku {

    private static ArrayList<String> namaBuku = new ArrayList<>();
    private static ArrayList<Integer> stok = new ArrayList<>();
    private static ArrayList<Integer> harga = new ArrayList<>();

    public static ArrayList<String> getNamaBuku() {
        return namaBuku;
    }

    public static void setNamaBuku(ArrayList<String> NamaBuku) {
        namaBuku = NamaBuku;
    }

    public static ArrayList<Integer> getStokBuku() {
        return stok;
    }

    public static void setStokBuku(ArrayList<Integer> Stok) {
        stok = Stok;
    }

    public static ArrayList<Integer> getHargaBuku() {
        return harga;
    }

    public static void setHarga(ArrayList<Integer> Harga) {
        harga = Harga;
    }
}
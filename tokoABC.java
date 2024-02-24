
import java.util.ArrayList;

// Kelas generik untuk menyimpan operasi-operasi yang dapat dilakukan pada data barang
class Inventory<T> {
    private ArrayList<T> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    // Menambahkan item ke inventory
    public void addItem(T item) {
        items.add(item);
    }

    // Menghapus item dari inventory
    public void removeItem(T item) {
        items.remove(item);
    }

    // Mengedit item dalam inventory
    public void editItem(T oldItem, T newItem) {
        int index = items.indexOf(oldItem);
        if (index != -1) {
            items.set(index, newItem);
        }
    }

    // Menampilkan semua item dalam inventory
    public void displayInventory() {
        for (T item : items) {
            System.out.println(item.toString());
        }
    }
}

// Kelas untuk representasi Alat Tulis Kantor (ATK)
class ATK {
    private String kodeBarang;
    private String jenisBarang;
    private String namaBarang;
    private int stok;

    public ATK(String kodeBarang, String jenisBarang, String namaBarang, int stok) {
        this.kodeBarang = kodeBarang;
        this.jenisBarang = jenisBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "ATK{" +
                "kodeBarang='" + kodeBarang + '\'' +
                ", jenisBarang='" + jenisBarang + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", stok=" + stok +
                '}';
    }
}

// Kelas untuk representasi Barang
class Bag {
    private String kodeBarang;
    private String jenisBarang;
    private String namaBarang;
    private int stok;

    public Bag(String kodeBarang, String jenisBarang, String namaBarang, int stok) {
        this.kodeBarang = kodeBarang;
        this.jenisBarang = jenisBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "kodeBarang='" + kodeBarang + '\'' +
                ", jenisBarang='" + jenisBarang + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", stok=" + stok +
                '}';
    }
}

public class tokoABC {
    
    public static void main(String[] args) {
        // Membuat inventory untuk ATK
        Inventory<ATK> atkInventory = new Inventory<>();
        // Menambahkan beberapa data ATK
        atkInventory.addItem(new ATK("A001", "Pulpen", "Snowman Board Marker Hitam", 50));
        atkInventory.addItem(new ATK("A002", "Spidol", "Snowman Whiteboard Marker", 30));
        atkInventory.addItem(new ATK("A003", "Pensil", "Faber Castell HB", 100));
        atkInventory.addItem(new ATK("A004", "Pulpen", "Pilot G-2 0.7mm", 20));
        atkInventory.addItem(new ATK("A005", "Spidol", "Artline 70 Permanent Marker", 40));

        // Menampilkan inventory ATK
        System.out.println("Inventory ATK:");
        atkInventory.displayInventory();

        // Menghapus item dari inventory ATK
        atkInventory.removeItem(new ATK("A002", "Spidol", "Snowman Whiteboard Marker", 30));

        // Mengedit item dalam inventory ATK
        atkInventory.editItem(new ATK("A001", "Pulpen", "Snowman Board Marker Hitam", 50),
                new ATK("A001", "Pulpen", "Snowman Board Marker Putih", 60));

        System.out.println("\nAfter Modification:");
        atkInventory.displayInventory();

        // Membuat inventory untuk Bag
        Inventory<Bag> bagInventory = new Inventory<>();
        // Menambahkan beberapa data Bag
        bagInventory.addItem(new Bag("C001", "Tas", "Tas Serut", 20));
        bagInventory.addItem(new Bag("C002", "Tempat Pensil", "Tempat Pensil Warna", 15));
        bagInventory.addItem(new Bag("C003", "Tas", "Tas Laptop", 10));
        bagInventory.addItem(new Bag("C004", "Tas", "Tas Ransel", 25));
        bagInventory.addItem(new Bag("C005", "Tempat Pensil", "Kotak Pensil", 30));

        // Menampilkan inventory Bag
        System.out.println("\nInventory Bag:");
        bagInventory.displayInventory();
    }
}

package Jawaban;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestoran {
    public static void main(String[] args) {

        // Membuat objek MenuManager
        MenuManager<MenuItem> menuManager = new MenuManager<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Menu utama aplikasi
        do {
            System.out.println("\nRestaurant Menu Management System");
            System.out.println("1. Add Menu");
            System.out.println("2. Remove Menu");
            System.out.println("3. Edit Menu Price");
            System.out.println("4. Display Menu");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                // Memanggil metode untuk menambahkan menu
                case 1:
                    addMenu(menuManager, scanner);
                    break;
                // Memanggil metode untuk menghapus menu
                case 2:
                    removeMenu(menuManager, scanner);
                    break;
                // Memanggil metode untuk mengedit harga menu
                case 3:
                    editMenuPrice(menuManager, scanner);
                    break;
                // Memanggil metode untuk menampilkan daftar menu
                case 4:
                    menuManager.displayMenu();
                    break;
                // Keluar dari aplikasi
                case 5:
                    System.out.println("Exiting...");
                    break;
                // Pilihan tidak valid
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        scanner.close();
    }

    // Metode untuk menambahkan menu
    private static void addMenu(MenuManager<MenuItem> menuManager, Scanner scanner) {
        // Meminta input dari pengguna untuk menambahkan menu baru
        System.out.println("Enter menu details:");
        scanner.nextLine(); // Mengonsumsi newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: $");
        double price = scanner.nextDouble();
        // Menambahkan menu baru ke dalam daftar
        menuManager.addMenuItem(new MenuItem(name, price));
    }

    // Metode untuk menghapus menu
    private static void removeMenu(MenuManager<MenuItem> menuManager, Scanner scanner) {
        // Meminta input dari pengguna untuk menghapus menu
        System.out.println("Enter menu name to remove:");
        scanner.nextLine(); // Mengonsumsi newline
        System.out.print("Name: ");
        String nameToRemove = scanner.nextLine();

        // Membuat objek MenuItem untuk menu yang akan dihapus
        MenuItem menuToRemove = new MenuItem(nameToRemove, 0);
        // Menghapus menu dari daftar
        menuManager.removeMenuItem(menuToRemove);
    }

    // Metode untuk mengedit harga menu
    private static void editMenuPrice(MenuManager<MenuItem> menuManager, Scanner scanner) {
        // Meminta input dari pengguna untuk mengedit harga menu
        System.out.println("Enter menu name to edit price:");
        scanner.nextLine(); // Mengonsumsi newline
        System.out.print("Name: ");
        String nameToEdit = scanner.nextLine();

        // Mencari menu berdasarkan nama
        MenuItem menuToEdit = null;
        for (MenuItem menuItem : menuManager.getMenuItems()) {
            if (menuItem.getName().equalsIgnoreCase(nameToEdit)) {
                menuToEdit = menuItem;
                break;
            }
        }

        // Jika menu ditemukan, meminta harga baru dari pengguna
        if (menuToEdit != null) {
            // Meminta harga baru dari pengguna
            System.out.print("New Price: $");
            double newPrice = scanner.nextDouble();
            // Memperbarui harga menu yang sesuai
            menuManager.editMenuItemPrice(menuToEdit, newPrice);
        } 
        // Jika menu tidak ditemukan
        else {
            System.out.println("Menu not found: " + nameToEdit);
        }
    }
}

// Kelas untuk merepresentasikan sebuah menu
class MenuItem {
    private String name;
    private double price;

    // Konstruktor untuk membuat objek MenuItem
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter dan setter untuk mengakses dan mengubah informasi menu
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Metode untuk menampilkan informasi menu
    @Override
    public String toString() {
        return "Menu: " + name + ", Price: $" + price;
    }
}

// Kelas untuk manajemen menu, menggunakan generic dan ArrayList
// Tipe parameter T adalah MenuItem atau subclass dari MenuItem
class MenuManager<T extends MenuItem> {
    private ArrayList<T> menuItems;

    // Konstruktor untuk membuat objek MenuManager
    public MenuManager() {
        menuItems = new ArrayList<>();
    }

    // Metode untuk menambahkan menu baru
    public void addMenuItem(T menuItem) {
        menuItems.add(menuItem);
        System.out.println("Menu added successfully: " + menuItem.getName());
    }

    // Metode untuk menghapus menu
    public void removeMenuItem(T menuItem) {
        if (menuItems.remove(menuItem)) {
            System.out.println("Menu removed successfully: " + menuItem.getName());
        } else {
            System.out.println("Menu not found: " + menuItem.getName());
        }
    }

    // Metode untuk mengedit harga menu
    public void editMenuItemPrice(T menuItem, double newPrice) {
        int index = menuItems.indexOf(menuItem);
        if (index != -1) {
            menuItems.get(index).setPrice(newPrice);
            System.out.println("Menu price updated successfully");
        } else {
            System.out.println("Menu not found: " + menuItem.getName());
        }
    }

    // Metode untuk menampilkan daftar menu
    public void displayMenu() {
        if (menuItems.isEmpty()) {
            System.out.println("No menu available");
        } else {
            System.out.println("Menu List:");
            for (T menuItem : menuItems) {
                System.out.println(menuItem);
            }
        }
    }
    
    // Metode untuk mengakses daftar menu
    public ArrayList<T> getMenuItems() {
        return menuItems;
    }
}
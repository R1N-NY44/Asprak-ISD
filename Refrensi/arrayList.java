package Refrensi;

import java.util.ArrayList;

// Kelas untuk merepresentasikan sebuah kontak
class Contact {
    private String name;
    private String phoneNumber;

    // Konstruktor untuk membuat objek Contact
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter dan setter (untuk mengakses dan mengubah informasi kontak)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Metode untuk menampilkan informasi kontak
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

public class arrayList {
    public static void main(String[] args) {
        // Membuat ArrayList untuk menyimpan daftar kontak
        ArrayList<Contact> contacts = new ArrayList<>();

        // Menambahkan beberapa kontak ke dalam ArrayList
        contacts.add(new Contact("John Doe", "1234567890"));
        contacts.add(new Contact("Jane Smith", "0987654321"));

        // Menampilkan daftar kontak
        System.out.println("Daftar Kontak:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        // Mengedit nomor telepon kontak pertama
        Contact firstContact = contacts.get(0);
        firstContact.setPhoneNumber("9999999999");
        System.out.println("\nNomor telepon kontak pertama telah diubah:");

        // Menampilkan daftar kontak setelah perubahan
        System.out.println("Daftar Kontak:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        // Menghapus kontak kedua dari daftar
        Contact secondContact = contacts.get(1);
        contacts.remove(secondContact);
        System.out.println("\nKontak kedua telah dihapus:");

        // Menampilkan daftar kontak setelah penghapusan
        System.out.println("Daftar Kontak:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

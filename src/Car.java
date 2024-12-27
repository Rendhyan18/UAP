import javax.swing.*;

// Kelas Car untuk tipe mobil
public class Car {
    private String brand;
    private String model;
    private double price;
    private ImageIcon image;

    // Konstruktor untuk inisialisasi objek Car
    public Car(String brand, String model, double price, ImageIcon image) {
        this.brand = brand;
        this.model = model;
        setPrice(price);  // Menggunakan setter untuk validasi harga
        setImage(image);  // Menggunakan setter untuk validasi gambar
    }

    // Getter untuk brand
    public String getBrand() {
        return brand;
    }

    // Getter untuk model
    public String getModel() {
        return model;
    }

    // Getter untuk harga
    public double getPrice() {
        return price;
    }

    // Getter untuk gambar
    public ImageIcon getImage() {
        return image;
    }

    // Setter untuk brand
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        } else {
            System.out.println("Brand tidak boleh kosong.");
        }
    }

    // Setter untuk model
    public void setModel(String model) {
        if (model != null && !model.trim().isEmpty()) {
            this.model = model;
        } else {
            System.out.println("Model tidak boleh kosong.");
        }
    }

    // Setter untuk harga dengan validasi
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Harga tidak boleh negatif.");
        }
    }

    // Setter untuk gambar dengan validasi
    public void setImage(ImageIcon image) {
        if (image != null) {
            this.image = image;
        } else {
            System.out.println("Gambar tidak boleh null.");
        }
    }

    // Main method untuk pengujian
    public static void main(String[] args) {
        // Membuat objek ImageIcon untuk gambar mobil
        ImageIcon carImage = new ImageIcon("path/to/car_image.jpg");

        // Membuat objek Car baru
        Car myCar = new Car("Toyota", "Avanza", 250.000, carImage);

        // Menguji getter untuk brand, model, harga, dan gambar
        System.out.println("Brand: " + myCar.getBrand());    // Expected output: Toyota
        System.out.println("Model: " + myCar.getModel());    // Expected output: Avanza
        System.out.println("Price: " + myCar.getPrice());    // Expected output: 250000000
        System.out.println("Image: " + myCar.getImage());    // Expected output: Icon image (tampilan visual)

        // Menguji setter untuk mengubah nilai atribut
        myCar.setBrand("Honda");
        myCar.setModel("Civic");
        myCar.setPrice(300.000);

        // Menguji hasil setelah setter dipanggil
        System.out.println("Updated Brand: " + myCar.getBrand());  // Expected output: Honda
        System.out.println("Updated Model: " + myCar.getModel());  // Expected output: Civic
        System.out.println("Updated Price: " + myCar.getPrice());  // Expected output: 300000000
    }
}
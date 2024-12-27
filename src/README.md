# Aplikasi Manajemen Rental Mobil

Ini adalah aplikasi desktop berbasis Java Swing untuk mengelola rental mobil. Aplikasi ini memungkinkan pengguna untuk melakukan operasi CRUD (Create, Read, Update, Delete) pada data mobil dan melihat gambar mobil terkait. Aplikasi ini dibangun menggunakan pustaka `javax.swing` dan menyediakan antarmuka grafis (GUI) untuk kemudahan interaksi.

---

## Fitur

1. **Tambah Mobil**: Menambahkan mobil baru dengan detail seperti ID, merek, model, harga, dan gambar terkait.
2. **Perbarui Mobil**: Memodifikasi detail mobil yang sudah ada, termasuk memperbarui gambar.
3. **Hapus Mobil**: Menghapus mobil dari sistem.
4. **Lihat Gambar**: Menampilkan gambar mobil yang dipilih.

---

## Prasyarat

- JDK 8 atau versi lebih baru
- IDE Java (misalnya, IntelliJ IDEA, Eclipse) atau terminal dengan perintah `javac` dan `java`.

---

## Cara Menjalankan Aplikasi

1. **Unduh atau Salin Proyek**:
   Simpan kode yang diberikan ke dalam dua file terpisah:
    - `Car.java`
    - `CarRentalApp.java`

2. **Kompilasi File**:
   Buka terminal atau gunakan IDE untuk mengompilasi file. Jika menggunakan terminal, jalankan perintah berikut:
   ```bash
   javac Car.java CarRentalApp.java
   ```

3. **Jalankan Aplikasi**:
   Eksekusi kelas `CarRentalApp` dengan perintah berikut:
   ```bash
   java CarRentalApp
   ```

---

## Gambaran Kode

### 1. Kelas `Car`

Kelas `Car` memodelkan data mobil dan mencakup:
- Atribut privat: `brand`, `model`, `price`, dan `image` (sebagai `ImageIcon`).
- Konstruktor untuk menginisialisasi atribut.
- Getter dan setter untuk mengakses atribut yang dienkapsulasi.

#### Contoh:
```java
Car car = new Car("001", "Toyota", "Camry", 30000.0, new ImageIcon("car_image.jpg"));
```

### 2. Kelas `CarRentalApp`

Kelas `CarRentalApp` membuat GUI dan menyediakan fungsionalitas berikut:
- **Tabel Data Mobil**: Menampilkan detail mobil dalam format tabel.
- **Tombol**:
    - Tambah Mobil
    - Perbarui Mobil
    - Hapus Mobil
    - Lihat Gambar

#### Metode Utama:
- `addCar()`: Meminta pengguna memasukkan detail mobil dan menambahkan mobil baru ke daftar.
- `updateCar()`: Memungkinkan pembaruan detail mobil pada baris yang dipilih di tabel.
- `deleteCar()`: Menghapus mobil yang dipilih dari tabel dan daftar internal.
- `viewImage()`: Menampilkan gambar mobil yang dipilih.

---

## Instruksi Penggunaan

1. **Tambah Mobil**:
    - Klik tombol **Tambah Mobil**.
    - Isi detail mobil (ID, Merek, Model, Harga) dan pilih file gambar.
    - Klik **OK** untuk menyimpan mobil.

2. **Perbarui Mobil**:
    - Pilih mobil dari tabel.
    - Klik tombol **Perbarui Mobil**.
    - Modifikasi detail mobil dan, jika perlu, perbarui gambar.
    - Klik **OK** untuk menyimpan perubahan.

3. **Hapus Mobil**:
    - Pilih mobil dari tabel.
    - Klik tombol **Hapus Mobil**.
    - Konfirmasi penghapusan.

4. **Lihat Gambar Mobil**:
    - Pilih mobil dari tabel.
    - Klik tombol **Lihat Gambar**.
    - Gambar mobil akan ditampilkan dalam dialog popup.

---

## Catatan
- Pastikan semua kolom yang diperlukan diisi saat menambahkan atau memperbarui mobil.
- Gambar ditampilkan menggunakan kelas `ImageIcon`, yang memerlukan path file yang valid.
- Periksa kembali bahwa input harga adalah angka untuk menghindari kesalahan.

---

## Lisensi
Proyek ini dilisensikan di bawah Lisensi MIT. Anda bebas untuk memodifikasi dan menggunakannya sesuai kebutuhan.

---

## Penulis
- Rizqullah Zuhayr Alfito Khan_202310370311124
- Rendhyan Roscha_202310370311124


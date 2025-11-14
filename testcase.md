# Test Case Login saucedemo.com

## Test Case 1: Login Berhasil

*   **Test Case ID:** TC-LOGIN-001
*   **Judul:** Login berhasil dengan kredensial yang valid
*   **Skenario:**
    Pengguna memasukkan username `standard_user` dan password `secret_sauce` yang valid, kemudian menekan tombol login.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Masukkan `standard_user` di kolom username.
    3.  Masukkan `secret_sauce` di kolom password.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna berhasil login dan diarahkan ke halaman inventaris produk (`/inventory.html`).

## Test Case 2: Login Gagal - Username Salah

*   **Test Case ID:** TC-LOGIN-002
*   **Judul:** Login gagal dengan username yang salah
*   **Skenario:**
    Pengguna memasukkan username yang salah dan password yang benar.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Masukkan `invalid_user` di kolom username.
    3.  Masukkan `secret_sauce` di kolom password.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna gagal login dan pesan error "Epic sadface: Username and password do not match any user in this service" ditampilkan.

## Test Case 3: Login Gagal - Password Salah

*   **Test Case ID:** TC-LOGIN-003
*   **Judul:** Login gagal dengan password yang salah
*   **Skenario:**
    Pengguna memasukkan username yang benar dan password yang salah.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Masukkan `standard_user` di kolom username.
    3.  Masukkan `invalid_password` di kolom password.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna gagal login dan pesan error "Epic sadface: Username and password do not match any user in this service" ditampilkan.

## Test Case 4: Login Gagal - Kredensial Kosong

*   **Test Case ID:** TC-LOGIN-004
*   **Judul:** Login gagal dengan username dan password kosong
*   **Skenario:**
    Pengguna tidak memasukkan username dan password, lalu menekan tombol login.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Biarkan kolom username kosong.
    3.  Biarkan kolom password kosong.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna gagal login dan pesan error "Epic sadface: Username is required" ditampilkan.

## Test Case 5: Login Gagal - Hanya Username

*   **Test Case ID:** TC-LOGIN-005
*   **Judul:** Login gagal dengan password kosong
*   **Skenario:**
    Pengguna hanya memasukkan username, lalu menekan tombol login.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Masukkan `standard_user` di kolom username.
    3.  Biarkan kolom password kosong.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna gagal login dan pesan error "Epic sadface: Password is required" ditampilkan.

---

## Test Case - Fitur Inventory

### Skenario Pengujian Positif (Integration Testing)

*   **ID Pengujian:** TC-INV-001
*   **Judul:** Menambahkan satu item ke keranjang belanja dari halaman inventaris.
*   **Langkah-langkah:**
    1.  Lakukan login berhasil menggunakan akun `standard_user`.
    2.  Di halaman inventaris, temukan item "Sauce Labs Backpack".
    3.  Klik tombol "Add to cart" pada item tersebut.
*   **Hasil yang Diharapkan:**
    1.  Tombol pada item "Sauce Labs Backpack" berubah menjadi "Remove".
    2.  Ikon keranjang belanja di pojok kanan atas menampilkan badge dengan angka "1".

*   **ID Pengujian:** TC-INV-002
*   **Judul:** Menghapus item dari keranjang belanja melalui halaman inventaris.
*   **Langkah-langkah:**
    1.  Lakukan login dan tambahkan "Sauce Labs Backpack" ke keranjang (mengikuti TC-INV-001).
    2.  Pada item "Sauce Labs Backpack" yang sama, klik tombol "Remove".
*   **Hasil yang Diharapkan:**
    1.  Tombol pada item "Sauce Labs Backpack" kembali menjadi "Add to cart".
    2.  Badge angka pada ikon keranjang belanja menghilang.

*   **ID Pengujian:** TC-INV-003
*   **Judul:** Mengurutkan produk berdasarkan Harga (rendah ke tinggi).
*   **Langkah-langkah:**
    1.  Lakukan login berhasil menggunakan akun `standard_user`.
    2.  Klik menu dropdown untuk sorting di kanan atas.
    3.  Pilih opsi "Price (low to high)".
*   **Hasil yang Diharapkan:**
    Daftar produk diurutkan ulang dengan produk termurah ("Sauce Labs Onesie" seharga $7.99) muncul di posisi pertama.

*   **ID Pengujian:** TC-INV-004
*   **Judul:** Navigasi ke halaman detail produk.
*   **Langkah-langkah:**
    1.  Lakukan login berhasil menggunakan akun `standard_user`.
    2.  Klik pada nama produk "Sauce Labs Bike Light".
*   **Hasil yang Diharapkan:**
    Pengguna diarahkan ke halaman detail untuk produk "Sauce Labs Bike Light" (`/inventory-item.html?id=0`).

*   **ID Pengujian:** TC-INV-005
*   **Judul:** Navigasi ke halaman keranjang belanja setelah menambahkan item.
*   **Langkah-langkah:**
    1.  Lakukan login dan tambahkan satu atau lebih item ke keranjang.
    2.  Klik ikon keranjang belanja di pojok kanan atas.
*   **Hasil yang Diharapkan:**
    Pengguna diarahkan ke halaman keranjang belanja (`/cart.html`) yang menampilkan item yang telah ditambahkan.

### Skenario Pengujian Negatif (Integration Testing)

*   **ID Pengujian:** TC-INV-006
*   **Judul:** Mengakses halaman inventaris secara langsung tanpa login.
*   **Langkah-langkah:**
    1.  Pastikan tidak ada sesi login yang aktif (atau buka browser dalam mode private/incognito).
    2.  Akses URL `https://www.saucedemo.com/inventory.html` secara langsung.
*   **Hasil yang Diharapkan:**
    1.  Sistem secara otomatis mengarahkan pengguna ke halaman login (`/`).
    2.  Sebuah pesan error ditampilkan: "Epic sadface: You can only access '/inventory.html' when you are logged in."

*   **ID Pengujian:** TC-INV-007
*   **Judul:** Memastikan keranjang belanja kosong setelah proses logout dan login kembali.
*   **Langkah-langkah:**
    1.  Lakukan login berhasil menggunakan akun `standard_user`.
    2.  Tambahkan "Sauce Labs Fleece Jacket" ke keranjang.
    3.  Lakukan logout dari aplikasi.
    4.  Lakukan login kembali dengan akun `standard_user` yang sama.
*   **Hasil yang Diharapkan:**
    Halaman inventaris ditampilkan dan ikon keranjang belanja tidak menampilkan badge angka (kosong), menandakan sesi keranjang sebelumnya telah dihapus.
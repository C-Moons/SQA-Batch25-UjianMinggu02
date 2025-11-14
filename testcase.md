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

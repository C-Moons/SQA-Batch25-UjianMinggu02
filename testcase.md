# Test Case untuk Login Swag Labs

Dokumen ini menguraikan test case untuk fungsionalitas login aplikasi Swag Labs (https://www.saucedemo.com/).

---

### ID Test Case: TC-LOGIN-001
**Judul Test Case:** Verifikasi login berhasil dengan kredensial yang valid.
**Tujuan Tes:** Untuk memastikan bahwa pengguna dapat berhasil login ke aplikasi dengan nama pengguna dan kata sandi yang valid.
**Prasyarat:**
- Pengguna harus memiliki akun yang valid dan aktif.
- Pengguna harus berada di halaman login Swag Labs.
**Langkah-langkah Tes:**
1.  Buka https://www.saucedemo.com/.
2.  Masukkan nama pengguna `standard_user` di kolom 'Username'.
3.  Masukkan kata sandi `secret_sauce` di kolom 'Password'.
4.  Klik tombol 'Login'.
**Hasil yang Diharapkan:**
Pengguna berhasil diarahkan ke halaman inventaris utama, dan URL berubah menjadi `https://www.saucedemo.com/inventory.html`.

---

### ID Test Case: TC-LOGIN-002
**Judul Test Case:** Verifikasi login gagal dengan nama pengguna yang tidak valid.
**Tujuan Tes:** Untuk memastikan bahwa sistem mencegah login ketika nama pengguna yang tidak valid diberikan.
**Prasyarat:**
- Pengguna berada di halaman login Swag Labs.
**Langkah-langkah Tes:**
1.  Buka https://www.saucedemo.com/.
2.  Masukkan nama pengguna yang tidak valid (misalnya, `invalid_user`) di kolom 'Username'.
3.  Masukkan kata sandi yang valid `secret_sauce` di kolom 'Password'.
4.  Klik tombol 'Login'.
**Hasil yang Diharapkan:**
Pesan kesalahan ditampilkan: "Epic sadface: Username and password do not match any user in this service". Pengguna tetap berada di halaman login.

---

### ID Test Case: TC-LOGIN-003
**Judul Test Case:** Verifikasi login gagal dengan kata sandi yang tidak valid.
**Tujuan Tes:** Untuk memastikan bahwa sistem mencegah login ketika kata sandi yang tidak valid diberikan.
**Prasyarat:**
- Pengguna berada di halaman login Swag Labs.
**Langkah-langkah Tes:**
1.  Buka https://www.saucedemo.com/.
2.  Masukkan nama pengguna yang valid `standard_user` di kolom 'Username'.
3.  Masukkan kata sandi yang tidak valid (misalnya, `wrong_password`) di kolom 'Password'.
4.  Klik tombol 'Login'.
**Hasil yang Diharapkan:**
Pesan kesalahan ditampilkan: "Epic sadface: Username and password do not match any user in this service". Pengguna tetap berada di halaman login.

---

### ID Test Case: TC-LOGIN-004
**Judul Test Case:** Verifikasi upaya login untuk pengguna yang terkunci.
**Tujuan Tes:** Untuk memastikan bahwa pengguna yang telah terkunci dari sistem tidak dapat login.
**Prasyarat:**
- Akun pengguna `locked_out_user` ada.
- Pengguna berada di halaman login Swag Labs.
**Langkah-langkah Tes:**
1.  Buka https://www.saucedemo.com/.
2.  Masukkan nama pengguna `locked_out_user` di kolom 'Username'.
3.  Masukkan kata sandi `secret_sauce` di kolom 'Password'.
4.  Klik tombol 'Login'.
**Hasil yang Diharapkan:**
Pesan kesalahan ditampilkan: "Epic sadface: Sorry, this user has been locked out.". Pengguna tetap berada di halaman login.

---
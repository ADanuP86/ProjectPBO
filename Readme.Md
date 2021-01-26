# ProjectPBO Sistem Input Data Parkir
Nama Kelompok : - Ananto Danu Prasetyo (1907051034)
                - Muhammad Khadafi (1907051025)
                
-> Sistem ini dapat digunakan untuk penginputan data parkir kendaraan mobil dan motor, supaya dapat terlihat kendaraan yang masuk parkir diwaktu tersebut.



# Class Diagram
-> Penjelasan : 

Class diagram ini mempunyai beberapa class diantaranya DataParkir yang memiliki beberapa deklarasi atribut, DataParkirController yang berisi koneksi ke database dan beberapa fungsi untuk memodifikasi data seperti tambah, tampil, update, delete dan kita bisa mencari data di controller ini, ConnectDB memiliki fungsi untuk mengkoneksikan java dengan database MYSQL supaya data tersebut dapat dimodifikasi, dan DataParkirForm adalah tampilan desain UI untuk pengguna dapat berinteraksi langsung dengan program serta memodifikasi data.

-> Symbol : 

Penggunaan simbol "+" pada class DataParkir memiliki artian public karena atribut-atributnya dapat dipakai oleh semua class kemudian DataParkir ini mempunyai class DataParkirControler dengan simbol garis ujung lurus serta ketupat pada ujung satunya berarti class DataParkirController dapat memodifikasi data yang ada pada class DataParkir, kemudian DataParkirController mempunyai hubungan ke class ConnectDB symbol panah ke arah class ConnectionDB yang fungsinya untuk memodifikasi data yang ada kemudian dimasukkan ke database MYSQL, dan class DataParkirform mempunyai class DataParkirController untuk memodofikasi data melalui UI oleh pengguna symbol panah ke class DataParkirController. 


<img width="467" alt="Class Diagram Project JavaFXKel" src="https://user-images.githubusercontent.com/77543408/105836134-58708380-5fff-11eb-96e3-b8171dee3a34.PNG">


# ER Diagram
-> Penjelasan : 

ER diagram ini mempunyai beberapa class diantaranya DataParkir serta beberapa deklarasi atribut, mempunyai relasi dengan class DataParkirControoler yang berarti class DataParkir dapat dimodifikasi oleh banyak fungsi di class DataParkirController seperti tambah, update, delete, tampil, dan cari sehingga data yang ada dapat dimodifikasi, class DataParkirForm berelasi dengan DataParkirController berfungsi menjalankan class DataParkirController, dan class ConnectionDB berelasi dengan DataParkirController berfungsi mengkoneksikan ke database MYSQL sehingga data dapat di baca oleh class DataParkirController.


<img width="316" alt="ER Project JavaFXKel" src="https://user-images.githubusercontent.com/77543408/105836978-94f0af00-6000-11eb-832a-a4ca2417e20e.PNG">

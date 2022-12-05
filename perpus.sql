-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2022 at 01:58 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `ID_Anggota` char(5) NOT NULL,
  `Nama` varchar(20) NOT NULL,
  `Jenis_Kelamin` varchar(15) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `No_HP` varchar(12) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Tgl_Entry` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`ID_Anggota`, `Nama`, `Jenis_Kelamin`, `Alamat`, `No_HP`, `Email`, `Tgl_Entry`) VALUES
('A0001', 'Ratna', 'Perempuan', 'Sumedang', '087777777779', 'na2push@gmail.com', '2016-09-09'),
('A0002', 'Renal', 'Laki-Laki', 'Bandung', '086712894510', 'Renal@gmail.com', '2021-12-10'),
('A0003', 'Yasmina', 'Perempuan', 'Padalarang', '085974758999', 'Yasmina@gmail.com', '2021-12-10'),
('A0004', 'Kukuh', 'Laki-Laki', 'Bandung', '089546327819', 'Kukuh@gmail.com', '2021-12-10'),
('A0005', 'Alfin', 'Laki-Laki', 'Cimahi', '081265100000', 'Alfin@gmail.com', '2021-12-10'),
('A0006', 'Fadil', 'Laki-Laki', 'Lembang', '081539000126', 'Fadil@gmail.com', '2021-12-10'),
('A0007', 'Rizky', 'Laki-Laki', 'Tasik', '083218465199', 'Rizky@gmail.com', '2021-12-10'),
('A0008', 'Naufal', 'Laki-Laki', 'Karawang', '081366882154', 'Naufal@gmail.com', '2021-12-10'),
('A0009', 'Szalfa', 'Perempuan', 'Subang', '085959442213', 'Szalfa@gmail.com', '2021-12-10'),
('A0010', 'Rahmat', 'Laki-Laki', 'Cimahi', '081366670028', 'Rahmat@gmail.com', '2021-12-10'),
('A0011', 'Ardiansyah', 'Laki-Laki', 'Bandung', '081234567890', 'Ardiansyah@gmail.com', '2021-12-10'),
('A0012', 'Yusran', 'Laki-Laki', 'Bandung', '086253748191', 'Yusran@gmail.com', '2021-12-10'),
('A0013', 'Syifa', 'Perempuan', 'Cimahi', '085947881022', 'Syifa@gmail.com', '2021-12-10'),
('A0014', 'Cecep', 'Laki-Laki', 'Padalarang', '081236690012', 'Cecep@gmail.com', '2021-12-10'),
('A0015', 'Rayhan', 'Laki-Laki', 'Cimahi', '081234555580', 'Rayhan@gmail.com', '2021-12-10'),
('A0016', 'Nisya', 'Perempuan', 'Garut', '089941120033', 'Nisya@gmail.com', '2021-12-10'),
('A0017', 'Romy', 'Laki-Laki', 'Cimahi', '081221170896', 'Romy@gmail.com', '2021-12-10'),
('A0018', 'Insan', 'Laki-Laki', 'Padalarang', '081111555555', 'Insan@gmail.com', '2021-12-10'),
('A0019', 'Intan', 'Perempuan', 'Lembang', '089933110066', 'Intan@gmail.com', '2021-12-10'),
('A0020', 'Naomi', 'Perempuan', 'Purwakarta', '081320004471', 'Naomi@gmail.com', '2021-12-10');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `Kode_Buku` char(5) NOT NULL,
  `Nama_Penulis` varchar(20) NOT NULL,
  `Judul_Buku` varchar(50) NOT NULL,
  `Penerbit_Buku` varchar(20) NOT NULL,
  `Tahun_Penerbit` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`Kode_Buku`, `Nama_Penulis`, `Judul_Buku`, `Penerbit_Buku`, `Tahun_Penerbit`) VALUES
('KB001', 'Tere Liye', 'Bedebah Di Ujung Tanduk ', 'Sabak Grip Nusantara', '2021'),
('KB002', 'Lexie Xu', 'Akhir Tergelap', 'Gramedia', '2021'),
('KB003', 'Walter Isaacson', 'Biografi Steve Jobs', 'Simon & Schuster', '2011'),
('KB004', 'Linda Espacito', 'Ensiklopedia Sains', 'Kanisius', '2011'),
('KB005', 'Madcoms', 'Ensiklopedia Teknologi Komputer', 'Andi', '2016'),
('KB006', 'J.K Rowling', 'Harry Potter ', 'Gramedia', '2001'),
('KB007', 'Wayan Simpen', 'Morfologi', 'Gramedia', '2017'),
('KB008', 'J.Sudarminta', 'Etika Umum', 'Gramedia', '2009'),
('KB009', 'John & Hassan', 'Kamus Inggris-Indonesia', 'Gramedia', '2000'),
('KB010', 'William.J.Seta', 'Atlas Indonesia & Dunia', 'Serba Jaya ', '2007');

-- --------------------------------------------------------

--
-- Table structure for table `description`
--

CREATE TABLE `description` (
  `Kode_Description` char(5) NOT NULL,
  `Kode_Buku` char(5) NOT NULL,
  `Kode_Jenis` char(5) NOT NULL,
  `Jumlah_Halaman` varchar(10) NOT NULL,
  `Genre` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `description`
--

INSERT INTO `description` (`Kode_Description`, `Kode_Buku`, `Kode_Jenis`, `Jumlah_Halaman`, `Genre`) VALUES
('KD001', 'KB001', 'KJ001', '480', 'Fiksi'),
('KD002', 'KB002', 'KJ002', '416', 'Thriller'),
('KD003', 'KB003', 'KJ003', '516', 'Dokumenter'),
('KD004', 'KB004', 'KJ004', '2500', 'Non-Fiksi'),
('KD005', 'KB005', 'KJ005', '3856', 'Non-Fiksi'),
('KD006', 'KB006', 'KJ006', '401', 'Fantasi'),
('KD007', 'KB007', 'KJ007', '678', 'Science'),
('KD008', 'KB008', 'KJ008', '832', 'Science'),
('KD009', 'KB009', 'KJ009', '1400', 'Non-Fiksi'),
('KD010', 'KB010', 'KJ010', '60', 'Non-Fiksi');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_buku`
--

CREATE TABLE `jenis_buku` (
  `Kode_Jenis` char(5) NOT NULL,
  `Kode_Buku` char(5) NOT NULL,
  `Nama_Jenis` varchar(20) NOT NULL,
  `Stok` varchar(10) NOT NULL,
  `Keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenis_buku`
--

INSERT INTO `jenis_buku` (`Kode_Jenis`, `Kode_Buku`, `Nama_Jenis`, `Stok`, `Keterangan`) VALUES
('KJ001', 'KB001', 'Novel', '30', 'Buku Baru'),
('KJ002', 'KB002', 'Novel', '26', 'Buku Baru'),
('KJ003', 'KB003', 'Biografi', '19', 'Buku Lama'),
('KJ004', 'KB004', 'Ensiklopedia', '20', 'Buku Lama'),
('KJ005', 'KB005', 'Ensiklopedia', '38', 'Buku Lama'),
('KJ006', 'KB006', 'Novel', '23', 'Buku Lama'),
('KJ007', 'KB007', 'Buku Ilmiah', '21', 'Buku Lama'),
('KJ008', 'KB008', 'Buku Ilmiah', '21', 'Buku Lama'),
('KJ009', 'KB009', 'Kamus', '25', 'Buku Lama'),
('KJ010', 'KB010', 'Atlas', '10', 'Buku Lama');

-- --------------------------------------------------------

--
-- Table structure for table `penerbit`
--

CREATE TABLE `penerbit` (
  `ID_Penerbit` char(5) NOT NULL,
  `Nama_Penerbit` varchar(30) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `No_Telp` varchar(12) NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penerbit`
--

INSERT INTO `penerbit` (`ID_Penerbit`, `Nama_Penerbit`, `Alamat`, `No_Telp`, `Email`) VALUES
('PB001', 'Sabak Grip Nusantara', 'Jakarta', '081372132320', 'Sabak@gmail.com'),
('PB002', 'Gramedia', 'Tangerang', '085937213212', 'Gramedia@gmail.com'),
('PB003', 'Simon & Schuster', 'Bandung', '088323622221', 'Sischu@gmail.com'),
('PB004', 'Kanisius', 'Surabaya', '085944177088', 'Kanisius@gmail.com'),
('PB005', 'Andi', 'Jakarta', '081201372865', 'Andi@gmail.com'),
('PB006', 'Gramedia', 'Tangerang', '085937213212', 'Gramedia@gmail.com'),
('PB007', 'Gramedia', 'Tangerang', '085937213212', 'Gramedia@gmail.com'),
('PB008', 'Gramedia', 'Tangerang', '085937213212', 'Gramedia@gmail.com'),
('PB009', 'Gramedia', 'Tangerang', '085937213212', 'Gramedia@gmail.com'),
('PB010', 'Serba Jaya', 'Bandung', '081116876832', 'Sejaya@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `penulis`
--

CREATE TABLE `penulis` (
  `ID_Penulis` char(5) NOT NULL,
  `Nama_Penulis` varchar(30) NOT NULL,
  `Jenis_Kelamin` varchar(15) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `No_Telp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penulis`
--

INSERT INTO `penulis` (`ID_Penulis`, `Nama_Penulis`, `Jenis_Kelamin`, `Alamat`, `No_Telp`) VALUES
('PN001', 'Tere Liye ', 'Laki-Laki', 'Jakarta', '081253123223'),
('PN002', 'Lexie Xu', 'Perempuan', 'Tangerang', '081522100077'),
('PN003', 'Walter Isaacson', 'Laki-Laki', 'Jakarta', '081352362366'),
('PN004', 'Linda Esposito', 'Perempuan', 'Bandung', '085944100088'),
('PN005', 'Madcoms', 'Laki-Laki', 'Jakarta', '081266372865'),
('PN006', 'J.K Rowling', 'Perempuan', 'Bandung', '083253213132'),
('PN007', 'Wayan Simpen', 'Laki-Laki', 'Jakarta', '083712361322'),
('PN008', 'J.Sudarminta', 'Perempuan', 'Tangerang', '081200277771'),
('PN009', 'John & Hassan ', 'Laki-Laki', 'Jakarta', '085974750000'),
('PN010', 'William.J.Seta', 'Laki-Laki', 'Bandung', '081116668325');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `Kode_Transaksi` char(5) NOT NULL,
  `ID_Anggota` char(5) NOT NULL,
  `Kode_Buku` char(5) NOT NULL,
  `Jumlah_Buku` varchar(5) NOT NULL,
  `Tanggal_Peminjaman` date NOT NULL,
  `Tanggal_Pengembalian` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`Kode_Transaksi`, `ID_Anggota`, `Kode_Buku`, `Jumlah_Buku`, `Tanggal_Peminjaman`, `Tanggal_Pengembalian`) VALUES
('KT001', 'A0001', 'KB001', '2', '2021-12-10', '2021-12-17'),
('KT002', 'A0002', 'KB002', '1', '2021-12-10', '2021-12-17'),
('KT003', 'A0004', 'KB003', '1', '2021-12-10', '2021-12-17'),
('KT004', 'A0007', 'KB004', '1', '2021-12-10', '2021-12-17'),
('KT005', 'A0008', 'KB005', '3', '2021-12-10', '2021-12-17'),
('KT006', 'A0009', 'KB006', '3', '2021-12-10', '2021-12-17'),
('KT007', 'A0013', 'KB007', '2', '2021-12-10', '2021-12-17'),
('KT008', 'A0014', 'KB008', '3', '2021-12-10', '2021-12-17'),
('KT009', 'A0016', 'KB009', '1', '2021-12-10', '2021-12-17'),
('KT010', 'A0019', 'KB010', '2', '2021-12-10', '2021-12-17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`ID_Anggota`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`Kode_Buku`);

--
-- Indexes for table `description`
--
ALTER TABLE `description`
  ADD PRIMARY KEY (`Kode_Description`),
  ADD KEY `Kode_Buku` (`Kode_Buku`),
  ADD KEY `Kode_Jenis` (`Kode_Jenis`);

--
-- Indexes for table `jenis_buku`
--
ALTER TABLE `jenis_buku`
  ADD PRIMARY KEY (`Kode_Jenis`),
  ADD KEY `Kode_Buku` (`Kode_Buku`);

--
-- Indexes for table `penerbit`
--
ALTER TABLE `penerbit`
  ADD PRIMARY KEY (`ID_Penerbit`);

--
-- Indexes for table `penulis`
--
ALTER TABLE `penulis`
  ADD PRIMARY KEY (`ID_Penulis`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`Kode_Transaksi`),
  ADD KEY `Kode_Buku` (`Kode_Buku`),
  ADD KEY `ID_Anggota` (`ID_Anggota`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `description`
--
ALTER TABLE `description`
  ADD CONSTRAINT `description_ibfk_1` FOREIGN KEY (`Kode_Buku`) REFERENCES `buku` (`Kode_Buku`),
  ADD CONSTRAINT `description_ibfk_2` FOREIGN KEY (`Kode_Jenis`) REFERENCES `jenis_buku` (`Kode_Jenis`);

--
-- Constraints for table `jenis_buku`
--
ALTER TABLE `jenis_buku`
  ADD CONSTRAINT `jenis_buku_ibfk_1` FOREIGN KEY (`Kode_Buku`) REFERENCES `buku` (`Kode_Buku`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`Kode_Buku`) REFERENCES `buku` (`Kode_Buku`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`ID_Anggota`) REFERENCES `anggota` (`ID_Anggota`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

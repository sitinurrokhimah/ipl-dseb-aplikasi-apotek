-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2022 at 01:40 PM
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
-- Database: `apkapotek`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `total_harga_transaksi` ()  BEGIN
SELECT 
SUM(tb_keranjang.Jumlah*tb_keranjang.Harga) AS TotalHarga
FROM tb_keranjang;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID_Admin` varchar(10) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID_Admin`, `Username`, `Password`) VALUES
('ADM001', 'Admin', 'admin'),
('ADM003', 'Mina', 'admin'),
('ADM002', 'Romi', 'admin'),
('ADM004', 'Szalfa', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `db_obat`
--

CREATE TABLE `db_obat` (
  `ID_Obat` int(10) NOT NULL,
  `NamaObat` varchar(50) NOT NULL,
  `Harga` int(50) NOT NULL,
  `Stok` int(50) NOT NULL,
  `Keterangan` char(50) NOT NULL,
  `Exp_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `IDKasir` varchar(10) NOT NULL,
  `ID_Obat` int(10) NOT NULL,
  `NamaObat` varchar(50) NOT NULL,
  `harga_jual` varchar(20) NOT NULL,
  `item` varchar(20) NOT NULL,
  `jumlah` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Username`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `ID_Admin` (`ID_Admin`);

--
-- Indexes for table `db_obat`
--
ALTER TABLE `db_obat`
  ADD PRIMARY KEY (`ID_Obat`),
  ADD UNIQUE KEY `NamaObat` (`NamaObat`),
  ADD UNIQUE KEY `NamaObat_2` (`NamaObat`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`IDKasir`),
  ADD UNIQUE KEY `ID_Obat` (`ID_Obat`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kasir`
--
ALTER TABLE `kasir`
  ADD CONSTRAINT `kasir_ibfk_1` FOREIGN KEY (`ID_Obat`) REFERENCES `db_obat` (`ID_Obat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

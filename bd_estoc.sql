-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2016 at 06:54 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_estoc`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_categoria`
--

CREATE TABLE `tbl_categoria` (
  `categoria_id` int(11) NOT NULL,
  `categoria_nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_categoria`
--

INSERT INTO `tbl_categoria` (`categoria_id`, `categoria_nom`) VALUES
(1, 'Sillas de comedor'),
(2, 'Sillones'),
(3, 'Barras y sillas'),
(4, 'Muebles de bar'),
(5, 'Juegos de comedor'),
(6, 'Tronas'),
(7, 'Sillas altas ninos'),
(8, 'Sillas de trabajo'),
(9, 'Taburetes escalera'),
(10, 'Taburetes y bancos');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_comanda`
--

CREATE TABLE `tbl_comanda` (
  `comanda_id` int(11) NOT NULL,
  `comanda_quantitat` int(5) NOT NULL,
  `comanda_data` date NOT NULL,
  `prov_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_detall_com`
--

CREATE TABLE `tbl_detall_com` (
  `detall_com_id` int(11) NOT NULL,
  `comanda_id` int(11) NOT NULL,
  `prod_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_estoc`
--

CREATE TABLE `tbl_estoc` (
  `estoc_id` int(11) NOT NULL,
  `estoc_q_max` int(5) NOT NULL,
  `estoc_q_actual` int(5) NOT NULL,
  `estoc_q_min` int(5) NOT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `lloc_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_estoc`
--

INSERT INTO `tbl_estoc` (`estoc_id`, `estoc_q_max`, `estoc_q_actual`, `estoc_q_min`, `prod_id`, `lloc_id`) VALUES
(1, 10, 10, 1, 1, 1),
(2, 10, 7, 1, 2, 2),
(3, 10, 6, 1, 3, 3),
(4, 10, 8, 1, 4, 4),
(5, 10, 3, 1, 5, 5),
(6, 10, 5, 1, 6, 6),
(7, 10, 10, 1, 7, 7),
(8, 10, 7, 1, 8, 8),
(9, 10, 6, 1, 9, 9),
(10, 10, 4, 1, 10, 10),
(11, 10, 3, 1, 11, 11),
(12, 10, 4, 1, 12, 12),
(13, 10, 8, 1, 13, 13),
(14, 10, 9, 1, 14, 14),
(15, 10, 5, 1, 15, 15),
(16, 10, 7, 1, 16, 16),
(17, 10, 6, 1, 17, 17),
(18, 10, 6, 1, 18, 18),
(19, 10, 8, 1, 19, 19),
(20, 10, 3, 1, 20, 20),
(21, 10, 7, 1, 21, 21),
(22, 10, 3, 1, 22, 22),
(23, 10, 5, 1, 23, 23),
(24, 10, 2, 1, 24, 24),
(25, 10, 7, 1, 25, 25),
(26, 10, 7, 1, 26, 26),
(27, 10, 10, 1, 27, 27),
(28, 10, 9, 1, 28, 28),
(29, 10, 9, 1, 29, 29),
(30, 10, 4, 1, 30, 30),
(31, 10, 8, 1, 31, 31),
(32, 10, 3, 1, 32, 32),
(33, 10, 6, 1, 33, 33),
(34, 10, 7, 1, 34, 34),
(35, 10, 8, 1, 35, 35),
(36, 10, 3, 1, 36, 36),
(37, 10, 4, 1, 37, 37);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_lloc`
--

CREATE TABLE `tbl_lloc` (
  `lloc_id` int(11) NOT NULL,
  `num_bloc` enum('Bloc 1','Bloc 2','Bloc3','Bloc 4','Bloc 5','Bloc 6','Bloc 7','Bloc 8') COLLATE utf8_unicode_ci NOT NULL,
  `num_passadis` enum('passadis 1','passadis 2','passadis 3','passadis 4','passadis 5','passadis 6','passadis 7','passadis 8','passadis 9','passadis 10','passadis 11','passadis 12') COLLATE utf8_unicode_ci NOT NULL,
  `num_lleixa` enum('lleixa 1','lleixa 2','lleixa 3','lleixa 4','lleixa 5','lleixa 6','lleixa 7','lleixa 8') COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_lloc`
--

INSERT INTO `tbl_lloc` (`lloc_id`, `num_bloc`, `num_passadis`, `num_lleixa`) VALUES
(1, 'Bloc 1', 'passadis 1', 'lleixa 1'),
(2, 'Bloc 1', 'passadis 1', 'lleixa 2'),
(3, 'Bloc 1', 'passadis 1', 'lleixa 3'),
(4, 'Bloc 1', 'passadis 1', 'lleixa 4'),
(5, 'Bloc 1', 'passadis 1', 'lleixa 5'),
(6, 'Bloc 1', 'passadis 2', 'lleixa 1'),
(7, 'Bloc 1', 'passadis 2', 'lleixa 2'),
(8, 'Bloc 1', 'passadis 2', 'lleixa 3'),
(9, 'Bloc 1', 'passadis 2', 'lleixa 4'),
(10, 'Bloc 1', 'passadis 2', 'lleixa 5'),
(11, 'Bloc 1', 'passadis 3', 'lleixa 1'),
(12, 'Bloc 1', 'passadis 3', 'lleixa 2'),
(13, 'Bloc 1', 'passadis 3', 'lleixa 3'),
(14, 'Bloc 1', 'passadis 3', 'lleixa 4'),
(15, 'Bloc 1', 'passadis 3', 'lleixa 5'),
(16, 'Bloc 1', 'passadis 4', 'lleixa 1'),
(17, 'Bloc 1', 'passadis 4', 'lleixa 2'),
(18, 'Bloc 1', 'passadis 5', 'lleixa 1'),
(19, 'Bloc 1', 'passadis 5', 'lleixa 2'),
(20, 'Bloc 1', 'passadis 5', 'lleixa 3'),
(21, 'Bloc 1', 'passadis 5', 'lleixa 4'),
(22, 'Bloc 1', 'passadis 5', 'lleixa 5'),
(23, 'Bloc 1', 'passadis 6', 'lleixa 1'),
(24, 'Bloc 1', 'passadis 6', 'lleixa 2'),
(25, 'Bloc 1', 'passadis 7', 'lleixa 1'),
(26, 'Bloc 1', 'passadis 7', 'lleixa 2'),
(27, 'Bloc 1', 'passadis 8', 'lleixa 1'),
(28, 'Bloc 1', 'passadis 8', 'lleixa 2'),
(29, 'Bloc 1', 'passadis 8', 'lleixa 3'),
(30, 'Bloc 1', 'passadis 8', 'lleixa 4'),
(31, 'Bloc 1', 'passadis 8', 'lleixa 5'),
(32, 'Bloc 1', 'passadis 9', 'lleixa 1'),
(33, 'Bloc 1', 'passadis 10', 'lleixa 1'),
(34, 'Bloc 1', 'passadis 10', 'lleixa 2'),
(35, 'Bloc 1', 'passadis 10', 'lleixa 3'),
(36, 'Bloc 1', 'passadis 10', 'lleixa 4'),
(37, 'Bloc 1', 'passadis 10', 'lleixa 5');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_producte`
--

CREATE TABLE `tbl_producte` (
  `prod_id` int(11) NOT NULL,
  `prod_nom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `prod_foto` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `serie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_producte`
--

INSERT INTO `tbl_producte` (`prod_id`, `prod_nom`, `prod_foto`, `serie_id`) VALUES
(1, 'Janinge', 'sillas-de-comedor1.jpg', 1),
(2, 'Ingolf', 'sillas-de-comedor2.jpg', 2),
(3, 'Lerham', 'sillas-de-comedor3.jpg', 3),
(4, 'Tobias', 'sillas-de-comedor4.jpg', 4),
(5, 'Volfgang', 'sillas-de-comedor5.jpg', 5),
(6, 'Landskrona', 'sillones1.jpg', 6),
(7, 'Mellby', 'sillones2.jpg', 7),
(8, 'Poang', 'sillones3.jpg', 8),
(9, 'Storsele', 'sillones4.jpg', 9),
(10, 'Byholma', 'sillones5.jpg', 10),
(11, 'Utby', 'barras-y-sillas1.jpg', 11),
(12, 'Franklin', 'barras-y-sillas2.jpg', 12),
(13, 'Billsta', 'barras-y-sillas3.jpg', 13),
(14, 'Stornas', 'barras-y-sillas4.jpg', 14),
(15, 'Henriksdal', 'barras-y-sillas5.jpg', 15),
(16, 'Norraker', 'muebles-de-bar1.jpg', 16),
(17, 'Tunholmen', 'muebles-de-bar2.jpg', 17),
(18, 'Bekvam', 'taburetes-y-bancos1.jpg', 18),
(19, 'Ingolf', 'taburetes-y-bancos2.jpg', 19),
(20, 'Frosta', 'taburetes-y-bancos3.jpg', 20),
(21, 'Raskog', 'taburetes-y-bancos4.jpg', 21),
(22, 'Marius', 'taburetes-y-bancos5.jpg', 22),
(23, 'Masterby', 'taburetes-y-escalera1.jpg', 23),
(24, 'Snille', 'sillas-de-trabajo1.jpg', 24),
(25, 'Gregor', 'sillas-de-trabajo2.jpg', 25),
(26, 'Orfjall', 'sillas-de-trabajo3.jpg', 26),
(27, 'Alrik', 'sillas-de-trabajo4.jpg', 27),
(28, 'Lillhojden', 'sillas-de-trabajo5.jpg', 28),
(29, 'Urban', 'sillas-altas-ninos1.jpg', 29),
(30, 'Agam', 'sillas-altas-ninos2.jpg', 30),
(31, 'Antilop', 'tronas1.jpg', 31),
(32, 'Blames', 'tronas2.jpg', 32),
(33, 'Melltorp', 'juegos-de-comedor1.jpg', 33),
(34, 'Norberg', 'juegos-de-comedor2.jpg', 34),
(35, 'Tarendo', 'juegos-de-comedor3.jpg', 35),
(36, 'Granas', 'juegos-de-comedor4.jpg', 36),
(37, 'Bjursta', 'juegos-de-comedor5.jpg', 37);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_proveidor`
--

CREATE TABLE `tbl_proveidor` (
  `prov_id` int(11) NOT NULL,
  `prov_nom` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `prov_adre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `prov_email` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_proveidor`
--

INSERT INTO `tbl_proveidor` (`prov_id`, `prov_nom`, `prov_adre`, `prov_email`) VALUES
(1, 'Ikea', 'c/Barcelona nº 200', 'ikea@gmail.com'),
(2, 'David Marin', 'c/Horta nº 123', 'david.marin@fje.edu\r\n'),
(3, 'Sergio Jimenez', 'c/Java nº321', 'javaesfacil@gmail.com'),
(4, 'Ignasi Romero', 'c/LibrosWeb nº7', 'ignasi@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_serie`
--

CREATE TABLE `tbl_serie` (
  `serie_id` int(11) NOT NULL,
  `serie_nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `categoria_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_serie`
--

INSERT INTO `tbl_serie` (`serie_id`, `serie_nom`, `categoria_id`) VALUES
(1, '002.460.78', 1),
(2, '701.032.50', 1),
(3, '202.594.23', 1),
(4, '201.150.38', 1),
(5, '802.690.99', 1),
(6, '690.318.05', 2),
(7, '391.506.49', 2),
(8, '791.813.14', 2),
(9, '202.016.82', 2),
(10, '601.583.04', 2),
(11, '098.434.59', 3),
(12, '501.992.15', 3),
(13, '291.287.05', 3),
(14, '702.176.52', 3),
(15, '101.445.69', 3),
(16, '390.484.21', 4),
(17, '390.484.22', 4),
(18, '601.788.87', 10),
(19, '302.178.33', 10),
(20, '102.957.42', 10),
(21, '803.083.93', 10),
(22, '101.356.59', 10),
(23, '403.320.74', 9),
(24, '790.462.60', 8),
(25, '702.604.62', 8),
(26, '703.270.66', 8),
(27, '402.141.17', 8),
(28, '402.387.12', 8),
(29, '001.652.13', 7),
(30, '902.535.35', 7),
(31, '890.417.09', 6),
(32, '301.650.80', 6),
(33, '890.292.98', 5),
(34, '799.127.60', 5),
(35, '790.106.90', 5),
(36, '102.720.57', 5),
(37, '790.106.52', 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE `tbl_users` (
  `usu_id` int(11) NOT NULL,
  `usu_nombre` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `usu_password` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_categoria`
--
ALTER TABLE `tbl_categoria`
  ADD PRIMARY KEY (`categoria_id`);

--
-- Indexes for table `tbl_comanda`
--
ALTER TABLE `tbl_comanda`
  ADD PRIMARY KEY (`comanda_id`),
  ADD KEY `FK_comanda_prov` (`prov_id`);

--
-- Indexes for table `tbl_detall_com`
--
ALTER TABLE `tbl_detall_com`
  ADD PRIMARY KEY (`detall_com_id`),
  ADD KEY `FK_detall_com_prod` (`prod_id`),
  ADD KEY `FK_detall_com_comanda` (`comanda_id`);

--
-- Indexes for table `tbl_estoc`
--
ALTER TABLE `tbl_estoc`
  ADD PRIMARY KEY (`estoc_id`),
  ADD KEY `FK_estoc_prod` (`prod_id`),
  ADD KEY `FK_estoc_lloc` (`lloc_id`);

--
-- Indexes for table `tbl_lloc`
--
ALTER TABLE `tbl_lloc`
  ADD PRIMARY KEY (`lloc_id`);

--
-- Indexes for table `tbl_producte`
--
ALTER TABLE `tbl_producte`
  ADD PRIMARY KEY (`prod_id`),
  ADD KEY `FK_prod_serie` (`serie_id`);

--
-- Indexes for table `tbl_proveidor`
--
ALTER TABLE `tbl_proveidor`
  ADD PRIMARY KEY (`prov_id`);

--
-- Indexes for table `tbl_serie`
--
ALTER TABLE `tbl_serie`
  ADD PRIMARY KEY (`serie_id`),
  ADD KEY `FK_serie_categoria` (`categoria_id`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
  ADD PRIMARY KEY (`usu_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_categoria`
--
ALTER TABLE `tbl_categoria`
  MODIFY `categoria_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_comanda`
--
ALTER TABLE `tbl_comanda`
  MODIFY `comanda_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_detall_com`
--
ALTER TABLE `tbl_detall_com`
  MODIFY `detall_com_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_estoc`
--
ALTER TABLE `tbl_estoc`
  MODIFY `estoc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT for table `tbl_lloc`
--
ALTER TABLE `tbl_lloc`
  MODIFY `lloc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT for table `tbl_producte`
--
ALTER TABLE `tbl_producte`
  MODIFY `prod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT for table `tbl_proveidor`
--
ALTER TABLE `tbl_proveidor`
  MODIFY `prov_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_serie`
--
ALTER TABLE `tbl_serie`
  MODIFY `serie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
  MODIFY `usu_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_comanda`
--
ALTER TABLE `tbl_comanda`
  ADD CONSTRAINT `FK_comanda_prov` FOREIGN KEY (`prov_id`) REFERENCES `tbl_proveidor` (`prov_id`);

--
-- Constraints for table `tbl_detall_com`
--
ALTER TABLE `tbl_detall_com`
  ADD CONSTRAINT `FK_detall_com_comanda` FOREIGN KEY (`comanda_id`) REFERENCES `tbl_comanda` (`comanda_id`),
  ADD CONSTRAINT `FK_detall_com_prod` FOREIGN KEY (`prod_id`) REFERENCES `tbl_producte` (`prod_id`);

--
-- Constraints for table `tbl_estoc`
--
ALTER TABLE `tbl_estoc`
  ADD CONSTRAINT `FK_estoc_lloc` FOREIGN KEY (`lloc_id`) REFERENCES `tbl_lloc` (`lloc_id`),
  ADD CONSTRAINT `FK_estoc_prod` FOREIGN KEY (`prod_id`) REFERENCES `tbl_producte` (`prod_id`);

--
-- Constraints for table `tbl_producte`
--
ALTER TABLE `tbl_producte`
  ADD CONSTRAINT `FK_prod_serie` FOREIGN KEY (`serie_id`) REFERENCES `tbl_serie` (`serie_id`);

--
-- Constraints for table `tbl_serie`
--
ALTER TABLE `tbl_serie`
  ADD CONSTRAINT `FK_serie_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `tbl_categoria` (`categoria_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

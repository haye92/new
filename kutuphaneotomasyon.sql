-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 30 Eyl 2020, 19:15:05
-- Sunucu sürümü: 5.7.31
-- PHP Sürümü: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kutuphaneotomasyon`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `emanetkitap`
--

DROP TABLE IF EXISTS `emanetkitap`;
CREATE TABLE IF NOT EXISTS `emanetkitap` (
  `islemID` int(11) NOT NULL AUTO_INCREMENT,
  `kisiID` int(11) NOT NULL,
  `kitapID` int(11) NOT NULL,
  `emanetTarihi` date NOT NULL,
  `iadeTarihi` date DEFAULT NULL,
  `muddet` date NOT NULL,
  `odenecekCeza` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`islemID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `emanetkitap`
--

INSERT INTO `emanetkitap` (`islemID`, `kisiID`, `kitapID`, `emanetTarihi`, `iadeTarihi`, `muddet`, `odenecekCeza`) VALUES
(1, 2, 1, '2020-09-29', '2020-09-29', '2020-10-03', NULL),
(2, 2, 2, '2020-09-29', NULL, '2020-10-03', NULL),
(3, 2, 2, '2020-09-29', NULL, '2020-10-03', NULL),
(4, 2, 3, '2020-09-29', NULL, '2020-09-15', NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kisiler`
--

DROP TABLE IF EXISTS `kisiler`;
CREATE TABLE IF NOT EXISTS `kisiler` (
  `kisiID` int(11) NOT NULL AUTO_INCREMENT,
  `kisiAdi` varchar(256) NOT NULL,
  `kisiSoyadi` varchar(256) NOT NULL,
  `kisiBolum` varchar(256) NOT NULL,
  PRIMARY KEY (`kisiID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `kisiler`
--

INSERT INTO `kisiler` (`kisiID`, `kisiAdi`, `kisiSoyadi`, `kisiBolum`) VALUES
(1, 'Ayse', 'Kahveci', 'Yazılım Mühendisliği'),
(2, 'Test', 'ads', 'asd'),
(5, 'Test', 'ad??s', 'asd'),
(4, 'Test', 'ads', 'asd'),
(6, 'Test', 'adşşs', 'asd'),
(7, 'Test', 'adşşs', 'asd');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitaplar`
--

DROP TABLE IF EXISTS `kitaplar`;
CREATE TABLE IF NOT EXISTS `kitaplar` (
  `kitapID` int(11) NOT NULL AUTO_INCREMENT,
  `kitapAdi` varchar(256) NOT NULL,
  `kitapYazari` varchar(256) NOT NULL,
  `kitapSayfa` int(11) NOT NULL,
  `kitapKategori` varchar(256) NOT NULL,
  `kitapYayinevi` varchar(256) NOT NULL,
  PRIMARY KEY (`kitapID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `kitaplar`
--

INSERT INTO `kitaplar` (`kitapID`, `kitapAdi`, `kitapYazari`, `kitapSayfa`, `kitapKategori`, `kitapYayinevi`) VALUES
(1, 'Çalıkuşu', 'Reşat Nuri', 541, 'Roman', 'İnkılap Yayınları'),
(2, 'Çalıkuşu', 'Reşat Nuri', 541, 'Roman', 'İnkılap Yayınları'),
(4, 'Çalıkuşu', 'Reşat Nuri', 541, 'Roman', 'İnkılap Yayınları');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

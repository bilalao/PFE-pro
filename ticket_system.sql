-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 13, 2020 at 11:30 AM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ticket_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
CREATE TABLE IF NOT EXISTS `bus` (
  `idBus` int(10) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(30) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL,
  `total_seat` int(5) NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'intercity',
  PRIMARY KEY (`idBus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `numcli` int(11) NOT NULL DEFAULT '0',
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numcli`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `destinations`
--

DROP TABLE IF EXISTS `destinations`;
CREATE TABLE IF NOT EXISTS `destinations` (
  `idDest` int(30) NOT NULL,
  `station_from` int(20) NOT NULL,
  `station_to` int(20) NOT NULL,
  `time` int(11) NOT NULL,
  `fare` varchar(5) NOT NULL,
  `last_activity` int(11) NOT NULL,
  `total_seat` int(5) NOT NULL,
  `type` varchar(6) NOT NULL,
  `stations_id` int(30) NOT NULL,
  `bus_id` int(10) NOT NULL,
  PRIMARY KEY (`idDest`),
  KEY `fk_destinations_stations1_idx` (`stations_id`),
  KEY `fk_destinations_bus1_idx` (`bus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
CREATE TABLE IF NOT EXISTS `reservations` (
  `idResrvation` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `seat_numbers` int(11) NOT NULL,
  `number_of_seat` int(11) NOT NULL,
  `journey_date` datetime NOT NULL,
  `booking_date` datetime NOT NULL,
  `bus_id` int(10) NOT NULL,
  `client_numcli` int(11) NOT NULL,
  PRIMARY KEY (`idResrvation`),
  KEY `fk_bbu_bus1_idx` (`bus_id`),
  KEY `fk_reservations_client1_idx` (`client_numcli`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reservations_has_destinations`
--

DROP TABLE IF EXISTS `reservations_has_destinations`;
CREATE TABLE IF NOT EXISTS `reservations_has_destinations` (
  `reservations_id` int(20) UNSIGNED NOT NULL,
  `destinations_id` int(30) NOT NULL,
  PRIMARY KEY (`reservations_id`,`destinations_id`),
  KEY `fk_reservations_has_destinations_destinations1_idx` (`destinations_id`),
  KEY `fk_reservations_has_destinations_reservations1_idx` (`reservations_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
CREATE TABLE IF NOT EXISTS `stations` (
  `idStation` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(70) NOT NULL,
  `contact` varchar(20) NOT NULL,
  PRIMARY KEY (`idStation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `destinations`
--
ALTER TABLE `destinations`
  ADD CONSTRAINT `fk_destinations_bus1` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`idBus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_destinations_stations1` FOREIGN KEY (`stations_id`) REFERENCES `stations` (`idStation`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `fk_bbu_bus1` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`idBus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reservations_client1` FOREIGN KEY (`client_numcli`) REFERENCES `client` (`numcli`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reservations_has_destinations`
--
ALTER TABLE `reservations_has_destinations`
  ADD CONSTRAINT `fk_reservations_has_destinations_destinations1` FOREIGN KEY (`destinations_id`) REFERENCES `destinations` (`idDest`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reservations_has_destinations_reservations1` FOREIGN KEY (`reservations_id`) REFERENCES `reservations` (`idResrvation`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

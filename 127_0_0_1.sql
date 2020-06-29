-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 29, 2020 at 02:11 AM
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
-- Database: `db`
--
CREATE DATABASE IF NOT EXISTS `db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db`;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMP_NAME` varchar(100) DEFAULT NULL,
  `EMP_ADDRESS` varchar(500) DEFAULT NULL,
  `EMP_MOBILE_NOS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `numProd` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) DEFAULT NULL,
  `famille` varchar(40) DEFAULT NULL,
  `prixAchat` decimal(10,2) DEFAULT NULL,
  `prixVente` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`numProd`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit_n`
--

DROP TABLE IF EXISTS `produit_n`;
CREATE TABLE IF NOT EXISTS `produit_n` (
  `numProd` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) DEFAULT NULL,
  `famille` varchar(40) DEFAULT NULL,
  `prixAchat` decimal(10,2) DEFAULT NULL,
  `prixVente` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`numProd`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
--
-- Database: `dbcommandes`
--
CREATE DATABASE IF NOT EXISTS `dbcommandes` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbcommandes`;

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `numart` int(11) NOT NULL AUTO_INCREMENT,
  `libart` varchar(40) DEFAULT NULL,
  `prix_unitaire` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`numart`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`numart`, `libart`, `prix_unitaire`) VALUES
(1, 'Cuisinière', '1500.70'),
(2, 'Four micro-ondes', '760.00'),
(3, 'Four à vapeur', '3000.70'),
(4, 'Cuisinière à gaz', '1260.00'),
(5, 'Lave-vaisselle', '2800.00'),
(6, 'Sèche-linge', '660.99'),
(7, 'Raisin', '29.70'),
(8, 'Cerises', '35.00'),
(9, 'Céleri branche', '35.70'),
(10, 'Pomme', '19.00'),
(11, 'Orange', '13.00'),
(12, 'Abricot', '33.00'),
(13, 'Tomates', '10.00'),
(14, 'Carottes', '4.00'),
(15, 'Pois', '13.00'),
(16, 'Sel', '7.00'),
(17, 'Poivres', '8.50'),
(18, 'Epices', '4.00'),
(19, 'Vanille', '3.00'),
(20, 'Huiles', '20.00');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `numcli` int(11) NOT NULL AUTO_INCREMENT,
  `nomcli` varchar(30) DEFAULT NULL,
  `villecli` varchar(40) DEFAULT NULL,
  `cpcli` int(11) DEFAULT NULL,
  `telcli` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`numcli`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`numcli`, `nomcli`, `villecli`, `cpcli`, `telcli`) VALUES
(1, 'El Bouazzaoui', 'TANGER', 90050, '0677906022'),
(2, 'El Mohaddeb', 'RABAT', 91150, '0666906022'),
(3, 'RAZIK', 'CASA', 91250, '0655906022'),
(4, 'Oualyouddine', 'TETOUAN', 92250, '0644906022'),
(5, 'Aït Ali', 'CASA', 90051, '0677906033'),
(6, 'HASSAN', 'TANGER', 90350, '0677906011'),
(7, 'Chakroun', 'CASA', 91450, '0677906077'),
(8, 'Remmal', 'TETOUAN', 92361, '0677902222'),
(9, 'Sedki', 'RABAT', 90050, '0677903322'),
(10, 'Morchid', 'RABAT', 90177, '0677908822'),
(11, 'TAZI', 'CASA', 90444, '0677226022'),
(12, 'Yazami', 'RABAT', 99070, '0656906022'),
(13, 'Berrada', 'TETOUAN', 96750, '0678906022'),
(14, 'Edison', 'CASA', 95590, '0679906022'),
(15, 'Ader', 'TANGER', 90029, '0677955022'),
(16, 'Steve', 'TETOUAN', 90678, '0677346022'),
(17, 'JENNER', 'CASA', 90059, '0677908822'),
(18, 'Verbiest', 'TETOUAN', 90028, '0677346022'),
(19, 'MILAN', 'TANGER', 90077, '0677906622'),
(20, 'BELL', 'RABAT', 90222, '0677902322'),
(21, 'Grec', 'CASA', 90333, '0677901922'),
(22, 'Nicéphore', 'TETOUAN', 90899, '0677927022');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `numcom` int(11) NOT NULL AUTO_INCREMENT,
  `datecom` date DEFAULT NULL,
  `numcli` int(11) DEFAULT NULL,
  `numrep` int(11) DEFAULT NULL,
  PRIMARY KEY (`numcom`),
  KEY `fk_com_cli` (`numcli`),
  KEY `fk_com_rep` (`numrep`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`numcom`, `datecom`, `numcli`, `numrep`) VALUES
(1, '2010-01-22', 1, 16),
(2, '2010-05-23', 2, 16),
(3, '2010-09-14', 3, 16),
(4, '2010-12-19', 4, 9),
(5, '2011-04-23', 5, 9),
(6, '2012-03-20', 6, 9),
(7, '2013-11-19', 7, 9),
(8, '2014-10-18', 8, 10),
(9, '2015-09-17', 8, 10),
(10, '2016-08-16', 9, 6),
(11, '2017-07-15', 10, 6),
(12, '2018-06-14', 11, 6),
(13, '2018-05-03', 12, 1),
(14, '2017-04-04', 13, 1),
(15, '2016-02-17', 14, 10),
(16, '2015-03-17', 15, 1),
(17, '2014-04-24', 16, 8),
(18, '2013-05-23', 17, 14),
(19, '2012-12-22', 18, 14),
(20, '2011-03-10', 19, 14),
(21, '2012-07-13', 20, 2),
(22, '2013-06-12', 10, NULL),
(23, '2014-10-11', 1, 2),
(24, '2015-04-05', 10, 2),
(25, '2016-08-01', 11, 13),
(26, '2017-09-17', 15, 13),
(27, '2018-11-15', 11, 13),
(28, '2015-10-13', 1, 8),
(29, '2014-11-12', 15, 8),
(30, '2013-12-11', 17, 1),
(31, '2015-03-05', 15, 19),
(32, '2018-05-01', 17, 19),
(33, '2013-06-17', 20, 19),
(34, '2018-09-15', 20, 19);

-- --------------------------------------------------------

--
-- Table structure for table `ligne_commande`
--

DROP TABLE IF EXISTS `ligne_commande`;
CREATE TABLE IF NOT EXISTS `ligne_commande` (
  `id_licom` int(11) NOT NULL AUTO_INCREMENT,
  `numcom` int(11) DEFAULT NULL,
  `numart` int(11) DEFAULT NULL,
  `qte` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_licom`),
  KEY `fk_licom_cli` (`numcom`),
  KEY `fk_licom_art` (`numart`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ligne_commande`
--

INSERT INTO `ligne_commande` (`id_licom`, `numcom`, `numart`, `qte`) VALUES
(1, 30, 1, NULL),
(2, 30, 2, NULL),
(3, 30, 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
CREATE TABLE IF NOT EXISTS `region` (
  `numreg` int(11) NOT NULL AUTO_INCREMENT,
  `NOMREGION` varchar(40) DEFAULT NULL,
  `nbHabitant` int(11) DEFAULT NULL,
  PRIMARY KEY (`numreg`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `region`
--

INSERT INTO `region` (`numreg`, `NOMREGION`, `nbHabitant`) VALUES
(1, 'Tanger-Tétouan-Al Hoceïma', 120000),
(2, 'Oriental', 150000),
(3, 'Fès-Meknès', 180000),
(4, 'Rabat-Salé-Kénitra', 120780),
(5, 'Béni Mellal-Khénifra', 12666),
(6, 'Casablanca-Settat', 129000),
(7, 'Marrakech-Safi', 187000),
(8, 'Drâa-Tafilalet', 12000000);

-- --------------------------------------------------------

--
-- Table structure for table `representant`
--

DROP TABLE IF EXISTS `representant`;
CREATE TABLE IF NOT EXISTS `representant` (
  `numrep` int(11) NOT NULL AUTO_INCREMENT,
  `nomrep` varchar(30) DEFAULT NULL,
  `telrep` varchar(40) DEFAULT NULL,
  `numreg` int(11) DEFAULT NULL,
  PRIMARY KEY (`numrep`),
  KEY `fk_rep_region` (`numreg`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `representant`
--

INSERT INTO `representant` (`numrep`, `nomrep`, `telrep`, `numreg`) VALUES
(1, 'Majid', '0611223355', 1),
(2, 'Mostapha', '0690903355', 2),
(3, 'SAID', '0680703355', 7),
(4, 'Abdelaziz', '0630703355', 3),
(5, 'Youssef', '0655663355', 3),
(6, 'ALAOUI', '0622338855', 2),
(7, 'Abdellah', '0610103355', 6),
(8, 'Adnane', '0620203355', 6),
(9, 'Leila', '0640403355', 4),
(10, 'Imad', '0650503355', 5),
(11, 'Abdelalziz', '0660603355', 8),
(12, 'Rachid', '0670803355', 5),
(13, 'Mehdi', '0688993355', 8),
(14, 'Thomas', '0633903355', 3),
(15, 'Clement', '0666993355', 2),
(16, 'EDWARD', '0644553355', 6),
(17, 'Ferdinand', '0620993355', 6),
(18, 'GRAHAM', '0627893355', 7),
(19, 'JOSEPH', '0630903355', 2);
--
-- Database: `dbemploye`
--
CREATE DATABASE IF NOT EXISTS `dbemploye` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbemploye`;

-- --------------------------------------------------------

--
-- Table structure for table `departement`
--

DROP TABLE IF EXISTS `departement`;
CREATE TABLE IF NOT EXISTS `departement` (
  `num_dept` int(11) NOT NULL AUTO_INCREMENT,
  `nom_dept` varchar(30) DEFAULT NULL,
  `ville_dept` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`num_dept`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departement`
--

INSERT INTO `departement` (`num_dept`, `nom_dept`, `ville_dept`) VALUES
(1, 'Administration', 'Casa'),
(2, 'Marketing', 'Rabat'),
(3, 'Shipping', 'Tetouan'),
(4, 'IT', 'Rabat');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `telx` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `adresse`, `telx`) VALUES
(3, 'ismo', 'ista', '061345678'),
(2, 'hibernate N', 'Hibernate P', 'test');
--
-- Database: `dbemploye_1`
--
CREATE DATABASE IF NOT EXISTS `dbemploye_1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbemploye_1`;

-- --------------------------------------------------------

--
-- Table structure for table `departement`
--

DROP TABLE IF EXISTS `departement`;
CREATE TABLE IF NOT EXISTS `departement` (
  `num_dept` int(11) NOT NULL AUTO_INCREMENT,
  `nom_dept` varchar(30) DEFAULT NULL,
  `ville_dept` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`num_dept`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departement`
--

INSERT INTO `departement` (`num_dept`, `nom_dept`, `ville_dept`) VALUES
(1, 'Administration', 'Casa'),
(2, 'Marketing', 'Rabat'),
(3, 'Shipping', 'Tetouan'),
(4, 'IT', 'Rabat');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `Matricule` varchar(10) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `salaire` double DEFAULT NULL,
  `num_dept` int(11) DEFAULT NULL,
  PRIMARY KEY (`Matricule`),
  KEY `fk_emp_dept` (`num_dept`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`Matricule`, `nom`, `prenom`, `sexe`, `salaire`, `num_dept`) VALUES
('EMP01', 'Murphy', 'Diane', 'homme', 55000, 1),
('EMP02', 'Patterson', 'Mary', 'femme', 10000, 1),
('EMP03', 'Firrelli', 'Jeff', 'homme', 12000, 2),
('EMP04', 'Patterson', 'William', 'homme', 4000, 4),
('EMP05', 'Bondur', 'Gerard', 'homme', 800, 4),
('EMP06', 'Bow', 'Anthony', 'homme', 4700, 2),
('EMP07', 'Jennings', 'Leslie', 'femme', 6000, 3),
('EMP08', 'Thompson', 'Leslie', 'femme', 7850, 4),
('EMP09', 'Firrelli', 'Julie', 'femme', 3400, 3),
('EMP10', 'Patterson', 'Steve', 'homme', 2700, 4),
('EMP11', 'Tseng', 'Foon Yue', 'femme', 3500, 3),
('EMP12', 'Vanauf', 'George', 'homme', 30000, 3),
('EMP13', 'Bondur', 'Loui', 'femme', 20000, 2),
('EMP14', 'Hernandez', 'Gerard', 'homme', 2900, 1),
('EMP15', 'Castillo', 'Pamela', 'femme', 12900, 1),
('EMP16', 'Bott', 'Larry', 'homme', 5590, 2),
('EMP17', 'Jones', 'Barry', 'homme', 6090, 2),
('EMP18', 'Fixter', 'Andy', 'homme', 7080, 2),
('EMP19', 'Marsh', 'Peter', 'homme', 4090, 4),
('EMP20', 'King', 'Tom', 'homme', 3099, 3),
('EMP21', 'Nishi', 'Mami', 'femme', 2599, 3),
('EMP22', 'Kato', 'Yoshimi', 'femme', 3344, 3),
('EMP23', 'Gerard', 'Martin', 'homme', 2233, 2),
('EMP24', 'Labrune', 'Janine', 'homme', 3099, 4),
('EMP25', 'Bergulfsen', 'Jonas', 'femme', 2599, 3),
('EMP26', 'Nelson', 'Susan', 'femme', 2390, 4),
('EMP27', 'Gerard', 'Martin', 'homme', 5689, 2),
('EMP28', 'Nishi', 'Mami', 'femme', 2309, 3),
('EMP29', 'Freyre', 'Diego ', 'femme', 5460, 4),
('EMP30', 'Lee', 'Kwai', 'homme', 7600, 2);
--
-- Database: `dbproduct`
--
CREATE DATABASE IF NOT EXISTS `dbproduct` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbproduct`;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` char(15) DEFAULT NULL,
  `FAMILLE` char(30) DEFAULT NULL,
  `PRIX_ACHAT` float DEFAULT NULL,
  `PRIX_VENTE` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9900 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`ID`, `NOM`, `FAMILLE`, `PRIX_ACHAT`, `PRIX_VENTE`) VALUES
(9899, 'ana', 'tn', 111, 200),
(9898, 'bill', 'f1', 678, 899),
(64, 'prod5', 'famille6', 3900, 1),
(33, 'RED', 'fn', 700, 900),
(34, 'RED', 'fn', 100, 900);
--
-- Database: `dbproducts`
--
CREATE DATABASE IF NOT EXISTS `dbproducts` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbproducts`;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `code_produit` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) DEFAULT NULL,
  `prix_achat` double DEFAULT NULL,
  `prix_vente` double DEFAULT NULL,
  PRIMARY KEY (`code_produit`)
) ENGINE=MyISAM AUTO_INCREMENT=678 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`code_produit`, `libelle`, `prix_achat`, `prix_vente`) VALUES
(1, 'Miel Naturel', 140, 150),
(2, 'Huile d\'olives', 40, 55),
(3, 'Regime Bio', 1300, 1450),
(4, 'Cacahuète aromatisée', 2, 5),
(5, 'Amlo Agadir', 290, 350),
(6, 'Produit Italienne', 190, 230),
(7, 'laptop', 2000, 2000),
(8, 'windows', 9, 44),
(234, 'YTY', 90, 6),
(9, 'house', 55, 8);
--
-- Database: `dbproduits`
--
CREATE DATABASE IF NOT EXISTS `dbproduits` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbproduits`;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `numProd` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) DEFAULT NULL,
  `famille` varchar(40) DEFAULT NULL,
  `prixAchat` decimal(10,2) DEFAULT NULL,
  `prixVente` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`numProd`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`numProd`, `description`, `famille`, `prixAchat`, `prixVente`) VALUES
(42, NULL, NULL, '0.00', '0.00'),
(41, 'p4', 'Epicerie', '67.00', '8.00'),
(3, 'Cuisinière à gaz', 'Electromenager', '850.50', '1260.00'),
(4, 'Lave-vaisselle', 'Electromenager', '2460.80', '2800.00'),
(5, 'Sèche-linge', 'Electromenager', '350.50', '660.99'),
(6, 'Raisin', 'Fruit', '22.80', '29.70'),
(7, 'Cerises', 'Fruit', '30.99', '35.00'),
(8, 'Céleri branche', 'Fruit', '32.40', '35.70'),
(9, 'Pomme', 'Fruit', '15.50', '19.00'),
(10, 'Orange', 'Fruit', '10.80', '13.00'),
(11, 'Abricot', 'Fruit', '30.50', '33.00'),
(12, 'Tomates', 'Legumes', '7.50', '10.00'),
(13, 'Carottes', 'Legumes', '2.80', '4.00'),
(14, 'Pois', 'Legumes', '10.50', '13.00'),
(15, 'Sel', 'Epicerie', '5.50', '7.00'),
(16, 'Poivres', 'Epicerie', '6.50', '8.50'),
(17, 'Epices', 'Epicerie', '2.80', '4.00'),
(18, 'Vanille', 'Epicerie', '1.50', '3.00'),
(19, 'Huiles', 'Epicerie', '17.50', '20.00'),
(39, 'lait', 'Electromenager', '889.00', '567.00'),
(40, 'newProduct', 'Epicerie', '8.00', '99.00'),
(27, 'drink', 'Epicerie', '4.00', '122.00'),
(24, 'huit', 'Epicerie', '67.00', '99.00'),
(28, 'tostad', 'fruit', '65.88', '7865.88'),
(31, 'milk', 'drink', '65.88', '7865.88'),
(32, 'banan', 'Electromenager', '9.00', '89.00'),
(33, 'uyu', 'Electromenager', '3.00', '2.00'),
(34, 'tuna', 'Electromenager', '98.00', '2.00'),
(35, 'Yaghurt', 'Fruit', '67.00', '66.00'),
(43, NULL, NULL, '0.00', '0.00'),
(44, NULL, NULL, '0.00', '0.00'),
(45, NULL, NULL, '0.00', '0.00'),
(46, NULL, NULL, '0.00', '0.00'),
(47, NULL, NULL, '0.00', '0.00'),
(48, NULL, NULL, '0.00', '0.00'),
(49, NULL, NULL, '0.00', '0.00'),
(50, NULL, NULL, '0.00', '0.00');
--
-- Database: `hb-05-many-to-many`
--
CREATE DATABASE IF NOT EXISTS `hb-05-many-to-many` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hb-05-many-to-many`;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`title`),
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `title`, `instructor_id`) VALUES
(11, 'The Pinball Masterclass', 1);

-- --------------------------------------------------------

--
-- Table structure for table `course_student`
--

DROP TABLE IF EXISTS `course_student`;
CREATE TABLE IF NOT EXISTS `course_student` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`student_id`),
  KEY `FK_STUDENT_idx` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE IF NOT EXISTS `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`id`, `first_name`, `last_name`, `email`, `instructor_detail_id`) VALUES
(1, 'Madhu', 'Patel', 'madhu@luv2code.com', 1),
(2, 'Susan', 'Public', 'susan.public@luv2code.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `instructor_detail`
--

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE IF NOT EXISTS `instructor_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor_detail`
--

INSERT INTO `instructor_detail` (`id`, `youtube_channel`, `hobby`) VALUES
(1, 'http://www.youtube.com', 'Guitar'),
(2, 'http://www.youtube.com', 'Video Games');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(256) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COURSE_ID_idx` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `course_student`
--
ALTER TABLE `course_student`
  ADD CONSTRAINT `FK_COURSE_05` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
--
-- Database: `hb_student_tracker`
--
CREATE DATABASE IF NOT EXISTS `hb_student_tracker` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hb_student_tracker`;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Database: `mcd`
--
CREATE DATABASE IF NOT EXISTS `mcd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mcd`;
--
-- Database: `ticketing_system`
--
CREATE DATABASE IF NOT EXISTS `ticketing_system` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ticketing_system`;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `destination_id` int(50) NOT NULL,
  `booking_date` varchar(30) NOT NULL,
  `journey_date` varchar(30) NOT NULL,
  `train_id` int(30) NOT NULL,
  `seat_numbers` varchar(150) NOT NULL,
  `passenger_id` int(50) NOT NULL,
  `number_of_seat` int(5) NOT NULL,
  `payment_status` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `note` varchar(220) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `destination_id`, `booking_date`, `journey_date`, `train_id`, `seat_numbers`, `passenger_id`, `number_of_seat`, `payment_status`, `status`, `note`) VALUES
(1, 11, '06-10-2018', '06-10-2018', 7, '1,2', 12, 2, 'pending', 'success', 'note'),
(4, 11, '06-10-2018', '06-10-2018', 7, '3,4', 12, 2, 'pending', 'success', 'note'),
(5, 16, '06-10-2018', '06-10-2018', 2, '41,42,43', 12, 3, 'pending', 'success', 'note'),
(6, 13, '06-10-2018', '06-10-2018', 7, '57,58,59,60', 12, 4, 'pending', 'success', 'note'),
(7, 15, '06-10-2018', '06-10-2018', 2, '21,22,23,24', 12, 4, 'pending', 'success', 'note'),
(8, 14, '06-10-2018', '06-10-2018', 2, '1', 12, 1, 'pending', 'success', 'note'),
(9, 14, '06-10-2018', '06-10-2018', 2, '2', 12, 1, 'pending', 'success', 'note'),
(10, 14, '06-10-2018', '06-10-2018', 2, '2', 12, 1, 'pending', 'success', 'note'),
(11, 14, '06-10-2018', '06-10-2018', 2, '2', 12, 1, 'pending', 'success', 'note'),
(12, 14, '06-10-2018', '06-10-2018', 2, '2', 12, 1, 'pending', 'success', 'note'),
(13, 12, '06-10-2018', '06-10-2018', 7, '6,7', 12, 2, 'pending', 'success', 'note'),
(14, 12, '06-10-2018', '06-10-2018', 7, '8,9,10', 12, 3, 'pending', 'success', 'note'),
(15, 12, '06-10-2018', '06-10-2018', 7, '8,9,10', 12, 3, 'pending', 'success', 'note'),
(16, 12, '06-10-2018', '06-10-2018', 7, '8,9,10', 12, 3, 'pending', 'success', 'note'),
(17, 16, '08-10-2018', '08-10-2018', 2, '41,42,43', 12, 3, 'pending', 'success', 'note'),
(18, 16, '10-10-2018', '10-10-2018', 2, '41,42,43', 12, 3, 'pending', 'success', 'note'),
(19, 15, '11-10-2018', '11-10-2018', 2, '21,22', 12, 2, 'pending', 'success', 'note'),
(20, 14, '11-10-2018', '11-10-2018', 2, '1', 12, 1, 'pending', 'success', 'note'),
(21, 27, '16-10-2018', '16-10-2018', 10, '1,2', 12, 2, 'pending', 'success', 'note'),
(22, 27, '11-10-2018', '11-10-2018', 10, '1', 12, 1, 'pending', 'success', 'note'),
(23, 27, '11-10-2018', '11-10-2018', 10, '2', 12, 1, 'pending', 'success', 'note'),
(24, 30, '11-10-2018', '11-10-2018', 8, '9', 12, 1, 'pending', 'success', 'note');

-- --------------------------------------------------------

--
-- Table structure for table `destinations`
--

DROP TABLE IF EXISTS `destinations`;
CREATE TABLE IF NOT EXISTS `destinations` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `station_from` int(20) NOT NULL,
  `station_to` int(20) NOT NULL,
  `train_id` int(20) NOT NULL,
  `time` varchar(30) NOT NULL,
  `status` varchar(20) NOT NULL,
  `fare` varchar(5) NOT NULL,
  `last_activity` datetime NOT NULL,
  `last_modify_by` int(30) NOT NULL,
  `total_seat` int(5) NOT NULL,
  `seat_range` varchar(10) NOT NULL,
  `type` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `destinations`
--

INSERT INTO `destinations` (`id`, `station_from`, `station_to`, `train_id`, `time`, `status`, `fare`, `last_activity`, `last_modify_by`, `total_seat`, `seat_range`, `type`) VALUES
(11, 1, 2, 7, '40:30Am', 'active', '40', '2018-09-05 00:00:00', 0, 5, '1-5', 'up'),
(12, 1, 3, 7, '40:30Am', 'active', '240', '2018-09-05 00:00:00', 0, 50, '6-56', 'up'),
(13, 1, 4, 7, '40:30Am', 'active', '280', '2018-09-05 00:00:00', 0, 5, '57-61', 'up'),
(14, 1, 2, 2, '1:20AM', 'active', '40', '2018-09-05 00:00:00', 0, 20, '1-20', 'up'),
(15, 1, 3, 2, '1:20AM', 'active', '240', '2018-09-05 00:00:00', 0, 20, '21-40', 'up'),
(16, 1, 4, 2, '1:20AM', 'active', '280', '2018-09-05 00:00:00', 0, 10, '41-50', 'up'),
(17, 4, 1, 7, '2:50 AM', 'active', '240', '2018-09-05 00:00:00', 0, 20, '1-20', 'up'),
(18, 4, 3, 7, '2:50 AM', 'active', '40', '2018-09-05 00:00:00', 0, 50, '21-50', 'up'),
(23, 6, 4, 9, '10:5AM', 'active', '480', '2018-09-05 00:00:00', 0, 30, '21-50', 'up'),
(25, 6, 2, 9, '10:5AM', 'active', '350', '2018-09-05 00:00:00', 0, 20, '21-50', 'up'),
(27, 7, 1, 10, '10:5AM', 'active', '480', '2018-09-05 00:00:00', 0, 3, '1-3', 'up'),
(28, 7, 3, 10, '10:5AM', 'active', '350', '2018-09-05 00:00:00', 0, 4, '4-8', 'up'),
(29, 7, 4, 10, '10:5AM', 'active', '900', '2018-09-05 00:00:00', 0, 2, '9-10', 'up'),
(30, 7, 1, 8, '6AM', 'active', '480', '2018-09-05 00:00:00', 0, 2, '9-10', 'up');

-- --------------------------------------------------------

--
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
CREATE TABLE IF NOT EXISTS `stations` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(70) NOT NULL,
  `contact` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stations`
--

INSERT INTO `stations` (`id`, `name`, `address`, `contact`) VALUES
(1, 'Dhaka', 'Dhaka, Comlapur', '01733435951'),
(2, 'Dhaka Bimanbondor', 'Dhaka binmanbondor', '0202'),
(3, 'Jamalpur', 'Jamalpur railstation', '01733435957'),
(4, 'Islampur Bazar', 'Islampur , Jamalpur, Dhaka, Bangladesh', '01733'),
(6, 'Mymensingh', 'Islampur , Jamalpur, Dhaka, Bangladesh', '01733435951'),
(7, 'Mymensingh 2', 'Islampur , Jamalpur, Dhaka, Bangladesh', '01733435951');

-- --------------------------------------------------------

--
-- Table structure for table `trains`
--

DROP TABLE IF EXISTS `trains`;
CREATE TABLE IF NOT EXISTS `trains` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `total_seat` int(5) NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'intercity',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trains`
--

INSERT INTO `trains` (`id`, `code`, `name`, `total_seat`, `type`) VALUES
(2, 'B207', 'Bromoputra', 560, 'intercity'),
(3, 'j152', 'Jomuna', 650, 'intercity'),
(4, 'SNB-59', 'Sunar Bangla', 700, 'intercity'),
(8, '105', 'Bus 1', 10, 'F-Class'),
(9, '106', 'Demo Bus name', 42, 'S-Chair'),
(10, '108', 'Demo Bus name 2', 10, 'F-Class');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `address` varchar(200) NOT NULL,
  `password` varchar(150) NOT NULL,
  `rule` varchar(10) NOT NULL,
  `reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_activity` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `phone`, `address`, `password`, `rule`, `reg_date`, `last_activity`) VALUES
(6, 'Md Rukon Shekh', 'rukon@gmail.com', '253', 'dfsdsf', '123', 'admin', '2018-09-17 15:53:29', '2018-09-17 15:53:29'),
(7, 'Md Rukon', 'rukdon@gmail.com', '0184272596763', '', '', 'passenger', '2018-09-17 16:07:40', '2018-09-17 16:07:40'),
(8, 'Md Rukon', 'rukon@gmai.co', '0184279676399', '', '', 'passenger', '2018-09-17 16:09:44', '2018-09-17 16:09:44'),
(9, 'Md Rukon Shekh', 'rukon36@gmail.com', '02175', 'Dhaka,Bangladesh', '123', 'passenger', '2018-09-17 16:11:32', '2018-09-17 16:11:32'),
(10, 'Md Rukon Shekh', 'rukon.infdo@gmail.com', '8985', 'teste', '123', 'passenger', '2018-09-17 16:33:49', '2018-09-17 16:33:49'),
(11, 'Md Rukon', 'rukons@gmail.com', '02158', 'ad', '123', 'passenger', '2018-09-17 16:35:22', '2018-09-17 16:35:22'),
(12, 'Asad', 'asad@gmail.com', '01652', 'Asad Address', '123', 'passenger', '2018-09-17 16:38:28', '2018-09-17 16:38:28'),
(13, 'boss', 'mushfiqur.office@gmail.com', '01756179081', 'dhaka', '12345', 'passenger', '2018-10-05 19:26:29', '2018-10-05 19:26:29');
--
-- Database: `ticket_system`
--
CREATE DATABASE IF NOT EXISTS `ticket_system` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ticket_system`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `idADMIN` int(11) NOT NULL AUTO_INCREMENT,
  `uername` varchar(40) DEFAULT NULL,
  `pasword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idADMIN`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`idBus`, `matricule`, `name`, `total_seat`, `type`) VALUES
(8, 'BURMAT', 'NEW BUS', 89, 'TYPE A'),
(9, 'matr 89', 'bus TR', 777, 'type 56'),
(10, 'jhgfr89', 'FastBus', 65, 'class family');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `numcli` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(40) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`numcli`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`numcli`, `address`, `email`, `name`, `phone`) VALUES
(5, 'HKGH', 'jlkhjgjf@mail', 'yaseeenh', '6578565'),
(6, 'KJHGT', 'ao@lkjh', 'bill', '987654'),
(7, 'GFYG', 'jlhkgjf', 'yousf', '87654567'),
(8, 'reue8', 'hgfàjhgf', 'rashid', '6767'),
(9, 'Adr 78', 'kjh', 'mar', '056843');

-- --------------------------------------------------------

--
-- Table structure for table `destination`
--

DROP TABLE IF EXISTS `destination`;
CREATE TABLE IF NOT EXISTS `destination` (
  `idDest` int(11) NOT NULL AUTO_INCREMENT,
  `station_from` varchar(10) NOT NULL,
  `station_to` varchar(10) NOT NULL,
  `time` int(11) NOT NULL,
  `fare` double NOT NULL,
  `total_seat` int(5) NOT NULL,
  PRIMARY KEY (`idDest`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `destination`
--

INSERT INTO `destination` (`idDest`, `station_from`, `station_to`, `time`, `fare`, `total_seat`) VALUES
(16, 'st1', 'stB', 9, 78, 89),
(17, 'st1', 'stG', 6, 987, 777),
(18, 'stG', 'st-F', 12, 341, 65),
(19, 'stB', 'st1', 15, 87, 777);

-- --------------------------------------------------------

--
-- Table structure for table `destination_has_bus`
--

DROP TABLE IF EXISTS `destination_has_bus`;
CREATE TABLE IF NOT EXISTS `destination_has_bus` (
  `bus_idBus` int(10) NOT NULL,
  `destination_idDest` int(11) NOT NULL,
  PRIMARY KEY (`bus_idBus`,`destination_idDest`),
  KEY `fk_destination_has_bus_bus1_idx` (`bus_idBus`),
  KEY `fk_destination_has_bus_destination1_idx` (`destination_idDest`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `destination_has_bus`
--

INSERT INTO `destination_has_bus` (`bus_idBus`, `destination_idDest`) VALUES
(8, 16),
(9, 17),
(9, 19),
(10, 18);

-- --------------------------------------------------------

--
-- Table structure for table `destination_has_station`
--

DROP TABLE IF EXISTS `destination_has_station`;
CREATE TABLE IF NOT EXISTS `destination_has_station` (
  `station_idStation` int(30) NOT NULL,
  `destination_idDest` int(11) NOT NULL,
  PRIMARY KEY (`station_idStation`,`destination_idDest`),
  KEY `fk_destination_has_station_station1_idx` (`station_idStation`),
  KEY `fk_destination_has_station_destination1_idx` (`destination_idDest`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `destination_has_station`
--

INSERT INTO `destination_has_station` (`station_idStation`, `destination_idDest`) VALUES
(3, 16),
(3, 17),
(3, 19),
(4, 16),
(4, 19),
(5, 17),
(5, 18),
(6, 18);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `idReservation` int(11) NOT NULL AUTO_INCREMENT,
  `seat_numbers` int(11) NOT NULL,
  `number_of_seat` int(11) NOT NULL,
  `journey_date` int(11) NOT NULL,
  `booking_date` int(11) NOT NULL,
  `client_numcli` int(11) NOT NULL,
  `bus_idBus` int(10) NOT NULL,
  PRIMARY KEY (`idReservation`),
  KEY `fk_reservation_client1_idx` (`client_numcli`),
  KEY `fk_reservation_bus1_idx` (`bus_idBus`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`idReservation`, `seat_numbers`, `number_of_seat`, `journey_date`, `booking_date`, `client_numcli`, `bus_idBus`) VALUES
(1, 89, 1, 999, 10, 7, 8),
(2, 777, 1, 6, 10, 8, 9),
(3, 65, 1, 12, 10, 9, 10);

-- --------------------------------------------------------

--
-- Table structure for table `reservation_has_destination`
--

DROP TABLE IF EXISTS `reservation_has_destination`;
CREATE TABLE IF NOT EXISTS `reservation_has_destination` (
  `reservation_idReservation` int(11) NOT NULL,
  `destination_idDest` int(11) NOT NULL,
  PRIMARY KEY (`reservation_idReservation`,`destination_idDest`),
  KEY `fk_reservation_has_destination1_destination1_idx` (`destination_idDest`),
  KEY `fk_reservation_has_destination1_reservation1_idx` (`reservation_idReservation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation_has_destination`
--

INSERT INTO `reservation_has_destination` (`reservation_idReservation`, `destination_idDest`) VALUES
(2, 17),
(3, 18);

-- --------------------------------------------------------

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
CREATE TABLE IF NOT EXISTS `station` (
  `idStation` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(70) NOT NULL,
  `contact` varchar(20) NOT NULL,
  PRIMARY KEY (`idStation`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `station`
--

INSERT INTO `station` (`idStation`, `name`, `address`, `contact`) VALUES
(3, 'st1', 'hejghjz av 78', 'jhgehf@djfgh'),
(4, 'stB', 'pijihuig', 'jklhjg'),
(5, 'stG', 'stg tre 89', 'hgf@contact.com'),
(6, 'st-F', 'st_F 987', 'st_F@jhgf.coml');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `destination_has_bus`
--
ALTER TABLE `destination_has_bus`
  ADD CONSTRAINT `fk_destination_has_bus_bus1` FOREIGN KEY (`bus_idBus`) REFERENCES `bus` (`idBus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_destination_has_bus_destination1` FOREIGN KEY (`destination_idDest`) REFERENCES `destination` (`idDest`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `destination_has_station`
--
ALTER TABLE `destination_has_station`
  ADD CONSTRAINT `fk_destination_has_station_destination1` FOREIGN KEY (`destination_idDest`) REFERENCES `destination` (`idDest`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_destination_has_station_station1` FOREIGN KEY (`station_idStation`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

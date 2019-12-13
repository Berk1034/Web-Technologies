-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 13, 2019 at 02:21 PM
-- Server version: 8.0.15
-- PHP Version: 7.2.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffee-machine`
--

-- --------------------------------------------------------

--
-- Table structure for table `userorders`
--

CREATE TABLE `userorders` (
  `ID` int(11) NOT NULL,
  `CoffeeType` text COLLATE utf8mb4_general_ci NOT NULL,
  `UserProfile` text COLLATE utf8mb4_general_ci NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userorders`
--

INSERT INTO `userorders` (`ID`, `CoffeeType`, `UserProfile`, `Date`) VALUES
(3, '\nFlatWhite{sugar=\'false\', watertemperature=\'90\', coffeeamount=\'13\', watervolume=\'30\', coconutmilkvolume=\'50\'}', 'Name: Berk\nSurname: Oops\nAge: 1034\nCreationDate: Sat Dec 07 22:57:21 MSK 2019', '2019-12-07'),
(1, '\nAmericano{sugar=\'false\', watertemperature=\'90\', coffeeamount=\'15\', watervolume=\'30\', additionalwatervolume=\'30\'}', 'Name: Constantin\nSurname: Hitov\nAge: 19\nCreationDate: Sat Dec 07 22:27:33 MSK 2019', '2019-12-07'),
(2, '\nEspresso{sugar=\'false\', watertemperature=\'90\', coffeeamount=\'10\', watervolume=\'30\'}', 'Name: Constantin\nSurname: Hitov\nAge: 19\nCreationDate: Sat Dec 07 22:56:52 MSK 2019', '2019-12-07'),
(4, '\nLatte{sugar=\'false\', watertemperature=\'90\', coffeeamount=\'13\', watervolume=\'30\', whippedcreamvolume=\'100\'}', 'Name: Constantin\nSurname: Hitov\nAge: 19\nCreationDate: Sat Dec 07 22:58:00 MSK 2019', '2019-12-07'),
(6, '\nRomano{sugar=\'false\', watertemperature=\'90\', coffeeamount=\'16\', watervolume=\'30\', lemonjuicevolume=\'5\'}', 'Name: Gloria\nSurname: Boogue\nAge: 30\nCreationDate: Sat Dec 07 23:03:14 MSK 2019', '2019-12-07'),
(7, '\nCappuccino{sugar=\'false\', watertemperature=\'90\', coffeeamount=\'10\', watervolume=\'30\', milktemperature=\'65\', milkvolume=\'65\'}', 'Name: Gloria\nSurname: Boogue\nAge: 30\nCreationDate: Sat Dec 07 23:03:14 MSK 2019', '2019-12-07'),
(8, '\nLatte{sugar=\'false\', watertemperature=\'90\', coffeeamount=\'13\', watervolume=\'30\', whippedcreamvolume=\'100\'}', 'Name: Peepee\nSurname: Pooooo\nAge: 20\nCreationDate: Sat Dec 07 23:05:41 MSK 2019', '2019-12-07'),
(5, '\nRomano{sugar=\'false\', watertemperature=\'90\', coffeeamount=\'16\', watervolume=\'30\', lemonjuicevolume=\'5\'}', 'Name: Poppy\nSurname: Harlow\nAge: 18\nCreationDate: Sat Dec 07 23:01:44 MSK 2019', '2019-12-07');

-- --------------------------------------------------------

--
-- Table structure for table `userprofiles`
--

CREATE TABLE `userprofiles` (
  `Name` text COLLATE utf8mb4_general_ci NOT NULL,
  `Surname` text COLLATE utf8mb4_general_ci NOT NULL,
  `Age` int(11) NOT NULL,
  `CreationDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userprofiles`
--

INSERT INTO `userprofiles` (`Name`, `Surname`, `Age`, `CreationDate`) VALUES
('Berk', 'Oops', 1034, '2019-12-07'),
('Constantin', 'Hitov', 19, '2019-12-07'),
('Gloria', 'Boogue', 30, '2019-12-07'),
('Peepee', 'Pooooo', 20, '2019-12-07'),
('Poppy', 'Harlow', 18, '2019-12-07');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

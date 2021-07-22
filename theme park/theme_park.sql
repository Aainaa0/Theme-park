-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2020 at 01:25 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `theme park`
--

-- --------------------------------------------------------

--
-- Table structure for table `attraction`
--

CREATE TABLE `attraction` (
  `AttractionID` int(11) NOT NULL,
  `AttractionName` varchar(100) NOT NULL,
  `LocationX` int(11) NOT NULL,
  `LocationY` int(11) NOT NULL,
  `LocationZ` int(11) NOT NULL,
  `MinimumAge` int(11) NOT NULL,
  `MinimumHeight` int(11) NOT NULL,
  `MinimumWeight` int(11) NOT NULL,
  `Duration` int(11) NOT NULL,
  `Price` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attraction`
--

INSERT INTO `attraction` (`AttractionID`, `AttractionName`, `LocationX`, `LocationY`, `LocationZ`, `MinimumAge`, `MinimumHeight`, `MinimumWeight`, `Duration`, `Price`) VALUES
(1, '3D Cinema', -552, -911, 35, 12, 0, 0, 6, '15'),
(2, 'Boat Hire', 704, 803, 24, 0, 0, 100, 7, '18'),
(3, 'Bobsled Roller Coaster', 240, -299, 7, 18, 100, 200, 4, '26'),
(4, 'Bumper Cars', -174, -862, 12, 12, 100, 0, 11, '0'),
(5, 'Car Ride', 359, 970, 32, 12, 100, 0, 12, '8'),
(6, 'Chairlift', -201, -272, 16, 0, 0, 150, 10, '13'),
(7, 'Ferris Wheel', -820, -586, 35, 0, 0, 150, 9, '10'),
(8, 'Go Karts', -559, -212, 12, 12, 100, 0, 8, '11'),
(9, 'Gravitron', -318, -553, 6, 12, 100, 0, 4, '20'),
(10, 'Haunted House', 133, -779, 3, 12, 0, 0, 10, '6'),
(11, 'Hedge Maze', -572, -940, 30, 0, 0, 0, 8, '6'),
(12, 'Inverted Roller Coaster', -276, -184, 31, 18, 100, 200, 6, '26'),
(13, 'Log Flume', 575, 297, 27, 12, 0, 100, 6, '13'),
(14, 'Merry-Go-Round', 569, 762, 19, 0, 0, 150, 8, '5'),
(15, 'Mine Train Roller Coaster', 505, 164, 8, 18, 100, 200, 5, '28'),
(16, 'Miniature Railroad', 533, -358, 41, 0, 0, 0, 8, '14'),
(17, 'Monorail', -911, -143, 32, 0, 0, 0, 7, '13'),
(18, 'Motion Simulator', 836, -126, 6, 12, 0, 0, 7, '18'),
(19, 'Observation Tower', 162, 810, 21, 0, 0, 150, 8, '2'),
(20, 'Reverse Whoa Belly Roller Coaster', 955, -164, 16, 18, 100, 200, 7, '20'),
(21, 'River Rapids', -209, -210, 31, 0, 0, 0, 4, '12'),
(22, 'Scrambled Eggs', -636, 400, 11, 12, 100, 0, 7, '14'),
(23, 'Single-Rail Roller Coaster', -409, -378, 36, 18, 100, 200, 7, '20'),
(24, 'Space Rings', 251, 924, 23, 12, 100, 100, 11, '9'),
(25, 'Spiral Slide', 321, -876, 36, 0, 0, 150, 8, '4'),
(26, 'Stand-Up Steel Roller Coaster', -912, 560, 13, 18, 100, 200, 6, '29'),
(27, 'Steel Corkscrew Roller Coaster', 440, -924, 15, 18, 100, 200, 4, '21'),
(28, 'Steel Mini Roller Coaster', -103, 785, 35, 18, 100, 200, 5, '24'),
(29, 'Steel Roller Coaster', -237, 548, 4, 18, 100, 200, 7, '28'),
(30, 'Suspended Roller Coaster', 282, 591, 44, 18, 100, 200, 5, '21'),
(31, 'Suspended Single-Rail Roller Coaster', 531, -606, 29, 18, 100, 200, 3, '29'),
(32, 'Swinging Inverter Ship', -389, 127, 26, 12, 100, 150, 7, '14'),
(33, 'Swinging Ship', 836, 443, 20, 12, 100, 150, 4, '17'),
(34, 'Vertical Roller Coaster', -966, -512, 21, 18, 100, 200, 3, '27'),
(35, 'Water Slide', 303, -608, 9, 0, 0, 100, 7, '12'),
(36, 'Whoa Belly', 980, 218, 4, 12, 0, 0, 6, '17'),
(37, 'Wooden Crazy Rodent Roller Coaster', -732, -740, 28, 18, 100, 200, 7, '30'),
(38, 'Wooden Roller Coaster', 222, 164, 36, 18, 100, 200, 5, '29');

-- --------------------------------------------------------

--
-- Table structure for table `attractionattribute`
--

CREATE TABLE `attractionattribute` (
  `tableID` int(11) NOT NULL,
  `AttractionID` int(11) NOT NULL,
  `AttributeID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attractionattribute`
--

INSERT INTO `attractionattribute` (`tableID`, `AttractionID`, `AttributeID`) VALUES
(1, 1, 12),
(2, 1, 8),
(3, 1, 9),
(4, 1, 7),
(5, 2, 14),
(6, 2, 5),
(7, 2, 6),
(8, 2, 7),
(9, 3, 11),
(10, 3, 2),
(11, 3, 9),
(12, 3, 10),
(13, 4, 1),
(14, 4, 8),
(15, 4, 6),
(16, 4, 7),
(17, 5, 1),
(18, 5, 8),
(19, 5, 6),
(20, 5, 7),
(21, 6, 13),
(22, 6, 8),
(23, 6, 6),
(24, 6, 7),
(25, 7, 1),
(26, 7, 5),
(27, 7, 6),
(28, 7, 7),
(29, 8, 12),
(30, 8, 2),
(31, 8, 6),
(32, 8, 7),
(33, 9, 12),
(34, 9, 8),
(35, 9, 3),
(36, 9, 4),
(37, 10, 1),
(38, 10, 5),
(39, 10, 6),
(40, 10, 7),
(41, 11, 1),
(42, 11, 5),
(43, 11, 6),
(44, 11, 7),
(45, 12, 11),
(46, 12, 2),
(47, 12, 3),
(48, 12, 4),
(49, 13, 14),
(50, 13, 8),
(51, 13, 6),
(52, 13, 7),
(53, 14, 1),
(54, 14, 5),
(55, 14, 6),
(56, 14, 7),
(57, 15, 11),
(58, 15, 5),
(59, 15, 3),
(60, 15, 4),
(61, 16, 13),
(62, 16, 8),
(63, 16, 6),
(64, 16, 7),
(65, 17, 13),
(66, 17, 8),
(67, 17, 6),
(68, 17, 7),
(69, 18, 12),
(70, 18, 8),
(71, 18, 9),
(72, 18, 10),
(73, 19, 1),
(74, 19, 8),
(75, 19, 6),
(76, 19, 7),
(77, 20, 11),
(78, 20, 8),
(79, 20, 3),
(80, 20, 4),
(81, 21, 14),
(82, 21, 8),
(83, 21, 6),
(84, 21, 7),
(85, 22, 12),
(86, 22, 5),
(87, 22, 6),
(88, 22, 7),
(89, 23, 11),
(90, 23, 8),
(91, 23, 3),
(92, 23, 10),
(93, 24, 1),
(94, 24, 5),
(95, 24, 6),
(96, 24, 4),
(97, 25, 1),
(98, 25, 5),
(99, 25, 6),
(100, 25, 7),
(101, 26, 11),
(102, 26, 2),
(103, 26, 3),
(104, 26, 10),
(105, 27, 11),
(106, 27, 2),
(107, 27, 3),
(108, 27, 10),
(109, 28, 11),
(110, 28, 2),
(111, 28, 3),
(112, 28, 10),
(113, 29, 11),
(114, 29, 8),
(115, 29, 9),
(116, 29, 7),
(117, 30, 11),
(118, 30, 2),
(119, 30, 3),
(120, 30, 4),
(121, 31, 11),
(122, 31, 8),
(123, 31, 3),
(124, 31, 10),
(125, 32, 12),
(126, 32, 8),
(127, 32, 9),
(128, 32, 10),
(129, 33, 12),
(130, 33, 8),
(131, 33, 6),
(132, 33, 7),
(133, 34, 11),
(134, 34, 2),
(135, 34, 3),
(136, 34, 10),
(137, 35, 14),
(138, 35, 8),
(139, 35, 3),
(140, 35, 10),
(141, 36, 12),
(142, 36, 5),
(143, 36, 3),
(144, 36, 4),
(145, 37, 11),
(146, 37, 2),
(147, 37, 3),
(148, 37, 10),
(149, 38, 11),
(150, 38, 2),
(151, 38, 3),
(152, 38, 10);

-- --------------------------------------------------------

--
-- Table structure for table `attribute`
--

CREATE TABLE `attribute` (
  `AttributeID` int(11) NOT NULL,
  `Description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attribute`
--

INSERT INTO `attribute` (`AttributeID`, `Description`) VALUES
(1, 'Gentle Rides'),
(2, 'High excitement rating'),
(3, 'High intensity rating'),
(4, 'High nausea rating'),
(5, 'Low excitement rating'),
(6, 'Low intensity rating'),
(7, 'Low nausea rating'),
(8, 'Medium excitement rating'),
(9, 'Medium intensity rating'),
(10, 'Medium nausea rating'),
(11, 'Roller coasters'),
(12, 'Thrill Rides'),
(13, 'Transport Rides'),
(14, 'Water Rides');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(20) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `CustomerName` varchar(200) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Weight` int(11) NOT NULL,
  `Height` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `Username`, `Password`, `CustomerName`, `DateOfBirth`, `Gender`, `Weight`, `Height`) VALUES
(1, 'celoudnine', 'jojojo', 'Aainaa Nabilah', '1999-11-08', 'Female', 160, 55),
(2, 'jojo', 'jojojo', 'Kujo Jotaro', '1985-01-01', 'Male', 213, 120);

-- --------------------------------------------------------

--
-- Table structure for table `entryrecord`
--

CREATE TABLE `entryrecord` (
  `EntryRecordID` int(11) NOT NULL,
  `AttractionID` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `entryrecord`
--

INSERT INTO `entryrecord` (`EntryRecordID`, `AttractionID`, `CustomerID`) VALUES
(15, 4, 2),
(16, 5, 2),
(17, 6, 2),
(18, 7, 2),
(19, 8, 2),
(20, 9, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attraction`
--
ALTER TABLE `attraction`
  ADD PRIMARY KEY (`AttractionID`);

--
-- Indexes for table `attractionattribute`
--
ALTER TABLE `attractionattribute`
  ADD PRIMARY KEY (`tableID`),
  ADD KEY `AttractionID` (`AttractionID`),
  ADD KEY `AtttributeID` (`AttributeID`);

--
-- Indexes for table `attribute`
--
ALTER TABLE `attribute`
  ADD PRIMARY KEY (`AttributeID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `entryrecord`
--
ALTER TABLE `entryrecord`
  ADD PRIMARY KEY (`EntryRecordID`),
  ADD KEY `AttractionID` (`AttractionID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attraction`
--
ALTER TABLE `attraction`
  MODIFY `AttractionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `attractionattribute`
--
ALTER TABLE `attractionattribute`
  MODIFY `tableID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=153;

--
-- AUTO_INCREMENT for table `attribute`
--
ALTER TABLE `attribute`
  MODIFY `AttributeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `entryrecord`
--
ALTER TABLE `entryrecord`
  MODIFY `EntryRecordID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attractionattribute`
--
ALTER TABLE `attractionattribute`
  ADD CONSTRAINT `attractionattribute_ibfk_1` FOREIGN KEY (`AttractionID`) REFERENCES `attraction` (`AttractionID`),
  ADD CONSTRAINT `attractionattribute_ibfk_2` FOREIGN KEY (`AttributeID`) REFERENCES `attribute` (`AttributeID`);

--
-- Constraints for table `entryrecord`
--
ALTER TABLE `entryrecord`
  ADD CONSTRAINT `entryrecord_ibfk_1` FOREIGN KEY (`AttractionID`) REFERENCES `attraction` (`AttractionID`),
  ADD CONSTRAINT `entryrecord_ibfk_2` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

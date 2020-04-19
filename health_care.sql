-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2020 at 06:07 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 5.6.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `health_care`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `AppointmentID` int(10) NOT NULL,
  `AppointmentCode` varchar(20) NOT NULL,
  `DoctorName` varchar(50) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `PatientName` varchar(50) NOT NULL,
  `AppointmentDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`AppointmentID`, `AppointmentCode`, `DoctorName`, `PatientName`, `AppointmentDate`) VALUES
(101, '135', 'Dr.Naveen Fernando', 'Sunil Edirisinghe', '2020-04-08'),
(102, '136', 'Dr.Nirmal Silva', 'Dewaka Nirwan', '2020-04-30'),
(103, '137', 'Dr.Raveen Silva', 'Nirwan Sunil', '2020-04-14'),
(104, '138', 'Dr.Omal Weerasinghe', 'Neelaka Deuni', '2020-04-17'),
(105, '139', 'Dr.Devindi Ranasinghe', 'Harsha Dias', '2020-04-22'),
(106, '240', 'Dr.Savi Fernando', 'Nilika Edirisinghe', '2020-04-28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`AppointmentID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `AppointmentID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

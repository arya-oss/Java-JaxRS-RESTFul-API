-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2016 at 10:37 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `friends`
--

CREATE TABLE `friends` (
  `id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `rollno` int(7) NOT NULL,
  `company` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `friends`
--

INSERT INTO `friends` (`id`, `name`, `email`, `phone`, `rollno`, `company`) VALUES
(2, 'Abhishek Shah', 'abhishek931375@gmail.com', '9989698299', 137101, 'Oracle'),
(3, 'Adapa Lokesh', 'lokeshadapa1231@gmail.com', '9494849373', 137102, 'JP Morgan'),
(4, 'Akula Surya Devi Kumari', 'devisurya789@gmail.com', '9502100770', 137103, 'Temenos'),
(5, 'Aneesh Makala', 'makalaaneesh@yahoo.com', '8790695804', 137104, 'D.E. Shaw'),
(6, 'Anirudh Vijay', 'anirudhvijayiit@gmail.com', '8233908779', 137105, 'Oracle'),
(7, 'Arpita Saxena', 'arpita1995jaipur@gmail.com', '8142476587', 137107, 'DBS'),
(8, 'BS Sachin Govind', 'bssachingovind@gmail.com', '9866086895', 137108, 'Arcesium'),
(9, 'Prashant Bagdia', 'prbagdia@gmail.com', '9096711189', 137109, 'UHG');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `friends`
--
ALTER TABLE `friends`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `friends`
--
ALTER TABLE `friends`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

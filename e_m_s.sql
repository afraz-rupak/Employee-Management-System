-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2020 at 10:35 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e_m_s`
--

-- --------------------------------------------------------

--
-- Table structure for table `e_details`
--

CREATE TABLE `e_details` (
  `user_id` int(11) NOT NULL,
  `phone_number` text DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `adress` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `e_details`
--

INSERT INTO `e_details` (`user_id`, `phone_number`, `salary`, `adress`) VALUES
(1, '016********', 5000, '12/A,'),
(5, '016********', 5000, 'Dhanmondi');

-- --------------------------------------------------------

--
-- Table structure for table `e_list`
--

CREATE TABLE `e_list` (
  `id` int(11) NOT NULL,
  `name` text DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` text DEFAULT NULL,
  `title` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `e_list`
--

INSERT INTO `e_list` (`id`, `name`, `age`, `gender`, `title`) VALUES
(1, 'Afraz', 20, 'male', 'CoFounder'),
(5, 'Anuek', 20, 'Male', 'Cofounder');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `e_details`
--
ALTER TABLE `e_details`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `e_list`
--
ALTER TABLE `e_list`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `e_list`
--
ALTER TABLE `e_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `e_details`
--
ALTER TABLE `e_details`
  ADD CONSTRAINT `FK_e_user` FOREIGN KEY (`user_id`) REFERENCES `e_list` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

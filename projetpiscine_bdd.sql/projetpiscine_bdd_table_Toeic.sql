
-- --------------------------------------------------------

--
-- Table structure for table `Toeic`
--

DROP TABLE IF EXISTS `Toeic`;
CREATE TABLE `Toeic` (
  `NumTOEIC` int(11) NOT NULL,
  `LibelleTOEIC` varchar(50) NOT NULL,
  `Enseignant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Toeic`
--

INSERT INTO `Toeic` (`NumTOEIC`, `LibelleTOEIC`, `Enseignant`) VALUES
(1, 'TOEIC 1', 1),
(2, 'TOEIC 2', 1),
(3, 'TOEIC 3', 1),
(4, 'TOEIC 4', 1),
(5, 'TOEIC 5', 1);


-- --------------------------------------------------------

--
-- Table structure for table `Toeic`
--

DROP TABLE IF EXISTS `Toeic`;
CREATE TABLE `Toeic` (
  `NumTOEIC` int(11) NOT NULL,
  `LibelleTOEIC` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Toeic`
--

INSERT INTO `Toeic` (`NumTOEIC`, `LibelleTOEIC`) VALUES
(1, 'TOEIC 1'),
(2, 'TOEIC 2'),
(3, 'TOEIC 3'),
(4, 'TOEIC 4'),
(5, 'TOEIC 5');

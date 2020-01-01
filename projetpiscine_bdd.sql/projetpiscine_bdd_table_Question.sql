
-- --------------------------------------------------------

--
-- Table structure for table `Question`
--

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
  `NumPart` int(11) NOT NULL,
  `NumQuestion` int(11) NOT NULL,
  `NumTOEIC` int(11) NOT NULL,
  `CorrectionQuestion` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Question`
--

INSERT INTO `Question` (`NumPart`, `NumQuestion`, `NumTOEIC`, `CorrectionQuestion`) VALUES
(1, 1, 1, 'a'),
(1, 2, 1, 'b'),
(1, 3, 1, 'd'),
(1, 4, 1, 'b'),
(2, 5, 3, 'c');

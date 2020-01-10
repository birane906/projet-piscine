
-- --------------------------------------------------------

--
-- Table structure for table `Partie`
--

DROP TABLE IF EXISTS `Partie`;
CREATE TABLE `Partie` (
  `NumPart` int(11) NOT NULL,
  `LibellePart` varchar(50) NOT NULL,
  `NumTOEIC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Partie`
--

INSERT INTO `Partie` (`NumPart`, `LibellePart`, `NumTOEIC`) VALUES
(1, 'Part 1', 1),
(1, 'Part 1', 2),
(2, 'Part 2', 1),
(2, 'Part 2', 2),
(3, 'Part 3', 1),
(3, 'Part 3', 2),
(4, 'Part 4', 1),
(4, 'Part 4', 2),
(5, 'Part 5', 1),
(5, 'Part 5', 2),
(6, 'Part 6', 1),
(6, 'Part 6', 2);

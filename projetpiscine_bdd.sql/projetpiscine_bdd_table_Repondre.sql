
-- --------------------------------------------------------

--
-- Table structure for table `Repondre`
--

DROP TABLE IF EXISTS `Repondre`;
CREATE TABLE `Repondre` (
  `NumPart` int(11) NOT NULL,
  `NumQuestion` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `ReponseE` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Repondre`
--

INSERT INTO `Repondre` (`NumPart`, `NumQuestion`, `idUtilisateur`, `ReponseE`) VALUES
(1, 2, 20603020, 'a'),
(1, 2, 21325642, 'd'),
(1, 3, 21325642, 'c'),
(2, 5, 21325642, 'b');


-- --------------------------------------------------------

--
-- Table structure for table `Passer`
--

DROP TABLE IF EXISTS `Passer`;
CREATE TABLE `Passer` (
  `NumTOEIC` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Passer`
--

INSERT INTO `Passer` (`NumTOEIC`, `idUtilisateur`, `Date`) VALUES
(3, 21325642, '0000-00-00');

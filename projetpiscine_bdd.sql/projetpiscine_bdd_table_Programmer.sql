
-- --------------------------------------------------------

--
-- Table structure for table `Programmer`
--

DROP TABLE IF EXISTS `Programmer`;
CREATE TABLE `Programmer` (
  `Date` date NOT NULL,
  `AnneePromo` int(4) NOT NULL,
  `FiliereEtAnnee` varchar(50) NOT NULL,
  `NumTOEIC` int(11) NOT NULL,
  `Enseignant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

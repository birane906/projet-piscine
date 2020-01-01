
-- --------------------------------------------------------

--
-- Table structure for table `Notes`
--

DROP TABLE IF EXISTS `Notes`;
CREATE TABLE `Notes` (
  `NumPart` int(11) NOT NULL,
  `NumTOEIC` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `Notes` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Notes`
--

INSERT INTO `Notes` (`NumPart`, `NumTOEIC`, `idUtilisateur`, `Notes`, `Date`) VALUES
(1, 1, 21325642, 2, '2019-10-09'),
(1, 2, 21325642, 10, '2019-10-09'),
(1, 4, 21325642, 7, '2019-10-09'),
(1, 5, 21325642, 3, '2019-10-09'),
(2, 1, 21325642, 2, '2019-10-09'),
(3, 1, 21325642, 5, '2019-10-09'),
(4, 1, 21325642, 7, '2019-10-09'),
(5, 1, 21325642, 3, '2019-10-09'),
(6, 1, 21325642, 8, '2019-10-09');


-- --------------------------------------------------------

--
-- Table structure for table `Filiere`
--

DROP TABLE IF EXISTS `Filiere`;
CREATE TABLE `Filiere` (
  `FiliereEtAnnee` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Filiere`
--

INSERT INTO `Filiere` (`FiliereEtAnnee`) VALUES
('Enseignant'),
('IG 3'),
('IG 4'),
('IG 5'),
('MEA 3'),
('MEA 4'),
('MEA 5'),
('MI 3'),
('MI 4'),
('MI 5');

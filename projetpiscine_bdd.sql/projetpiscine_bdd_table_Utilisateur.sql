
-- --------------------------------------------------------

--
-- Table structure for table `Utilisateur`
--

DROP TABLE IF EXISTS `Utilisateur`;
CREATE TABLE `Utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `NomUtilisateur` varchar(50) NOT NULL,
  `PrenomUtilisateur` varchar(50) NOT NULL,
  `MailUtilisateur` varchar(50) NOT NULL,
  `MdpUtilisateur` varchar(50) NOT NULL,
  `AdminUtilisateur` tinyint(1) NOT NULL,
  `FiliereEtAnnee` varchar(50) NOT NULL,
  `AnneePromo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Utilisateur`
--

INSERT INTO `Utilisateur` (`idUtilisateur`, `NomUtilisateur`, `PrenomUtilisateur`, `MailUtilisateur`, `MdpUtilisateur`, `AdminUtilisateur`, `FiliereEtAnnee`, `AnneePromo`) VALUES
(20303020, 'Carmel', 'Julien', 'julien.carmel@etu.umontpellier.fr', 'ouqjf8', 0, 'MEA 4', 2018),
(20603020, 'Washington', 'Georges', 'georges.washington@etu.umontpellier.fr', 'lalalalalala34', 0, 'IG 3', 2019),
(21325642, 'Tanis', 'William', 'william.tanis@etu.umontpellier.fr', 'mia65', 0, 'MI 5', 2017),
(21603021, 'Pierrot', 'Damien', 'damien.pierrot@etu.umontpellier.fr', 'jdfdffr', 0, 'IG 5', 2016);

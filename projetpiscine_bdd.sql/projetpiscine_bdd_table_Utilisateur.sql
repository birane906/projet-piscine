
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
  `AnneePromo` int(11) NOT NULL,
  `nbToeicPasse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Utilisateur`
--

INSERT INTO `Utilisateur` (`idUtilisateur`, `NomUtilisateur`, `PrenomUtilisateur`, `MailUtilisateur`, `MdpUtilisateur`, `AdminUtilisateur`, `FiliereEtAnnee`, `AnneePromo`, `nbToeicPasse`) VALUES
(1, 'Seguin', 'Corinne', 'corinne.seguin@umontpellier.fr', 'prof1', 1, 'Enseignant', 1, 0),
(2, 'Billere', 'Sylvain', 'sylvain.billere@umontpellier.fr', 'prof2', 1, 'Enseignant', 1, 0),
(20303020, 'Carmel', 'Julien', 'julien.carmel@etu.umontpellier.fr', 'ouqjf8', 0, 'MEA 4', 2018, 0),
(20303040, 'Test', 'Paul', 'test.paul@etu.umontpellier.fr', 'mdp', 0, 'IG 3', 2018, 0),
(20303090, 'Dupond', 'Albert', 'dupond.alb@etu.umontpellier.fr', 'mdp', 0, 'IG 4', 2018, 0),
(20603020, 'Washington', 'Georges', 'georges.washington@etu.umontpellier.fr', 'lalalalalala34', 0, 'IG 3', 2019, 0),
(21325642, 'Tanis', 'William', 'william.tanis@etu.umontpellier.fr', 'mia65', 0, 'MI 5', 2017, 0),
(21603021, 'Pierrot', 'Damien', 'damien.pierrot@etu.umontpellier.fr', 'jdfdffr', 0, 'IG 5', 2016, 0);

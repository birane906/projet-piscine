
-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
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

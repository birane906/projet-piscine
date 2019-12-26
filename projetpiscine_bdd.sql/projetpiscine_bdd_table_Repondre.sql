
-- --------------------------------------------------------

--
-- Structure de la table `Repondre`
--

DROP TABLE IF EXISTS `Repondre`;
CREATE TABLE `Repondre` (
  `NumPart` int(11) NOT NULL,
  `NumQuestion` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `ReponseE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

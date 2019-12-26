
-- --------------------------------------------------------

--
-- Structure de la table `Passer`
--

DROP TABLE IF EXISTS `Passer`;
CREATE TABLE `Passer` (
  `NumTOEIC` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

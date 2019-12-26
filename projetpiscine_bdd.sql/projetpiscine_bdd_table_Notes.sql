
-- --------------------------------------------------------

--
-- Structure de la table `Notes`
--

DROP TABLE IF EXISTS `Notes`;
CREATE TABLE `Notes` (
  `NumPart` int(11) NOT NULL,
  `NumTOEIC` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `Notes` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

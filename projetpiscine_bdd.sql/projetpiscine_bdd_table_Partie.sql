
-- --------------------------------------------------------

--
-- Structure de la table `Partie`
--

DROP TABLE IF EXISTS `Partie`;
CREATE TABLE `Partie` (
  `NumPart` int(11) NOT NULL,
  `LibellePart` varchar(50) NOT NULL,
  `NumTOEIC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

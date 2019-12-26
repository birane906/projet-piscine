
-- --------------------------------------------------------

--
-- Structure de la table `Question`
--

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
  `NumPart` int(11) NOT NULL,
  `NumQuestion` int(11) NOT NULL,
  `NumTOEIC` int(11) NOT NULL,
  `CorrectionQuestion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

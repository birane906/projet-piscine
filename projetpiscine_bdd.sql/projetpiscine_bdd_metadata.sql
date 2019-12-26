
--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Filiere`
--
ALTER TABLE `Filiere`
  ADD PRIMARY KEY (`FiliereEtAnnee`);

--
-- Index pour la table `Notes`
--
ALTER TABLE `Notes`
  ADD PRIMARY KEY (`NumPart`,`NumTOEIC`,`idUtilisateur`),
  ADD KEY `Notes_TOEIC_FK` (`NumTOEIC`),
  ADD KEY `Notes_Utilisateur_FK` (`idUtilisateur`);

--
-- Index pour la table `Partie`
--
ALTER TABLE `Partie`
  ADD PRIMARY KEY (`NumPart`),
  ADD KEY `Partie_TOEIC_FK` (`NumTOEIC`);

--
-- Index pour la table `Passer`
--
ALTER TABLE `Passer`
  ADD PRIMARY KEY (`NumTOEIC`,`idUtilisateur`),
  ADD KEY `Passer_Utilisateur_FK` (`idUtilisateur`);

--
-- Index pour la table `Promotion`
--
ALTER TABLE `Promotion`
  ADD PRIMARY KEY (`AnneePromo`);

--
-- Index pour la table `Question`
--
ALTER TABLE `Question`
  ADD PRIMARY KEY (`NumPart`,`NumQuestion`,`NumTOEIC`),
  ADD KEY `Question_Toeic_FK` (`NumTOEIC`);

--
-- Index pour la table `Repondre`
--
ALTER TABLE `Repondre`
  ADD PRIMARY KEY (`NumPart`,`NumQuestion`,`idUtilisateur`),
  ADD KEY `Repondre_Utilisateur0_FK` (`idUtilisateur`);

--
-- Index pour la table `Toeic`
--
ALTER TABLE `Toeic`
  ADD PRIMARY KEY (`NumTOEIC`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`),
  ADD KEY `Utilisateur_Filiere_FK` (`FiliereEtAnnee`),
  ADD KEY `Utilisateur_Promotion_FK` (`AnneePromo`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Notes`
--
ALTER TABLE `Notes`
  ADD CONSTRAINT `Notes_Partie_FK` FOREIGN KEY (`NumPart`) REFERENCES `Partie` (`NumPart`),
  ADD CONSTRAINT `Notes_TOEIC_FK` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`),
  ADD CONSTRAINT `Notes_Utilisateur_FK` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `Partie`
--
ALTER TABLE `Partie`
  ADD CONSTRAINT `Partie_TOEIC_FK` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`);

--
-- Contraintes pour la table `Passer`
--
ALTER TABLE `Passer`
  ADD CONSTRAINT `Passer_TOEIC_FK` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`),
  ADD CONSTRAINT `Passer_Utilisateur_FK` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `Question`
--
ALTER TABLE `Question`
  ADD CONSTRAINT `Question_Partie_FK` FOREIGN KEY (`NumPart`) REFERENCES `Partie` (`NumPart`),
  ADD CONSTRAINT `Question_Toeic_FK` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`);

--
-- Contraintes pour la table `Repondre`
--
ALTER TABLE `Repondre`
  ADD CONSTRAINT `Repondre_Question_FK` FOREIGN KEY (`NumPart`,`NumQuestion`) REFERENCES `Question` (`NumPart`, `NumQuestion`),
  ADD CONSTRAINT `Repondre_Utilisateur0_FK` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD CONSTRAINT `Utilisateur_Filiere_FK` FOREIGN KEY (`FiliereEtAnnee`) REFERENCES `Filiere` (`FiliereEtAnnee`),
  ADD CONSTRAINT `Utilisateur_Promotion_FK` FOREIGN KEY (`AnneePromo`) REFERENCES `Promotion` (`AnneePromo`);


--
-- Métadonnées
--
USE `ad-phpmyadmin_configuration`;

--
-- Métadonnées pour la table Filiere
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la table Notes
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la table Partie
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la table Passer
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la table Promotion
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la table Question
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la table Repondre
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la table Toeic
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la table Utilisateur
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__column_info : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__column_info'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__table_uiprefs : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__table_uiprefs'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__tracking : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__tracking'

--
-- Métadonnées pour la base de données projetpiscine_bdd
--
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__bookmark : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__bookmark'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__relation : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__relation'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__savedsearches : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__savedsearches'
-- Erreur de lecture des données pour la table ad-phpmyadmin_configuration.pma__central_columns : #1142 - La commande 'SELECT' est interdite à l'utilisateur: '197173_tiffany'@'2a00:b6e0:1:210:1::1' sur la table 'pma__central_columns'

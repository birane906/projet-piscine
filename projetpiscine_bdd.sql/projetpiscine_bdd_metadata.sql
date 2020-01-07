
--
-- Indexes for dumped tables
--

--
-- Indexes for table `Filiere`
--
ALTER TABLE `Filiere`
  ADD PRIMARY KEY (`FiliereEtAnnee`);

--
-- Indexes for table `Notes`
--
ALTER TABLE `Notes`
  ADD PRIMARY KEY (`NumPart`,`NumTOEIC`,`idUtilisateur`),
  ADD KEY `Notes_TOEIC_FK` (`NumTOEIC`),
  ADD KEY `Notes_Utilisateur_FK` (`idUtilisateur`);

--
-- Indexes for table `Partie`
--
ALTER TABLE `Partie`
  ADD PRIMARY KEY (`NumPart`,`NumTOEIC`),
  ADD KEY `Partie_TOEIC_FK` (`NumTOEIC`);

--
-- Indexes for table `Passer`
--
ALTER TABLE `Passer`
  ADD PRIMARY KEY (`NumTOEIC`,`idUtilisateur`),
  ADD KEY `Passer_Utilisateur_FK` (`idUtilisateur`);

--
-- Indexes for table `Programmer`
--
ALTER TABLE `Programmer`
  ADD PRIMARY KEY (`Date`,`NumTOEIC`),
  ADD KEY `Annee_PROG` (`AnneePromo`),
  ADD KEY `Filiere_Prog` (`FiliereEtAnnee`),
  ADD KEY `Toeic_Prog` (`NumTOEIC`),
  ADD KEY `Enseignant_Prog` (`Enseignant`);

--
-- Indexes for table `Promotion`
--
ALTER TABLE `Promotion`
  ADD PRIMARY KEY (`AnneePromo`);

--
-- Indexes for table `Question`
--
ALTER TABLE `Question`
  ADD PRIMARY KEY (`NumPart`,`NumQuestion`,`NumTOEIC`),
  ADD KEY `Question_Toeic_FK` (`NumTOEIC`);

--
-- Indexes for table `Repondre`
--
ALTER TABLE `Repondre`
  ADD PRIMARY KEY (`NumPart`,`NumQuestion`,`idUtilisateur`),
  ADD KEY `Repondre_Utilisateur0_FK` (`idUtilisateur`);

--
-- Indexes for table `Toeic`
--
ALTER TABLE `Toeic`
  ADD PRIMARY KEY (`NumTOEIC`),
  ADD KEY `Enseignant_Toeic` (`Enseignant`);

--
-- Indexes for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`),
  ADD KEY `Utilisateur_Filiere_FK` (`FiliereEtAnnee`),
  ADD KEY `Utilisateur_Promotion_FK` (`AnneePromo`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Notes`
--
ALTER TABLE `Notes`
  ADD CONSTRAINT `Notes_Partie_FK` FOREIGN KEY (`NumPart`) REFERENCES `Partie` (`NumPart`),
  ADD CONSTRAINT `Notes_TOEIC_FK` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`),
  ADD CONSTRAINT `Notes_Utilisateur_FK` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`);

--
-- Constraints for table `Partie`
--
ALTER TABLE `Partie`
  ADD CONSTRAINT `Partie_TOEIC_FK` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`);

--
-- Constraints for table `Passer`
--
ALTER TABLE `Passer`
  ADD CONSTRAINT `Passer_TOEIC_FK` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`),
  ADD CONSTRAINT `Passer_Utilisateur_FK` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`);

--
-- Constraints for table `Programmer`
--
ALTER TABLE `Programmer`
  ADD CONSTRAINT `Annee_PROG` FOREIGN KEY (`AnneePromo`) REFERENCES `Promotion` (`AnneePromo`),
  ADD CONSTRAINT `Enseignant_Prog` FOREIGN KEY (`Enseignant`) REFERENCES `Utilisateur` (`idUtilisateur`),
  ADD CONSTRAINT `Filiere_Prog` FOREIGN KEY (`FiliereEtAnnee`) REFERENCES `Filiere` (`FiliereEtAnnee`),
  ADD CONSTRAINT `Toeic_Prog` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`);

--
-- Constraints for table `Question`
--
ALTER TABLE `Question`
  ADD CONSTRAINT `Question_Partie_FK` FOREIGN KEY (`NumPart`) REFERENCES `Partie` (`NumPart`),
  ADD CONSTRAINT `Question_Toeic_FK` FOREIGN KEY (`NumTOEIC`) REFERENCES `Toeic` (`NumTOEIC`);

--
-- Constraints for table `Repondre`
--
ALTER TABLE `Repondre`
  ADD CONSTRAINT `Repondre_Question_FK` FOREIGN KEY (`NumPart`,`NumQuestion`) REFERENCES `Question` (`NumPart`, `NumQuestion`),
  ADD CONSTRAINT `Repondre_Utilisateur0_FK` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`);

--
-- Constraints for table `Toeic`
--
ALTER TABLE `Toeic`
  ADD CONSTRAINT `Enseignant_Toeic` FOREIGN KEY (`Enseignant`) REFERENCES `Utilisateur` (`idUtilisateur`);

--
-- Constraints for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD CONSTRAINT `Utilisateur_Filiere_FK` FOREIGN KEY (`FiliereEtAnnee`) REFERENCES `Filiere` (`FiliereEtAnnee`),
  ADD CONSTRAINT `Utilisateur_Promotion_FK` FOREIGN KEY (`AnneePromo`) REFERENCES `Promotion` (`AnneePromo`);


--
-- Metadata
--
USE `ad-phpmyadmin_configuration`;

--
-- Metadata for table Filiere
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Notes
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Partie
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Passer
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Programmer
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Promotion
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Question
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Repondre
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Toeic
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for table Utilisateur
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__column_info: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__column_info'
-- Error reading data for table ad-phpmyadmin_configuration.pma__table_uiprefs: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__table_uiprefs'
-- Error reading data for table ad-phpmyadmin_configuration.pma__tracking: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__tracking'

--
-- Metadata for database projetpiscine_bdd
--
-- Error reading data for table ad-phpmyadmin_configuration.pma__bookmark: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__bookmark'
-- Error reading data for table ad-phpmyadmin_configuration.pma__relation: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__relation'
-- Error reading data for table ad-phpmyadmin_configuration.pma__savedsearches: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__savedsearches'
-- Error reading data for table ad-phpmyadmin_configuration.pma__central_columns: #1142 - SELECT command denied to user '197173_tiffany'@'2a00:b6e0:1:210:1::1' for table 'pma__central_columns'

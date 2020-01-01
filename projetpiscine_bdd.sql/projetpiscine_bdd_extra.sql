
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
  ADD PRIMARY KEY (`NumTOEIC`);

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
-- Constraints for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD CONSTRAINT `Utilisateur_Filiere_FK` FOREIGN KEY (`FiliereEtAnnee`) REFERENCES `Filiere` (`FiliereEtAnnee`),
  ADD CONSTRAINT `Utilisateur_Promotion_FK` FOREIGN KEY (`AnneePromo`) REFERENCES `Promotion` (`AnneePromo`);

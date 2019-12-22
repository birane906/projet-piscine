------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: TOEIC
------------------------------------------------------------
CREATE TABLE public.TOEIC(
	NumTOEIC       INT  NOT NULL ,
	LibelleTOEIC   VARCHAR (50) NOT NULL  ,
	CONSTRAINT TOEIC_PK PRIMARY KEY (NumTOEIC)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Filiere
------------------------------------------------------------
CREATE TABLE public.Filiere(
	FiliereEtAnnee   VARCHAR (50) NOT NULL  ,
	CONSTRAINT Filiere_PK PRIMARY KEY (FiliereEtAnnee)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Utilisateur
------------------------------------------------------------
CREATE TABLE public.Utilisateur(
	NumUtilisateur     INT  NOT NULL ,
	MailUtilisateur    VARCHAR (50) NOT NULL ,
	MdpUtilisateur     VARCHAR (50) NOT NULL ,
	AdminUtilisateur   BOOL  NOT NULL ,
	FiliereEtAnnee     VARCHAR (50) NOT NULL  ,
	CONSTRAINT Utilisateur_PK PRIMARY KEY (NumUtilisateur)

	,CONSTRAINT Utilisateur_Filiere_FK FOREIGN KEY (FiliereEtAnnee) REFERENCES public.Filiere(FiliereEtAnnee)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Promotion
------------------------------------------------------------
CREATE TABLE public.Promotion(
	AnneePromo   INT  NOT NULL  ,
	CONSTRAINT Promotion_PK PRIMARY KEY (AnneePromo)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Partie
------------------------------------------------------------
CREATE TABLE public.Partie(
	NumPart       INT  NOT NULL ,
	LibellePart   VARCHAR (50) NOT NULL ,
	NumTOEIC      INT  NOT NULL  ,
	CONSTRAINT Partie_PK PRIMARY KEY (NumPart)

	,CONSTRAINT Partie_TOEIC_FK FOREIGN KEY (NumTOEIC) REFERENCES public.TOEIC(NumTOEIC)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Question
------------------------------------------------------------
CREATE TABLE public.Question(
	NumPart              INT  NOT NULL ,
	NumQuestion          INT  NOT NULL ,
	CorrectionQuestion   INT  NOT NULL  ,
	CONSTRAINT Question_PK PRIMARY KEY (NumPart,NumQuestion)

	,CONSTRAINT Question_Partie_FK FOREIGN KEY (NumPart) REFERENCES public.Partie(NumPart)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Passer
------------------------------------------------------------
CREATE TABLE public.Passer(
	NumTOEIC         INT  NOT NULL ,
	NumUtilisateur   INT  NOT NULL ,
	Date             DATE  NOT NULL  ,
	CONSTRAINT Passer_PK PRIMARY KEY (NumTOEIC,NumUtilisateur)

	,CONSTRAINT Passer_TOEIC_FK FOREIGN KEY (NumTOEIC) REFERENCES public.TOEIC(NumTOEIC)
	,CONSTRAINT Passer_Utilisateur0_FK FOREIGN KEY (NumUtilisateur) REFERENCES public.Utilisateur(NumUtilisateur)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: De l'annee
------------------------------------------------------------
CREATE TABLE public.De_l_annee(
	AnneePromo       INT  NOT NULL ,
	FiliereEtAnnee   VARCHAR (50) NOT NULL  ,
	CONSTRAINT De_l_annee_PK PRIMARY KEY (AnneePromo,FiliereEtAnnee)

	,CONSTRAINT De_l_annee_Promotion_FK FOREIGN KEY (AnneePromo) REFERENCES public.Promotion(AnneePromo)
	,CONSTRAINT De_l_annee_Filiere0_FK FOREIGN KEY (FiliereEtAnnee) REFERENCES public.Filiere(FiliereEtAnnee)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Repondre
------------------------------------------------------------
CREATE TABLE public.Repondre(
	NumPart          INT  NOT NULL ,
	NumQuestion      INT  NOT NULL ,
	NumUtilisateur   INT  NOT NULL ,
	ReponseE         INT  NOT NULL  ,
	CONSTRAINT Repondre_PK PRIMARY KEY (NumPart,NumQuestion,NumUtilisateur)

	,CONSTRAINT Repondre_Question_FK FOREIGN KEY (NumPart,NumQuestion) REFERENCES public.Question(NumPart,NumQuestion)
	,CONSTRAINT Repondre_Utilisateur0_FK FOREIGN KEY (NumUtilisateur) REFERENCES public.Utilisateur(NumUtilisateur)
)WITHOUT OIDS;





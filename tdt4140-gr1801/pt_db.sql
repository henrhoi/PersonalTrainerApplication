drop table if exists ExerciseInStrength;
drop table if exists ClientWeight;
drop table if exists ClientFat;
drop table if exists Exercise;
drop table if exists Strength;
drop table if exists Endurance;
drop table if exists Nutrition;
drop table if exists Klient;
drop table if exists PT;


INSERT INTO PT(PT_ID, Navn, Email, Birthday, Phonenr) VALUES ("henrhoi","Henrik Høiness", "henrik.hoiness@online.no", "1997-08-14", "48039233");

CREATE TABLE PT(
	PT_ID		VARCHAR(20) NOT NULL  PRIMARY KEY, -- username
    Passwrd	VARCHAR(256) NOT NULL,
    Navn		VARCHAR(40),
    Email		VARCHAR(30),
    Birthday	CHAR(10),
    Phonenr	VARCHAR(12) -- hvor mange siffer (USA?)
);



CREATE TABLE Klient(
	ClientID		INTEGER NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    Navn			VARCHAR(40),
    Height		 	INTEGER,
    PT_ID			VARCHAR(20) NOT NULL,
    
    FOREIGN KEY (PT_ID) REFERENCES PT(PT_ID));




CREATE TABLE Nutrition(
	NutritionID	INTEGER NOT NULL PRIMARY KEY auto_increment,
    Dato 			CHAR(10) NOT NULL,
    Calories		INTEGER DEFAULT 0,
    Fat				INTEGER DEFAULT 0,
    Carbs			INTEGER DEFAULT 0,    
	Protein			INTEGER DEFAULT 0,
    ClientID		INTEGER NOT NULL,
    
    FOREIGN KEY (ClientID) REFERENCES Klient(ClientID)
);



CREATE TABLE Exercise(
	ExerciseID	INTEGER NOT NULL	 primary key KEY AUTO_INCREMENT,
	Navn		VARCHAR(30),
    Reps		VARCHAR(30), -- 15-10-..-5
    Weight		INTEGER,
    Sets 		INTEGER
);



CREATE TABLE Strength( -- TRAINING-SUBKLASSE
	StrengthID	INTEGER NOT NULL	 primary key KEY AUTO_INCREMENT,
	Dato 			CHAR(10),
    Duration		INTEGER,
    ClientID		INTEGER NOT NULL,
    
	FOREIGN KEY(ClientID) REFERENCES Klient(ClientID)
    
);


CREATE TABLE ExerciseInStrength(
	ExerciseID INTEGER NOT NULL,
    StrengthID INTEGER NOT NULL,
    
    primary key (ExerciseID, StrengthID),
    foreign key (ExerciseID) REFERENCES Exercise(ExerciseID),
    foreign key (StrengthID) REFERENCES Strength(StrengthID)
    );
    
    
CREATE TABLE Endurance( -- ENDURANCE-SUBKLASSE
	EnduranceID		INTEGER NOT NULL auto_increment,
	Dato 					CHAR(10),
    Duration				INTEGER, -- in minutes
    Distance 				DOUBLE,  -- in km?
    CaloriesBurned	INTEGER, 
    ClientID				INTEGER NOT NULL,
    
    PRIMARY KEY (EnduranceID),
	FOREIGN KEY(ClientID) REFERENCES Klient(ClientID)
    
);


CREATE TABLE ClientWeight(
	ClientID	INTEGER NOT NULL,
    Weight		INTEGER,
    Dato 		CHAR(10) NOT NULL,  -- "2017-06-15"
    
    
PRIMARY KEY (ClientID, Dato),
FOREIGN KEY(ClientID) REFERENCES Klient(ClientID));


CREATE TABLE ClientFat(
	ClientID	INTEGER NOT NULL,
    Fat		INTEGER,
    Dato 		CHAR(10) NOT NULL,  -- "2017-06-15"
    
    
PRIMARY KEY (ClientID, Dato),
FOREIGN KEY(ClientID) REFERENCES Klient(ClientID));



   
   

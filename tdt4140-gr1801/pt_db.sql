drop table if exists ExerciseInStrength;
drop table if exists ClientWeight;
drop table if exists ClientFat;
drop table if exists Exercise;
drop table if exists Strength;
drop table if exists Endurance;
drop table if exists Nutrition;
drop table if exists Klient;
drop table if exists PT;


CREATE TABLE PT(
	PT_ID		VARCHAR(20) NOT NULL  PRIMARY KEY, -- username
    Passwrd	VARCHAR(256) NOT NULL,
    Navn		VARCHAR(40),
    Email		VARCHAR(30),
    Birthday	VARCHAR(13),
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
    Dato 			VARCHAR(13) NOT NULL,
    Calories		INTEGER DEFAULT 0,
    Fat				INTEGER DEFAULT 0,
    Carbs			INTEGER DEFAULT 0,    
	Protein			INTEGER DEFAULT 0,
    ClientID		INTEGER NOT NULL,
    
    FOREIGN KEY (ClientID) REFERENCES Klient(ClientID)
);


CREATE TABLE Strength( -- TRAINING-SUBKLASSE
	StrengthID	INTEGER NOT NULL	 primary key KEY AUTO_INCREMENT,
	Dato 			VARCHAR(13),
    Duration		INTEGER,
    ClientID		INTEGER NOT NULL,
    
	FOREIGN KEY(ClientID) REFERENCES Klient(ClientID)
    
);


CREATE TABLE Exercise(
	ExerciseID	INTEGER NOT NULL	 primary key KEY AUTO_INCREMENT,
	Navn		VARCHAR(30),
    Weight		INTEGER,
	Sets 		INTEGER,
    Reps		VARCHAR(30), -- 15-10-..-5
	StrengthID	INTEGER NOT NULL,
    foreign key (StrengthID) REFERENCES Strength(StrengthID)
);


    
    
CREATE TABLE Endurance( -- ENDURANCE-SUBKLASSE
	EnduranceID		INTEGER NOT NULL auto_increment,
	Dato 					VARCHAR(13),
    Duration				INTEGER, -- in minutes
	ClientID				INTEGER NOT NULL,
    Distance 				DOUBLE,  -- in km?
    CaloriesBurned	INTEGER, 
    
    PRIMARY KEY (EnduranceID),
	FOREIGN KEY(ClientID) REFERENCES Klient(ClientID)
    
);


CREATE TABLE ClientWeight(
	ClientID	INTEGER NOT NULL,
	Dato 		VARCHAR(13) NOT NULL,  -- "2017-06-15"
    Weight		INTEGER,
    Fat			INTEGER,

    
    
PRIMARY KEY (ClientID, Dato),
FOREIGN KEY(ClientID) REFERENCES Klient(ClientID));



   
   

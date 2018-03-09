

INSERT INTO PT(PT_ID, Passwrd, Navn, Email, Birthday, Phonenr) VALUES 
("henrhoi", "b561643d05ba522ab73c2e53a4d05fba88a8abeceaa19c2a12c934ddbd6bdaa9", "Henrik Høiness", "henrik.hoiness@online.no", "1997-08-14", "48039233"), -- pw: puerbest
("zyzz", "73d90d4a6af83af0419d430c770445db0167048b818454afc7e902d21279c3e8", "Kristoffer Gjerde", "zyzz.rip@hotmail.com", "1990-01-01", "34184500"), -- pw: stavangererbest
("axeloh", "9102547e3ff3c379c0742e2faa8c3ed11c2b1aeffec1be621310ba84c53cf885", "Axel Harstad", "axel.ronaldomessi@hotmail.com", "1996-06-06", "46886146"), -- pw: axelerkul321
("chestbrah", "3d9c5ea90f1e7080af1cdc2e0dcc2298b2e3788550c3709d0c5324c4b3c71d99", "William Kvaale", "williamandaslaug@mail.no", "1983-03-12", "77889900"), -- pw: mcboyerud69
("kristogj", "8595d3d0b452adfe119c0f2dddcf775f9abd9a48713a9e5d8ead32e1efc357a9", "TEST Kvaale", "williamandasug@mail.no", "1983-03-12", "77889920"); -- pw: fortnite123

SELECT * FROM PT;
SELECT * FROM Klient;

DELETE FROM PT WHERE PT_ID="vildera";

INSERT INTO KLIENT(Navn, Height, PT_ID) VALUES
("Toralf Frich", 203, "axeloh"),
("Emilie Dahl", 149, "zyzz"),
("Erling Kjevik", 155, "henrhoi"),
("Eirik Dahlen", 192, "chestbrah"),
("Martin Johansen", 189, "henrhoi");




INSERT INTO NUTRITION(Dato, Calories, Fat, Carbs, Protein, ClientID) VALUES
("2018-01-15", 4000, 400, 300, 50, 1),
("2018-01-09", 2500, 250, 100, 20, 2),
("2018-01-28", 3000, 400, 250, 45, 3),
("2018-02-01", 8550, 540, 830, 70, 4),
("2018-02-03", 1350, 210, 270, 38, 1);


INSERT INTO STRENGTH(Dato, Duration, ClientID) VALUES
("2018-01-13", 90, 1),
("2018-01-05", 60, 2),
("2018-01-23", 100, 3),
("2018-02-01", 120, 4),
("2018-02-02", 70, 1),
("2018-02-03", 90, 1);


INSERT INTO EXERCISE(Navn, Weight, Sets, Reps, StrengthID) VALUES
("Benchpress", 80, 5, "12-12-10-8-6", 1),
("Bicepcurls", 20, 3, "25-20-18", 1),
("Pushdown", 60, 4, "12-11-10-12", 1),
("Squats", 120, 3, "15-12-10", 2),
("Benchpress", 70, 5, "13-11-10-8-6", 3),
("Deadlift", 150, 5, "5-5-5-5-4", 3),
("Shoulderpress", 30, 5, "18-15-12-8-6", 4),
("Shrugs", 40, 3, "20-18-8", 5),
("Bicepcurls", 30, 5, "12-12-10-8-6", 5),
("Benchpress", 80, 3, "12-12-10", 6);


INSERT INTO ENDURANCE(Dato, Duration, ClientID, Distance, CaloriesBurned) VALUES
("2018-01-13", 90, 1, 10.5, 300),
("2018-01-01", 60, 2, 5.8, 250),
("2018-01-10", 40, 3, 4.0, 200),
("2018-01-26", 120, 1, 21.5, 500);


INSERT INTO CLIENTWEIGHT(ClientID, Dato, Weight, Fat) VALUES
(1, "2018-01-05", 95, 8),
(1, "2018-01-10", 93, 8),
(1, "2018-01-20", 90, 8),
(1, "2018-02-03", 88, 7),
(2, "2018-01-18", 55, 7),
(2, "2018-01-25", 53, 7),
(3, "2018-01-05", 85, 12),
(3, "2018-01-15", 83, 11),
(4, "2018-01-05", 70, 10);




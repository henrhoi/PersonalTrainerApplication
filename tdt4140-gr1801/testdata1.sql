

INSERT INTO PT(PT_ID, Passwrd, Navn, Email, Birthday, Phonenr, Salt) VALUES 
("henrhoi", "266facb09e7420eedef02c2daaf8358590e42d77b98b306a2364babe0077b263", "Henrik Høiness", "henrik.hoiness@online.no", "1997-08-14", "48039233","nAG3DDl64RJoVyqDEc96rL6avI4="), -- pw: puerbest
("zyzz", "246bee666a26beaf6d5b27eac09fe34e23b424eb6008734e33a8cffc3e2c1b04", "Kristoffer Gjerde", "zyzz.rip@hotmail.com", "1990-01-01", "34184500","5dIu85YFJvwXNf6aMJh47VDpC00="), -- pw: stavangererbest
("axeloh", "41f46b90206996ccc0e15368cb1d156491e580fe43cfd76496da484fc05e520e", "Axel Harstad", "axel.ronaldomessi@hotmail.com", "1996-06-06", "46886146","uJVL70z0QYnfBoWQZMzLHH40H+Q="), -- pw: axelerkul321
("chestbrah", "eaef65e67b1336b570d11efb84688ddffe3ee4effe1e05314f1876c0a177793a", "William Kvaale", "williamandaslaug@mail.no", "1983-03-12", "77889900","YctYzo106LBo+OWal/57khuT7E0="), -- pw: mcboyerud69
("kristogj", "2e088ade9e95820d4d1dd6027b40a3993183bdd2699f3189620614ddcf2c3819", "TEST Kvaale", "williamandasug@mail.no", "1983-03-12", "77889920","mLTYw6QIg7AeCw4vA2uN+Fxcm3g="); -- pw: fortnite123


INSERT INTO KLIENT(Navn, Height, PT_ID) VALUES
("Toralf Frich", 203, "axeloh"),
("Emilie Dahl", 149, "zyzz"),
("Erling Kjevik", 155, "henrhoi"),
("Eirik Dahlen", 192, "chestbrah"),
("Martin Johansen", 189, "kristogj"),
("Sebastian Øveraas", 187, "henrhoi");





INSERT INTO NUTRITION(Dato, Calories, Fat, Carbs, Protein, ClientID) VALUES
("2018-01-15", 4000, 400, 300, 50, 1),
("2018-01-09", 2500, 250, 100, 20, 2),
("2018-01-28", 3000, 400, 250, 45, 3),
("2018-02-01", 8550, 540, 830, 70, 4),
("2018-02-03", 1350, 210, 270, 38, 1);


INSERT INTO STRENGTH(Dato, Duration, ClientID) VALUES
("2018-01-13", 90, 5),
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




INSERT INTO PT(PT_ID, Passwrd, Navn, Email, Birthday, Phonenr) VALUES 
("henrhoi", "b561643d05ba522ab73c2e53a4d05fba88a8abeceaa19c2a12c934ddbd6bdaa9", "Henrik Høiness", "henrik.hoiness@online.no", "1997-08-14", "48039233"), -- pw: puerbest
("zyzz", "73d90d4a6af83af0419d430c770445db0167048b818454afc7e902d21279c3e8", "Kristoffer Gjerde", "zyzz.rip@hotmail.com", "1990-01-01", "34184500"), -- pw: stavangererbest
("axeloh", "9102547e3ff3c379c0742e2faa8c3ed11c2b1aeffec1be621310ba84c53cf885", "Axel Harstad", "axel.ronaldomessi@hotmail.com", "1996-06-06", "46886146"), -- pw: axelerkul321
("chestbrah", "3d9c5ea90f1e7080af1cdc2e0dcc2298b2e3788550c3709d0c5324c4b3c71d99", "William Kvaale", "williamandaslaug@mail.no", "1983-03-12", "77889900"), -- pw: mcboyerud69
("kristogj", "8595d3d0b452adfe119c0f2dddcf775f9abd9a48713a9e5d8ead32e1efc357a9", "TEST Kvaale", "williamandasug@mail.no", "1983-03-12", "77889920"), -- pw: fortnite123
("emdahl", "be7cfec9905f5050497215546dcc86fa235adf3651e271d007736b7ba29e295d", "Emilie Dahl", "emiliemdahl@mail.no", "1993-08-04", "48212043"); -- pw: doglover93



INSERT INTO KLIENT(Navn, Height, PT_ID) VALUES 
("Emilie Margrethe Hyrum Dahl", 162.5, "zyzz"),
("Erling Kjevik", 155, "henrhoi"),
("Eirik Dahlen", 192, "chestbrah"),
("Sebastian Overaas", 186, "emdahl"),
("Vilde Arntzen", 170, "henrhoi"),
("Mari Leonhardsen", 170, "henrhoi"),
("Fredrik Solberg", 189, "chestbrah"),
("Adrian Falck", 188, "axeloh"),
("Martin Johansen", 189, "axeloh"),
("Aksel Berg", 182, "zyzz"),
("Alexander Togba", 184, "zyzz"),
("Daniel Kaasa", 180, "henrhoi"),
("Live Forfang", 171, "chestbrah"),
("Karoline Bakken", 169, "emdahl"),
("Jean Sissener", 183, "henrhoi"),
("Michele Svartdahl", 168, "henrhoi"),
("Andreas Justad", 187, "chestbrah"),
("Mildrid Haga", 152, "emdahl"),
("Ida Oline Haaberg", 166, "axeloh"),
("Katarina Stiff Aamlid", 167, "zyzz"),
("Synne Kallaak", 170, "emdahl"),
("Cecilie Helsvig", 169, "henrhoi"),
("Maria Solstad", 169, "chestbrah"),
("Jakob Gjøen", 190, "emdahl"),
("Caroline Skjøren", 180, "henrhoi"),
("Magnus Iversen", 300, "henrhoi"), #altfor hoey
("Eivind Rindal", 186, "chestbrah"),
("Marit Bjerkreim", 170, "emdahl"),
("Didrik Blyverket", 195, "henrhoi"),
("Caroline Kiær", 170, "henrhoi"),
("Jonas Hopsdal", 194, "chestbrah"),
("Matheus Franco", 180, "axeloh"),
("Marie Mathiasson", 163, "axeloh"),
("Anne Sophie Ness", 171, "zyzz"),
("Hanna Haavi", 170, "zyzz"),
("Remi Pedersen", 182, "henrhoi"),
("Marius Robsahm", 181, "chestbrah"),
("Mille Endreson", 169, "emdahl"),
("Thor Lange", 184, "henrhoi"),
("Lina Ekern", 163, "henrhoi"),
("Sofie Svartdal", 180, "chestbrah");




INSERT INTO NUTRITION(Dato, Calories, Fat, Carbs, Protein, ClientID) VALUES #all in grams
("2018-01-15", 4000, 400, 300, 50, 30),
("2018-01-09", 2500, 250, 100, 20, 31),
("2018-01-28", 3000, 400, 250, 45, 32),
("2018-02-01", 8550, 540, 830, 70, 33),
("2018-03-15", 2000, 500, 500, 40, 34),
("2018-03-09", 1500, 650, 400, 20, 35),
("2018-02-28", 3000, 400, 150, 45, 36),
("2018-03-01", 9550, 590, 830, 80, 37),
("2018-01-16", 1000, 200, 98, 23, 38),
("2018-01-10", 1500, 250, 300, 29, 39),
("2018-01-29", 7000, 600, 850, 55, 11),
("2018-02-02", 6550, 544, 430, 60, 12),
("2018-01-20", 6000, 444, 500, 50, 13),
("2018-01-08", 8500, 452, 750, 85, 14),
("2018-01-26", 3000, 307, 350, 45, 15),
("2018-02-05", 4550, 340, 330, 71, 16),
("2018-01-11", 4500, 500, 500, 50, 17),
("2018-01-01", 2000, 252, 100, 20, 18),
("2018-01-01", 3350, 304, 250, 35, 19),
("2018-02-21", 6050, 545, 830, 76, 20),
("2018-01-03", 1900, 290, 200, 17, 21),
("2018-01-02", 2000, 259, 100, 21, 22),
("2018-01-25", 10000, 670, 750, 92, 23),
("2018-02-06", 4550, 440, 830, 69, 24),
("2018-01-14", 4000, 310, 300, 58, 25),
("2018-02-09", 2500, 250, 100, 20, 26),
("2018-02-27", 3075, 470, 250, 46, 27),
("2018-02-11", 8000, 542, 830, 70, 28),
("2018-02-03", 1350, 211, 270, 38, 29),
("2018-01-16", 3000, 300, 200, 40, 30),
("2018-01-10", 5500, 450, 300, 60, 31),
("2018-01-29", 3700, 460, 290, 55, 32),
("2018-02-02", 8050, 520, 800, 67, 33),
("2018-03-16", 2050, 502, 530, 43, 34),
("2018-03-01", 5000, 600, 250, 64, 36),
("2018-03-10", 1500, 650, 400, 20, 35),
("2018-03-02", 8550, 500, 730, 72, 37),
("2018-01-17", 2000, 300, 250, 33, 38),
("2018-01-11", 7500, 550, 600, 69, 39),
("2018-01-30", 7005, 601, 855, 55, 11),
("2018-02-03", 6000, 504, 420, 55, 12),
("2018-01-21", 6000, 444, 500, 50, 13),
("2018-01-09", 9500, 652, 850, 88, 14),
("2018-01-27", 4320, 407, 370, 55, 15),
("2018-02-06", 1550, 140, 130, 21, 16),
("2018-01-12", 2500, 300, 300, 20, 17),
("2018-01-02", 1800, 152, 98, 19, 18),
("2018-01-02", 3450, 330, 260, 55, 19),
("2018-02-22", 6000, 525, 790, 70, 20),
("2018-01-04", 2000, 300, 260, 20, 21),
("2018-01-03", 7000, 559, 700, 71, 22),
("2018-01-26", 8000, 610, 650, 87, 23),
("2018-02-07", 5550, 540, 730, 70, 24),
("2018-01-15", 6000, 410, 400, 70, 25),
("2018-02-10", 2505, 251, 102, 21, 26),
("2018-02-28", 3775, 480, 259, 50, 27),
("2018-02-12", 8100, 549, 836, 72, 28),
("2018-02-04", 2050, 311, 280, 40, 29),
("2018-01-17", 4000, 390, 250, 42, 30),
("2018-01-11", 4, 2, 0, 10000, 31), #boer slaa ut
("2018-01-30", 4700, 510, 370, 56, 32),
("2018-02-03", 9050, 590, 820, 69, 33),
("2018-03-17", 1050, 582, 590, 45, 34),
("2018-03-02", 6000, 690, 290, 65, 36),
("2018-03-11", 2500, 700, 470, 25, 35),
("2018-03-03", 9550, 600, 780, 73, 37),
("2018-01-18", 1000, 390, 300, 37, 38),
("2018-01-12", 8500, 690, 650, 70, 39),
("2018-01-31", 8005, 681, 899, 57, 11),
("2018-02-04", 7000, 604, 480, 59, 12),
("2018-01-22", 7000, 544, 560, 53, 13),
("2018-01-10", 9700, 692, 870, 90, 14),
("2018-01-28", 5320, 487, 420, 57, 15),
("2018-02-07", 2550, 240, 196, 28, 16),
("2018-01-13", 3500, 380, 350, 25, 17),
("2018-01-03", 2800, 252, 198, 23, 18),
("2018-01-03", 4450, 430, 300, 58, 19),
("2018-02-23", 6600, 595, 800, 72, 20),
("2018-01-05", 3000, 400, 290, 24, 21),
("2018-01-04", 7500, 629, 740, 74, 22),
("2018-01-27", 8900, 680, 695, 88, 23),
("2018-02-08", 6550, 580, 770, 72, 24),
("2018-01-16", 7000, 485, 440, 71, 25),
("2018-02-11", 3505, 351, 162, 27, 26),
("2018-03-01", 4775, 530, 299, 55, 27),
("2018-02-13", 8900, 599, 888, 74, 28),
("2018-02-14", 3050, 411, 310, 44, 29),
("2018-02-21", 2800, 252, 198, 23, 1),
("2018-02-21", 4450, 430, 300, 58, 2),
("2018-02-21", 6600, 595, 800, 72, 3),
("2018-02-21", 3000, 400, 290, 24, 4),
("2018-02-21", 7500, 629, 740, 74, 5),
("2018-02-21", 8900, 680, 695, 88, 6),
("2018-02-21", 6550, 580, 770, 72, 7),
("2018-02-21", 7000, 485, 440, 71, 8),
("2018-02-21", 7000, 485, 440, 71, 9),
("2018-02-21", 3505, 351, 162, 27, 10),
("2018-02-22", 3000, 262, 220, 29, 1),
("2018-02-22", 4000, 410, 280, 52, 2),
("2018-02-22", 2600, 345, 400, 59, 3),
("2018-02-22", 5000, 600, 370, 44, 4),
("2018-02-22", 10500, 829, 890, 94, 5),
("2018-02-22", 3900, 480, 445, 68, 6),
("2018-02-22", 6000, 570, 750, 62, 7),
("2018-02-22", 3000, 285, 340, 51, 8),
("2018-02-22", 7560, 495, 500, 79, 9),
("2018-02-22", 2555, 291, 242, 31, 10),
("2018-02-23", 3333, 292, 320, 34, 1),
("2018-02-23", 6500, 510, 390, 61, 2),
("2018-02-23", 4500, 445, 492, 63, 3),
("2018-02-23", 7100, 650, 510, 69, 4),
("2018-02-23", 8200, 719, 693, 84, 5),
("2018-02-23", 3030, 400, 395, 55, 6),
("2018-02-23", 6100, 575, 750, 63, 7),
("2018-02-23", 100, 205, 300, 50, 8), #boer slaa ut
("2018-02-23", 3560, 295, 300, 59, 9),
("2018-02-23", 8351, 593, 602, 71, 10),
("2018-02-24", 8800, 652, 708, 73, 1),
("2018-02-24", 3450, 330, 290, 43, 2),
("2018-02-24", 2600, 325, 400, 52, 3),
("2018-02-24", 5555, 550, 490, 500, 4), #boer slaa ut paa protein?
("2018-02-24", 5500, 529, 540, 54, 5),
("2018-02-24", 4900, 480, 435, 51, 6),
("2018-02-24", 5120, 9, 610, 55, 7), #boer kanskje slaa ut paa fat?
("2018-02-24", 4444, 444, 430, 57, 8),
("2018-02-24", 1990, 185, 147, 22, 9),
("2018-02-24", 5555, 551, 462, 47, 10),
("2018-02-25", 2800, 252, 198, 23, 1),
("2018-02-25", 4450, 430, 300, 58, 2),
("2018-02-25", 6600, 595, 800, 72, 3),
("2018-02-25", 3000, 400, 290, 24, 4),
("2018-02-25", 7500, 629, 740, 74, 5),
("2018-02-25", 8900, 680, 695, 88, 6),
("2018-02-25", 4150, 420, 510, 52, 7),
("2018-02-25", 3300, 335, 310, 41, 8),
("2018-02-25", 6000, 595, 570, 75, 9),
("2018-02-25", 4505, 441, 322, 39, 10);


#Duration in min
INSERT INTO STRENGTH(Dato, Duration, ClientID) VALUES
("2018-01-13", 90, 1),
("2018-01-05", 60, 2),
("2018-01-23", 100, 3),
("2018-02-01", 120, 4),
("2018-02-02", 70, 1),
("2018-02-03", 90, 1),
("2018-01-15", 50, 1),
("2018-01-09", 20, 2),
("2018-01-28", 45, 3),
("2018-02-01", 130, 4),
("2018-03-15", 40, 5),
("2018-03-09", 20, 6),
("2018-02-28", 45, 7),
("2018-03-01", 80, 8),
("2018-01-16", 23, 9),
("2018-01-10", 29, 10),
("2018-01-29", 55, 11),
("2018-02-02", 60, 12),
("2018-01-20", 150, 13),
("2018-01-08", 85, 14),
("2018-01-26", 145, 15),
("2018-02-05", 71, 16),
("2018-01-11", 50, 17),
("2018-01-01", 20, 18),
("2018-01-01", 115, 19),
("2018-02-21", 76, 20),
("2018-01-03", 17, 21),
("2018-01-02", 21, 22),
("2018-01-25", 92, 23),
("2018-02-06", 129, 24),
("2018-01-14", 130, 25),
("2018-02-09", 20, 26),
("2018-02-27", 46, 27),
("2018-02-11", 70, 28),
("2018-02-03", 38, 29),
("2018-01-15", 50, 30),
("2018-01-09", 20, 31),
("2018-01-28", 45, 32),
("2018-02-01", 70, 33),
("2018-03-15", 40, 34),
("2018-03-09", 20, 35),
("2018-02-28", 45, 36),
("2018-03-01", 80, 37),
("2018-01-16", 13, 38),
("2018-01-10", 129, 39),
("2018-02-21", 23, 1),
("2018-02-21", 58, 2),
("2018-02-21", 72, 3),
("2018-02-21", 24, 4),
("2018-02-21", 74, 5),
("2018-02-21", 88, 6),
("2018-02-21", 71, 8),
("2018-02-21", 71, 9),
("2018-02-21", 27, 10),
("2018-02-22", 10, 1),
("2018-02-22", 55, 2),
("2018-02-22", 30, 3),
("2018-02-22", 20, 4),
("2018-02-22", 130, 5),
("2018-02-22", 80, 6),
("2018-02-22", 22, 7),
("2018-02-22", 50, 8),
("2018-02-22", 15, 9),
("2018-02-22", 60, 10),
("2018-02-23", 25, 1),
("2018-02-23", 45, 3),
("2018-02-23", 90, 4),
("2018-02-23", 70, 5),
("2018-02-23", 30, 6),
("2018-02-23", 30, 7),
("2018-02-23", 120, 8),
("2018-02-23", 60, 9),
("2018-02-23", 15, 10),
("2018-02-24", 55, 1),
("2018-02-24", 100, 2),
("2018-02-24", 110, 3),
("2018-02-24", 100, 4),
("2018-02-24", 15, 5),
("2018-02-24", 20, 6),
("2018-02-24", 5, 7),
("2018-02-24", 20, 10),
("2018-02-25", 50, 2),
("2018-02-25", 10, 3),
("2018-02-25", 10, 4),
("2018-02-25", 25, 5),
("2018-02-25", 27, 6),
("2018-02-25", 100, 7),
("2018-02-25", 45, 8),
("2018-02-25", 0, 9),
("2018-02-25", 60, 10),
("2018-01-30", 55, 11),
("2018-02-03", 55, 12),
("2018-01-21", 50, 13),
("2018-01-09", 88, 14),
("2018-01-27", 55, 15),
("2018-02-06", 21, 16),
("2018-01-12", 20, 17),
("2018-01-02", 19, 18),
("2018-01-02", 55, 19),
("2018-02-22", 70, 20),
("2018-01-04", 20, 21),
("2018-01-03", 71, 22),
("2018-01-26", 37, 23),
("2018-02-07", 30, 24),
("2018-01-15", 20, 25),
("2018-02-10", 22, 26),
("2018-02-28", 30, 27),
("2018-02-12", 832, 28),
("2018-02-04", 40, 29),
("2018-01-17", 42, 30),
("2018-01-11", 10, 31),
("2018-01-30", 56, 32),
("2018-02-03", 69, 33),
("2018-03-17", 45, 34),
("2018-03-02", 65, 36),
("2018-03-11", 25, 35),
("2018-03-03", 13, 37),
("2018-01-18", 37, 38),
("2018-01-12", 70, 39);

#Weight in kg
INSERT INTO EXERCISE(Navn, Weight, Sets, Reps) VALUES
("Benchpress", 80, 1, "12-12-10-8-6"),
("Bicepcurls", 20, 3, "25-20-18"),
("Pushdown", 60, 4, "12-11-10-12"),
("Squats", 120, 3, "15-12-10"),
("Benchpress", 70, 5, "13-11-10-8-6"),
("Deadlift", 150, 5, "5-5-5-5-4"),
("Shoulderpress", 30, 5, "18-15-12-8-6"),
("Shrugs", 40, 3, "20-18-8"),
("Bicepcurls", 30, 5, "12-12-10-8-6"),
("Benchpress", 80, 3, "12-12-10");


insert into ExerciseInStrength(ExerciseID, StrengthID) values
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1);


#Duration in min, Distance in km, Calories in grams
INSERT INTO ENDURANCE(Dato, Duration, ClientID, Distance, CaloriesBurned) VALUES
("2018-02-21", 90, 1, 10.5, 979), 
("2018-02-21", 60, 2, 5.8, 330),
("2018-02-21", 40, 3, 4.0, 200),
("2018-02-21", 120, 4, 21.5, 2005),
("2018-02-21", 30, 5, 4.5, 434), 
("2018-02-21", 15, 7, 3, 171),
("2018-02-21", 20, 9, 5, 440),
("2018-02-21", 50, 10, 10, 860),
("2018-02-22", 70, 1, 10, 932), 
("2018-02-22", 60, 2, 7, 399),
("2018-02-22", 20, 3, 3, 264),
("2018-02-22", 100, 4, 18, 1492),
("2018-02-22", 40, 5, 6, 578), 
("2018-02-22", 30, 6, 2, 126),
("2018-02-22", 10, 8, 3, 246),
("2018-02-22", 20, 9, 3, 264),
("2018-02-22", 10, 10, 2, 172),
("2018-02-23", 100, 2, 20, 1140),
("2018-02-23", 100, 3, 20, 1761),
("2018-02-23", 50, 4, 15, 1243),
("2018-02-23", 40, 5, 11, 1060), 
("2018-02-23", 75, 6, 20, 1264),
("2018-02-23", 45, 7, 13, 741),
("2018-02-23", 15, 9, 2, 176),
("2018-02-23", 35, 10, 5, 430),
("2018-02-24", 40, 1, 10, 932), 
("2018-02-24", 15, 2, 3.5, 199),
("2018-02-24", 15, 4, 3.5, 290),
("2018-02-24", 30, 5, 4.5, 434), 
("2018-02-24", 87, 7, 20, 1140),
("2018-02-24", 20, 9, 6, 528),
("2018-02-25", 20, 1, 6, 559), 
("2018-02-25", 40, 7, 10, 570),
("2018-02-25", 40, 9, 10, 881),
("2018-02-25", 60, 10, 20, 1720);




insert into ClientFat(ClientID, Dato, Fat) values
(1, "2018-02-21", 10950),
(1, "2018-02-22", 11000),
(1, "2018-02-23", 10000),
(1, "2018-02-24", 12000),
(1, "2018-02-25", 11000),
(2, "2018-02-21", 8900),
(2, "2018-02-22", 8950),
(2, "2018-02-23", 9900),
(2, "2018-02-24", 8400),
(2, "2018-02-25", 9100),
(3, "2018-02-21", 11500),
(3, "2018-02-22", 10000),
(3, "2018-02-23", 11000),
(3, "2018-02-24", 10000),
(3, "2018-02-25", 11400),
(4, "2018-02-21", 10000),
(4, "2018-02-22", 10000),
(4, "2018-02-23", 10500),
(4, "2018-02-24", 9900),
(4, "2018-02-25", 9990),
(5, "2018-02-21", 11000),
(5, "2018-02-22", 11300),
(5, "2018-02-23", 11000),
(5, "2018-02-24", 11000),
(5, "2018-02-25", 11000),
(6, "2018-02-21", 10700),
(6, "2018-02-22", 9900),
(6, "2018-02-23", 9900),
(6, "2018-02-24", 10000),
(6, "2018-02-25", 10500),
(7, "2018-02-21", 9000),
(7, "2018-02-22", 9000),
(7, "2018-02-23", 9000),
(7, "2018-02-24", 8500),
(7, "2018-02-25", 8000),
(8, "2018-02-21", 9900),
(8, "2018-02-22", 9000),
(8, "2018-02-23", 8800),
(8, "2018-02-24", 9000),
(8, "2018-02-25", 9000),
(9, "2018-02-21", 11500),
(9, "2018-02-22", 12000),
(9, "2018-02-23", 10000),
(9, "2018-02-24", 10000),
(9, "2018-02-25", 11000),
(10, "2018-02-21", 11000),
(10, "2018-02-22", 10500),
(10, "2018-02-23", 11900),
(10, "2018-02-24", 11000),
(10, "2018-02-25", 10850),
(30, "2018-01-15", 9000),
(31, "2018-01-09", 10000),
(32, "2018-01-28", 9000),
(33, "2018-02-01", 9900),
(34, "2018-03-15", 11000),
(35, "2018-03-09", 10200),
(36, "2018-02-28", 8400),
(37, "2018-03-01", 11000),
(38, "2018-01-16", 12000),
(39, "2018-01-10", 9200),
(11, "2018-01-29", 11200),
(12, "2018-02-02", 11000),
(13, "2018-01-20", 13000),
(14, "2018-01-08", 11000),
(15, "2018-01-26", 11400),
(16, "2018-02-05", 12000),
(17, "2018-01-11", 9900),
(18, "2018-01-01", 12900),
(19, "2018-01-01", 10000),
(20, "2018-02-21", 10200),
(21, "2018-01-03", 10200),
(22, "2018-01-02", 10900),
(23, "2018-01-25", 10200),
(24, "2018-02-06", 9900),
(25, "2018-01-14", 10999),
(26, "2018-02-09", 10000),
(27, "2018-02-27", 9100),
(28, "2018-02-11", 9100),
(29, "2018-02-03", 10300),
(30, "2018-01-16", 10900),
(31, "2018-01-10", 10300),
(32, "2018-01-29", 11000),
(33, "2018-02-02", 8900),
(34, "2018-03-16", 13000),
(35, "2018-03-01", 9000),
(36, "2018-03-10", 10200),
(37, "2018-03-02", 10000),
(38, "2018-01-17", 10200),
(39, "2018-01-11", 10000);


insert into ClientWeight(ClientID, Dato, Weight) values
(1, "2018-02-21", 91),
(1, "2018-02-22", 91.2),
(1, "2018-02-23", 91),
(1, "2018-02-24", 92.6),
(1, "2018-02-25", 92),
(2, "2018-02-21", 55),
(2, "2018-02-22", 54.5),
(2, "2018-02-23", 56),
(2, "2018-02-24", 54),
(2, "2018-02-25", 55.5),
(3, "2018-02-21", 85),
(3, "2018-02-22", 83),
(3, "2018-02-23", 84),
(3, "2018-02-24", 83),
(3, "2018-02-25", 84.5),
(4, "2018-02-21", 80),
(4, "2018-02-22", 81),
(4, "2018-02-23", 82),
(4, "2018-02-24", 80.5),
(4, "2018-02-25", 80),
(5, "2018-02-21", 93),
(5, "2018-02-22", 94),
(5, "2018-02-23", 93.2),
(5, "2018-02-24", 92.8),
(5, "2018-02-25", 93),
(6, "2018-02-21", 63),
(6, "2018-02-22", 61.9),
(6, "2018-02-23", 61.5),
(6, "2018-02-24", 62),
(6, "2018-02-25", 63.2),
(7, "2018-02-21", 55),
(7, "2018-02-22", 55),
(7, "2018-02-23", 55),
(7, "2018-02-24", 55),
(7, "2018-02-25", 54.5),
(8, "2018-02-21", 80),
(8, "2018-02-22", 78),
(8, "2018-02-23", 77),
(8, "2018-02-24", 79),
(8, "2018-02-25", 78),
(9, "2018-02-21", 85),
(9, "2018-02-22", 85),
(9, "2018-02-23", 83),
(9, "2018-02-24", 83),
(9, "2018-02-25", 84),
(10, "2018-02-21", 83),
(10, "2018-02-22", 83),
(10, "2018-02-23", 84),
(10, "2018-02-24", 83.5),
(10, "2018-02-25", 83),
(30, "2018-01-15", 80),
(31, "2018-01-09", 58),
(32, "2018-01-28", 79),
(33, "2018-02-01", 82),
(34, "2018-03-15", 67),
(35, "2018-03-09", 60),
(36, "2018-02-28", 50),
(37, "2018-03-01", 90),
(38, "2018-01-16", 100),
(39, "2018-01-10", 58),
(11, "2018-01-29", 93),
(12, "2018-02-02", 89),
(13, "2018-01-20", 98),
(14, "2018-01-08", 61),
(15, "2018-01-26", 62),
(16, "2018-02-05", 96),
(17, "2018-01-11", 54),
(18, "2018-01-01", 110),
(19, "2018-01-01", 61),
(20, "2018-02-21", 62),
(21, "2018-01-03", 63),
(22, "2018-01-02", 67),
(23, "2018-01-25", 65),
(24, "2018-02-06", 57),
(25, "2018-01-14", 90),
(26, "2018-02-09", 60),
(27, "2018-02-27", 80),
(28, "2018-02-11", 85),
(29, "2018-02-03", 65),
(30, "2018-01-16", 90),
(31, "2018-01-10", 67),
(32, "2018-01-29", 91),
(33, "2018-02-02", 78),
(34, "2018-03-16", 68),
(35, "2018-03-01", 52),
(36, "2018-03-10", 60),
(37, "2018-03-02", 88),
(38, "2018-01-17", 92),
(39, "2018-01-11", 62);

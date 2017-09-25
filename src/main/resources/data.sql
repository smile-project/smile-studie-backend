/*
INSERT INTO USERS (ID, USERNAME, PASSWORD) VALUES (1, 'admin@admin.com', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi');
INSERT INTO USERS (ID, USERNAME, PASSWORD) VALUES (2, 'enabled@user.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');
INSERT INTO USERS (ID, USERNAME, PASSWORD) VALUES (3, 'disabled@user.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');
*/

INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');

/*
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);
*/

INSERT INTO questionaire_option(
            id, text, type, value)
    VALUES 
	(101, 'männlich','radio',1),
	(102, 'weiblich','radio',2),
	
	(103, 'Alter in Jahren', 'input_number',-1),
	
	(104, 'Verheiratet und lebe mit meinem/meiner Ehepartner/-in zusammen', 'radio',1),
	(105,'In eingetragener Lebenspartnerschaft zusammenlebend (gleichgeschlechtlich)','radio',2),
	(106,'Verheiratet und lebe von meinem/meiner Ehepartner/-in getrennt','radio',3),
	(107,'Ledig','radio',4),
	(108,'Geschieden','radio',5),
	(109,'Verwitwet','radio',6),
	(110,'Eingetragene Lebenspartnerschaft, getrennt lebend (gleichgeschlechtlich)','radio',7),
	(111,'Eingetragene Lebenspartnerschaft aufgehoben (gleichgeschlechtlich)','radio',8),
	(112,'Eingetragene/r Lebenspartner/-in verstorben (gleichgeschlechtlich)','radio',9),
	
	(113, 'Schüler/-in, besuche eine allgemeinbildende Vollzeitschule','radio',1),
	(114, 'Von der Schule abgegangen ohne Schulabschluss ','radio',2),
	(115, 'Hauptschulabschluss (Volksschulabschluss) oder gleichwertiger Abschluss','radio',3),
	(116, 'Polytechnische Oberschule der DDR mit Abschluss der 8. oder 9. Klasse','radio',4),
	(117, 'Realschulabschluss (Mittlere Reife) oder gleichwertiger Abschluss','radio',5),
	(118, 'Polytechnische Oberschule der DDR mit Abschluss der 10. Klasse','radio',6),
	(119, 'Fachhochschulreife','radio',7),
	(120, 'Abitur/Allgemeine oder fachgebundene Hochschulreife (Gymnasium bzw. EOS, auch EOS mit Lehre)','radio',8),
	(121, 'Einen anderen Schulabschluss','radio_text',9),
	
	(122, 'Hauptschulabschluss oder gleichwertigen Abschluss','radio',1),
	(123, 'Realschulabschluss (Mittlere Reife) oder gleichwertigen Abschluss','radio',2),
	(124, 'Fachhochschulreife','radio',3),
	(125, 'Abitur/Allgemeine oder fachgebundene Hochschulreife','radio',4),
	(126, 'Einen anderen Schulabschluss','radio_text',5),
	
	(127, 'Wie hoch ist Ihr eigenes durchschnittliches monatliches Nettoeinkommen?','input_number',-1),
	
	(201,'starke Ablehnung','radio',1),
	(202,'Ablehnung','radio',2),
	(203,'leichte Ablehnung','radio',3),
	(204,'weder Ablehnung noch Zustimmung','radio',4),
	(205,'leichte Zustimmung','radio',5),
	(206,'Zustimmung','radio',6),
	(207,'starke Zustimmung','radio',7),
	
	(301,'gar nicht','radio',1),
	(302,'ein bisschen','radio',2),
	(303,'einigermaßen','radio',3),
	(304,'erheblich ','radio',4),
	(305,'äußerst','radio',5),
	
	(401,'Trifft überhaupt nicht zu', 'radio',1),
	(402,'Trifft eher nicht zu', 'radio',2),
	(403,'Weder noch', 'radio',3),
	(404,'Eher zutreffend', 'radio',4),
	(405,'Trifft voll und ganz zu', 'radio',5),
	
	(501,'Trifft gar nicht zu','radio',1),
	(502,'Trifft wenig zu','radio',2),
	(503,'Trifft etwas zu','radio',3),
	(504,'Trifft ziemlich zu','radio',4),
	(505,'Trifft voll und ganz zu','radio',5),
	
	(601,'Nie','radio',1),
	(602,'sehr selten','radio',2),
	(603,'selten','radio',3),
	(604,'gelegentlich','radio',4),
	(605,'oft','radio',5),
	(606,'sehr oft','radio',6),
	(607,'fast immer','radio',7);

INSERT INTO page(
            id, text, title)
    VALUES 
	
	(101, 'Welches Geschlecht haben Sie?', 'Fragebogen 1'),
	(102, 'Bitte geben Sie ihr derzeitges Alter in ganzen Jahren an','Fragebogen 1'),
	(103, 'Welchen Familienstand haben Sie? Was in dieser Liste trifft auf Sie zu?','Fragebogen 1'),
	(104, 'Welchen höchsten allgemeinbildenden Schulabschluss haben Sie?','Fragebogen 1'),
	(105, 'Welchen allgemeinbildenden Schulabschluss streben Sie an?','Fragebogen 1'),
	(106, 'Wie hoch ist Ihr eigenes durchschnittliches monatliches Nettoeinkommen?', 'Fragebogen 1'),

	(201, 'In den meisten Bereichen entspricht mein Leben meinen Idealvorstellungen.', 'Fragebogen 2'),
    (202, 'Meine Lebensbedingungen sind ausgezeichnet.', 'Fragebogen 2'),
	(203, 'Ich bin mit meinem Leben zufrieden.', 'Fragebogen 2'),
	(204, 'Bisher habe ich die wesentlichen Dinge erreicht, die ich mir für mein Leben wünsche.', 'Fragebogen 2'),
	(205, 'Wenn ich mein Leben noch einmal leben könnte, würde ich kaum etwas ändern.', 'Fragebogen 2'),
	
	(301, 'aktiv','Fragebogen 3'),
	(302, 'bekümmert','Fragebogen 3'),
	(303, 'interessiert','Fragebogen 3'),
	(304, 'freudig erregt','Fragebogen 3'),
	(305, 'verärgert','Fragebogen 3'),
	(306, 'stark','Fragebogen 3'),
	(307, 'schuldig','Fragebogen 3'),
	(308, 'erschrocken','Fragebogen 3'),
	(309, 'feindselig','Fragebogen 3'),
	(310, 'angeregt','Fragebogen 3'),
	(311, 'stolz','Fragebogen 3'),
	(312, 'gereizt','Fragebogen 3'),
	(313, 'begeistert','Fragebogen 3'),
	(314, 'beschämt','Fragebogen 3'),
	(315, 'wach','Fragebogen 3'),
	(316, 'nervös','Fragebogen 3'),
	(317, 'entschlossen','Fragebogen 3'),
	(318, 'aufmerksam','Fragebogen 3'),
	(319, 'durcheinander','Fragebogen 3'),
	(320, 'ängstlich','Fragebogen 3'),
	
	(401, 'Ich bin eher zurückhaltend, reserviert.', 'Fragebogen 4'),
	(402, 'Ich schenke anderen leicht Vertrauen, glaube an das Gute im Menschen.', 'Fragebogen 4'),
	(403, 'Ich bin bequem, neige zur Faulheit.', 'Fragebogen 4'),
	(404, 'Ich bin entspannt, lasse mich durch Stress nicht aus der Ruhe bringen.', 'Fragebogen 4'),
	(405, 'Ich habe nur wenig künstlerisches Interesse.', 'Fragebogen 4'),
	(406, 'Ich gehe aus mir heraus, bin gesellig.', 'Fragebogen 4'),
	(407, 'Ich neige dazu, andere zu kritisieren.', 'Fragebogen 4'),
	(408, 'Ich erledige Aufgaben gründlich.', 'Fragebogen 4'),
	(409, 'Ich werde leicht nervös und unsicher.', 'Fragebogen 4'),
	(410, 'Ich habe eine aktive Vorstellungskraft, bin fantasievoll.', 'Fragebogen 4'),
	
	(501, 'Im Streit bleibe ich stets sachlich und objektiv.','Fragebogen 5'),
	(502, 'Auch wenn ich selbst gestresst bin, behandle ich andere immer freundlich und zuvorkommend.','Fragebogen 5'),
	(503, 'Wenn ich mich mit jemandem unterhalte, höre ich ihm immer aufmerksam zu.','Fragebogen 5'),
	(504, 'Es ist schon mal vorgekommen, dass ich jemanden ausgenutzt habe.','Fragebogen 5'),
	(505, 'Ich habe schon mal Müll einfach in die Landschaft oder auf die Straße geworfen.','Fragebogen 5'),
	(506, 'Manchmal helfe ich jemandem nur, wenn ich eine Gegenleistung erwarten kann.','Fragebogen 5'),
	
	(601, 'Ich muss mich sehr dazu antreiben, etwas zu tun.', 'Fragebogen 6'),
	(602, 'Vieles erscheint mir so sinnlos.', 'Fragebogen 6'),
	(603, 'Mich bedrücken Schuldgefühle.', 'Fragebogen 6'),
	(604, 'Ich fühle mich einsam, selbst wenn ich mit anderen Menschen zusammen bin.', 'Fragebogen 6'),
	(605, 'Ich habe traurige Stimmungen.', 'Fragebogen 6'),
	(606, 'Ich finde es schwer, Entscheidungen zu treffen.', 'Fragebogen 6'),
	(607, 'Am Anfang des Tages fühle ich mich am schlechtesten.', 'Fragebogen 6'),
	(608, 'Ich sehe ohne Hoffnung in die Zukunft.', 'Fragebogen 6');


INSERT INTO questionaire(
            id, description, title)
    VALUES 
	(1, 'Hier werden die demographischen Daten der Probanden abgefragt', 'Demographische Daten'),
	(2,'Es folgen fünf Aussagen, denen Sie zustimmen bzw. die Sie ablehnen können. Bitte benutzen Sie die folgende Skala von 1-7, um Ihre Zustimmung bzw. Ablehnung zu jeder Aussage zum Ausdruck zu bringen.','Fragebogen 2'),
	(3,'Hier ein Erklärtext für Probanden','Fragebogen3 - PANAS'),
	(4,'Hier ein Erklärtext für Probanden','Fragebogen4 - BFI-10'),
	(5,'Hier ein Erklärtext für Probanden','Fragebogen5 - KSE-G'),
	(6,'Hier ein Erklärtext für Probanden','Fragebogen 6 - Depressivität im nicht klinische Kontext');


INSERT INTO questionaire_pages(
            questionaire_id, pages_id)
    VALUES 
	(1,101),(1,102),(1,103),(1,104),(1,105),(1,106),
	(2,201),(2,202),(2,203),(2,204),(2,205),
	(3,301),(3,302),(3,303),(3,304),(3,305),(3,306),(3,307),(3,308),(3,309),(3,310),(3,311),(3,312),(3,313),(3,314),(3,315),(3,316),(3,317),(3,318),(3,319),(3,320),
	(4,401),(4,402),(4,403),(4,404),(4,405),(4,406),(4,407),(4,408),(4,409),(4,410),
	(5,501),(5,502),(5,503),(5,504),(5,505),(5,506),
	(6,601),(6,602),(6,603),(6,604),(6,605),(6,606),(6,607),(6,608);


INSERT INTO pages_questionaireoptions(
            pages_id, questionaireoptions_id)
    VALUES 
	
	(101,101),(101,102),
	(102,103),
	(103,104),(103,105),(103,106),(103,107),(103,108),(103,109),(103,110),(103,111),(103,112),
	(104,113),(104,114),(104,115),(104,116),(104,117),(104,118),(104,119),(104,120),(104,121),
	(105,122),(105,123),(105,124),(105,125),(105,126),
	(106,127),
	
	(201, 201),(201,202),(201,203),(201,204),(201,205),(201,206),(201,207),
	(202, 201),(202,202),(202,203),(202,204),(202,205),(202,206),(202,207),
	(203, 201),(203,202),(203,203),(203,204),(203,205),(203,206),(203,207),
	(204, 201),(204,202),(204,203),(204,204),(204,205),(204,206),(204,207),
	(205, 201),(205,202),(205,203),(205,204),(205,205),(205,206),(205,207),
	
    (301,301),(301,302),(301,303),(301,304),(301,305),
    (302,301),(302,302),(302,303),(302,304),(302,305),
    (303,301),(303,302),(303,303),(303,304),(303,305),
    (304,301),(304,302),(304,303),(304,304),(304,305),
    (305,301),(305,302),(305,303),(305,304),(305,305),
    (306,301),(306,302),(306,303),(306,304),(306,305),
    (307,301),(307,302),(307,303),(307,304),(307,305),
    (308,301),(308,302),(308,303),(308,304),(308,305),
    (309,301),(309,302),(309,303),(309,304),(309,305),
    (310,301),(310,302),(310,303),(310,304),(310,305),
    (311,301),(311,302),(311,303),(311,304),(311,305),
    (312,301),(312,302),(312,303),(312,304),(312,305),
    (313,301),(313,302),(313,303),(313,304),(313,305),
    (314,301),(314,302),(314,303),(314,304),(314,305),
    (315,301),(315,302),(315,303),(315,304),(315,305),
    (316,301),(316,302),(316,303),(316,304),(316,305),
    (317,301),(317,302),(317,303),(317,304),(317,305),
    (318,301),(318,302),(318,303),(318,304),(318,305),
    (319,301),(319,302),(319,303),(319,304),(319,305),
    (320,301),(320,302),(320,303),(320,304),(320,305),
	
    (401,401),(401,402),(401,403),(401,404),(401,405),
    (402,401),(402,402),(402,403),(402,404),(402,405),
    (403,401),(403,402),(403,403),(403,404),(403,405),
    (404,401),(404,402),(404,403),(404,404),(404,405),
    (405,401),(405,402),(405,403),(405,404),(405,405),
    (406,401),(406,402),(406,403),(406,404),(406,405),
    (407,401),(407,402),(407,403),(407,404),(407,405),
    (408,401),(408,402),(408,403),(408,404),(408,405),
    (409,401),(409,402),(409,403),(409,404),(409,405),
    (410,401),(410,402),(410,403),(410,404),(410,405),
	
    (501,501),(501,502),(501,503),(501,504),(501,505),
    (502,501),(502,502),(502,503),(502,504),(502,505),
    (503,501),(503,502),(503,503),(503,504),(503,505),
    (504,501),(504,502),(504,503),(504,504),(504,505),
    (505,501),(505,502),(505,503),(505,504),(505,505),
    (506,501),(506,502),(506,503),(506,504),(506,505),
    
	(601,601),(601,602),(601,603),(601,604),(601,605),(601,606),(601,607),
    (602,601),(602,602),(602,603),(602,604),(602,605),(602,606),(602,607),
    (603,601),(603,602),(603,603),(603,604),(603,605),(603,606),(603,607),
    (604,601),(604,602),(604,603),(604,604),(604,605),(604,606),(604,607),
    (605,601),(605,602),(605,603),(605,604),(605,605),(605,606),(605,607),
    (606,601),(606,602),(606,603),(606,604),(606,605),(606,606),(606,607),
    (607,601),(607,602),(607,603),(607,604),(607,605),(607,606),(607,607),
    (608,601),(608,602),(608,603),(608,604),(608,605),(608,606),(608,607);
	

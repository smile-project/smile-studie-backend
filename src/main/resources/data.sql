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
	(201,'starke Ablehnung','radio',1),
	(202,'Ablehnung','radio',2),
	(203,'leichte Ablehnung','radio',3),
	(204,'weder Ablehnung noch Zustimmung','radio',4),
	(205,'leichte Zustimmung','radio',5),
	(206,'Zustimmung','radio',6),
	(207,'starke Zustimmung','radio',7)
	;

INSERT INTO page(
            id, text, title)
    VALUES 
	(201, 'In den meisten Bereichen entspricht mein Leben meinen Idealvorstellungen.', 'Fragebogen 2'),
    (202, 'Meine Lebensbedingungen sind ausgezeichnet.', 'Fragebogen 2'),
	(203, 'Ich bin mit meinem Leben zufrieden.', 'Fragebogen 2'),
	(204, 'Bisher habe ich die wesentlichen Dinge erreicht, die ich mir für mein Leben wünsche.', 'Fragebogen 2'),
	(205, 'Wenn ich mein Leben noch einmal leben könnte, würde ich kaum etwas ändern.', 'Fragebogen 2')
	;


INSERT INTO questionaire(
            id, description, title)
    VALUES 
	(1, 'Hier werden die demographischen Daten der Probanden abgefragt', 'Demographische Daten'),
	(2,'Es folgen fünf Aussagen, denen Sie zustimmen bzw. die Sie ablehnen können. Bitte benutzen Sie die folgende Skala von 1-7, um Ihre Zustimmung bzw. Ablehnung zu jeder Aussage zum Ausdruck zu bringen.','Fragebogen 2'),
	(3,'Hier ein Erklärtext für Probanden','Fragebogen3'),
	(4,'Hier ein Erklärtext für Probanden','Fragebogen4'),
	(5,'Hier ein Erklärtext für Probanden','Fragebogen5'),
	(6,'Hier ein Erklärtext für Probanden','Fragebogen6');


INSERT INTO questionaire_pages(
            questionaire_id, pages_id)
    VALUES 
	(2,201),(2,202),(2,203),(2,204),(2,205);


INSERT INTO pages_questionaireoptions(
            pages_id, questionaireoptions_id)
    VALUES 
	(201, 201),(201,202),(201,203),(201,204),(201,205),(201,206),(201,207),
	(202, 201),(202,202),(202,203),(202,204),(202,205),(202,206),(202,207),
	(203, 201),(203,202),(203,203),(203,204),(203,205),(203,206),(203,207),
	(204, 201),(204,202),(204,203),(204,204),(204,205),(204,206),(204,207),
	(205, 201),(205,202),(205,203),(205,204),(205,205),(205,206),(205,207);
	

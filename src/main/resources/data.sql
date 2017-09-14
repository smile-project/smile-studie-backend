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
    VALUES (1, 'male', 'str', 1),
    (2, 'female', 'str', 2),
    (3, 'one', 'str', 1),
    (4, 'two', 'str', 2);

INSERT INTO page(
            id, text, title)
    VALUES (1, 'Example page text', 'Example page title'),
    (2, '2nd text', '2nd title');


INSERT INTO questionaire(
            id, description, title)
    VALUES (1, 'Example questionaire description', 'Example questionaire title');


INSERT INTO questionaire_pages(
            questionaire_id, pages_id)
    VALUES (1, 1), (1,2);


INSERT INTO pages_questionaireoptions(
            pages_id, questionaireoptions_id)
    VALUES (1, 1), (1,2), (2,3), (2,4);

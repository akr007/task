CREATE SCHEMA taskDB;

CREATE TABLE user {
	id INT NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
	PRIMARY KEY(id)
} ENGINE=InnoDB;

CREATE TABLE advertisement {
	id INT NOT NULL,
	title VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL
	PRIMARY KEY(id)
} ENGINE=InnoDB;

INSERT INTO user VALUES (1, 'admin@admin.com', 'admin');
INSERT INTO user VALUES (2, 'testuser@test.com', 'test');
INSERT INTO user VALUES (3, 'antalkrisztian0@gmail.com', '123456');

INSERT INTO advertisement VALUES (1, 'Test Title', 'Test Description');
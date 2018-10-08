DROP TABLE IF EXISTS User;

CREATE TABLE User(
username VARCHAR(20) PRIMARY KEY,
password VARCHAR(20) NOT NULL,
usertype VARCHAR(10) DEFAULT 'customer'
);

alter table Passanger
ADD FOREIGN KEY (username) REFERENCES User(username);
DROP TABLE IF EXISTS AvailableSeat;

CREATE TABLE AvailableSeat(
Flight_number INT NOT NULL,
Economy_seat INT DEFAULT '0',
First_seat INT  DEFAULT '0',
Business_seat INT  DEFAULT '0',
FOREIGN KEY (Flight_number)
REFERENCES Flight(Flight_number)
);

DROP TABLE IF EXISTS Flight;
CREATE TABLE Flight(
Flight_number INT NOT NULL,
Arrival_time TIME NOT NULL,
Arrival_date DATE NOT NULL,
Departure_time TIME NOT NULL,
Departure_date DATE NOT NULL,
Destination VARCHAR(45) NOT NULL,
Airplane_id INT,
Departure_city VARCHAR(45) NOT NULL,
Arrival_city VARCHAR(45) NOT NULL,
PRIMARY KEY (Flight_number),
FOREIGN KEY (Airplane_id)
REFERENCES Airplane(Airplane_id)
);

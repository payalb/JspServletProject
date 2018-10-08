DROP TABLE IF EXISTS Booking;

CREATE TABLE Booking(
Booking_id INT AUTO_INCREMENT,
Passanger_id INT,
Flight_number INT NOT NULL,
Seat_number INT NOT NULL,
Baggage VARCHAR(45),
Class VARCHAR(15),
Reser_status VARCHAR(20),
PRIMARY KEY (Booking_id),
FOREIGN KEY (Flight_number)
REFERENCES Flight(Flight_number),
FOREIGN KEY (Passanger_id)
REFERENCES Passanger(Passanger_id),
FOREIGN KEY (Class)
REFERENCES Flight_class(Class),
FOREIGN KEY (Reser_status)
REFERENCES Booking_status(Status)
);

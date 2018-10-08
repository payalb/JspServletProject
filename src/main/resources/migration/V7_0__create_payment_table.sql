DROP TABLE IF EXISTS Payment;

CREATE TABLE Payment(
Payment_id INT AUTO_INCREMENT,
Booking_id INT,
Payment_amount DOUBLE,
Payment_date TIMESTAMP,
PRIMARY KEY (Payment_id),
FOREIGN KEY (Booking_id)
REFERENCES Booking(Booking_id)
);

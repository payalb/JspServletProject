package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Booking;
import com.exception.DatabaseException;

import dbUtility.DBStore;

public class BookDao {

	public static boolean insertBooking(Booking b) throws DatabaseException {
		boolean ret = false;
		String insertIntoBooking = "INSERT INTO Booking(Passanger_id, Flight_number, Seat_number, Baggage,Class,Reser_status) "
				+ "VALUES (?,?,?,?,?,?);";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoBooking);) {
			pst.setInt(1, b.getPassanger_id());
			pst.setInt(2, b.getFlight_number());
			pst.setInt(3, b.getSeat_number());
			pst.setString(4, b.getBaggage());
			pst.setString(5, b.getCls());
			pst.setString(6, b.getReser_status());
			ret = pst.execute();
			conn.commit();
			return ret;
		} catch (SQLException e) {
			throw new DatabaseException("Bookign failed for " + b + " ; " + e.getMessage());
		}
	}

	public static List<Booking> getBooking(int id) throws DatabaseException {
		List<Booking> booklist = new ArrayList<>();
		String selectAllFlights = "select * from Booking WHERE Passanger_id=?";
		try (Connection conn = DBStore.getDataSource().getConnection();
			PreparedStatement pst = conn.prepareStatement(selectAllFlights);) {

				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					int bId = rs.getInt("Booking_id");
					int pId = rs.getInt("Passanger_id");
					int fno = rs.getInt("Flight_number");
					int sno = rs.getInt("Seat_number");
					String bag = rs.getString("Baggage");
					String cls = rs.getString("Class");
					String status = rs.getString("Reser_status");
					Booking newBook = new Booking(bId, pId, fno, sno, bag, cls, status);
					booklist.add(newBook);
				}

				rs.close();

			return booklist;
		} catch (SQLException e) {
			throw new DatabaseException("Booking fetch failed for " + id + " ; " + e.getMessage());
		}
	}

	public static int getBookingId(int fnum, int pid) throws DatabaseException {
		int bId = 0;
		String selectId = "select Booking_id from Booking WHERE Flight_number=? AND Passanger_id=? ORDER BY Booking_id DESC LIMIT 1;";
		try (Connection conn = DBStore.getDataSource().getConnection();
			PreparedStatement pst = conn.prepareStatement(selectId);) {

				pst.setInt(1, fnum);
				pst.setInt(2, pid);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					bId = rs.getInt("Booking_id");
				}
				rs.close();
				return bId;
		} catch (SQLException e) {
			throw new DatabaseException("Booking fetch failed for passenger " + pid + " ; " + e.getMessage());
		}
	}

	public static boolean removeBooking(int bid) throws DatabaseException {
		String removeBook = "DELETE from Booking WHERE Booking_id=?";
		try (Connection conn = DBStore.getDataSource().getConnection();
			PreparedStatement pst = conn.prepareStatement(removeBook);) {
				pst.setInt(1, bid);
				pst.execute();
				conn.commit();
			return true;

		} catch (SQLException e1) {
			throw new DatabaseException("Booking deletion failed for " + bid + " ; " + e1.getMessage());
		}
	}
}

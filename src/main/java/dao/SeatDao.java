package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Seat;
import com.exception.DatabaseException;

import dbUtility.DBStore;

public class SeatDao {
	public static Seat getSeats(int fnum) throws DatabaseException {
		int Fseat = 0, Bseat = 0, Eseat = 0;
		Seat s = null;
		String selectId = "select * from AvailableSeat WHERE Flight_number=?";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(selectId);) {

			pst.setInt(1, fnum);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Eseat = rs.getInt("Economy_seat");
				Fseat = rs.getInt("First_seat");
				Bseat = rs.getInt("Business_seat");
				s = new Seat(fnum, Eseat, Fseat, Bseat);
			}
			rs.close();

			return s;
		} catch (SQLException e) {
			throw new DatabaseException("Getting seat information failed for " + fnum + " ; " + e.getMessage());
		}
	}

	public static int insertSeat(Seat s) throws DatabaseException {
		int ret = 0;
		String insertIntoAirplane = "INSERT INTO AvailableSeat(Flight_number,Economy_seat,First_seat,Business_seat) "
				+ "VALUES (?,?,?,?);";

		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoAirplane);) {
			pst.setInt(1, s.getFlight_number());
			pst.setInt(2, s.getEconomy_seat());
			pst.setInt(3, s.getFirst_seat());
			pst.setInt(4, s.getBusiness_seat());

			ret = pst.executeUpdate();
			conn.commit();
			return ret;
		} catch (SQLException e) {
			throw new DatabaseException("Insert seat failed for " + s + " ; " + e.getMessage());
		}
	}

	public static int updateSeat(Seat s) throws DatabaseException {
		int ret = 0;
		String insertIntoSeat = "UPDATE AvailableSeat SET Economy_seat=?,First_seat=?,Business_seat=? WHERE Flight_number=?";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoSeat);) {

			pst.setInt(1, s.getEconomy_seat());
			pst.setInt(2, s.getFirst_seat());
			pst.setInt(3, s.getBusiness_seat());
			pst.setInt(4, s.getFlight_number());
			ret = pst.executeUpdate();
			System.out.println("update status" + ret);
			conn.commit();

			return ret;
		} catch (SQLException e) {
			throw new DatabaseException("Update seat failed for " + s + " ; " + e.getMessage());
		}
	}

	public static boolean removeFlight(int fno) throws DatabaseException {
		String removeflight = "DELETE from AvailableSeat WHERE Flight_number=?";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(removeflight);) {

			pst.setInt(1, fno);
			pst.execute();

			conn.commit();
			return true;

		} catch (SQLException e) {
			throw new DatabaseException("Flight deletion failed for " + fno + " ; " + e.getMessage());
		}

	}

}
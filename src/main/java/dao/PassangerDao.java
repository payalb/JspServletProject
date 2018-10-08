package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Passanger;
import com.exception.DatabaseException;

import dbUtility.DBStore;

public class PassangerDao {
	public static int insertPassanger(Passanger p) throws DatabaseException {

		int ret = 0;
		System.out.println("inserting");
		String insertIntoPassanger = "INSERT INTO Passanger(username,firstName, lastName, ssn, age, street,apartment_number, city, state, zip, tel_home, tel_office, email) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoPassanger);) {

			pst.setString(1, p.getUsername());
			System.out.println(p.getUsername());
			pst.setString(2, p.getFirstName());
			pst.setString(3, p.getLastName());
			pst.setString(4, p.getSsn());
			pst.setInt(5, p.getAge());
			pst.setString(6, p.getStreet());
			pst.setInt(7, p.getApartment_number());
			pst.setString(8, p.getCity());
			pst.setString(9, p.getState());
			pst.setInt(10, p.getZip());
			pst.setString(11, p.getTel_home());
			pst.setString(12, p.getTel_office());
			pst.setString(13, p.getEmail());
			System.out.println("executing");
			ret = pst.executeUpdate();

			System.out.println("commit");
			pst.close();
			conn.commit();

			System.out.println("return");
			return ret;
		} catch (SQLException e) {
			throw new DatabaseException("Saving passenger information failed for " + p + " ; " + e.getMessage());
		}
	}

	public static int getPassangerId(String uname) throws DatabaseException {

		ResultSet rs;
		int u = 0;
		String selectUser = "SELECT Passanger_id FROM Passanger WHERE username=?";
		try (Connection conn = DBStore.getDataSource().getConnection();

				PreparedStatement pst = conn.prepareStatement(selectUser);) {
			pst.setString(1, uname);
			rs = pst.executeQuery();

			if (rs.next()) {

				u = rs.getInt("Passanger_id");

			}
			return u;
		} catch (SQLException e) {
			throw new DatabaseException("Getting passenger information failed for " + uname + " ; " + e.getMessage());
		}
	}

	public static Passanger getPassanger(String uname) throws DatabaseException {
		ResultSet rs;

		Passanger p = null;
		String selectUser = "SELECT * FROM Passanger WHERE username=?";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(selectUser);) {
			pst.setString(1, uname);
			rs = pst.executeQuery();

			if (rs.next()) {

				int pid = rs.getInt("Passanger_id");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String ssn = rs.getString("SSN");
				String email = rs.getString("Email");
				int age = rs.getInt("Age");
				String street = rs.getString("Street");
				int apt = rs.getInt("Apartment_number");
				String city = rs.getString("City");
				String state = rs.getString("State");
				int zip = rs.getInt("Zip");
				String thome = rs.getString("Tel_home");
				String toffice = rs.getString("Tel_office");
				p = new Passanger(pid, uname, fname, lname, ssn, age, street, apt, city, state, zip, thome, toffice,
						email);
			}

			rs.close();
			return p;
		} catch (

		SQLException e) {
			throw new DatabaseException("Fetch passenger info failed for " + uname + " ; " + e.getMessage());
		}
	}

	public static int updatePassanger(Passanger p) throws DatabaseException {
		int ret = 0;
		String updatePassanger = "UPDATE Passanger SET firstName=?,lastName=?,ssn=?,age=?,street=?,apartment_number=?,city=?,state=?,zip=?,tel_home=?,tel_office=?, email=? WHERE Passanger_id=?";

		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(updatePassanger);) {

			pst.setString(1, p.getFirstName());
			pst.setString(2, p.getLastName());
			pst.setString(3, p.getSsn());
			pst.setInt(4, p.getAge());
			pst.setString(5, p.getStreet());
			pst.setInt(6, p.getApartment_number());
			pst.setString(7, p.getCity());
			pst.setString(8, p.getState());
			pst.setInt(9, p.getZip());
			pst.setString(10, p.getTel_home());
			pst.setString(11, p.getTel_office());
			pst.setString(12, p.getEmail());
			pst.setInt(13, p.getPassanger_id());

			ret = pst.executeUpdate();
			conn.commit();

			return ret;
		} catch (

		SQLException e) {
			throw new DatabaseException("Update passenger failed for " + p + " ; " + e.getMessage());
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;
import com.exception.DatabaseException;

import dbUtility.DBStore;

public class UserDao {

	public static int insertUser(User u) throws DatabaseException {
		int ret = 0;
		String insertIntoUser = "INSERT INTO User(username, password, usertype) " + "VALUES (?,?,?);";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoUser);) {
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getUsertype());

			ret = pst.executeUpdate();
			conn.commit();
			return ret;
		} catch (SQLException e) {
			throw new DatabaseException("Insert user failed for " + u + " ; " + e.getMessage());
		}
	}

	public static String selectUser(String uname, String pwd, String utype) throws DatabaseException {
		ResultSet rs;
		String selectUser = "SELECT * FROM User WHERE username=? AND password =? AND usertype=?";
		String u = null;
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(selectUser);) {
			pst.setString(1, uname);
			pst.setString(2, pwd);
			pst.setString(3, utype);
			rs = pst.executeQuery();
			if (rs.next()) {
				u = rs.getString("username");
			}

			rs.close();

			return u;
		} catch (SQLException e) {
			throw new DatabaseException("Insert user failed for " + u + " ; " + e.getMessage());
		}
	}
}
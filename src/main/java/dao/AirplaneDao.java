package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.Airplane;
import com.exception.DatabaseException;

import dbUtility.DBStore;

public class AirplaneDao {

	public  void insertAirplane(Airplane a) throws DatabaseException {
		if(a==null || a.getAirplane_id()<=0 || a.getProducer()==null || a.getType()<=0) {
			throw new DatabaseException("Invalid data passed:"+ a);
		}
		String insertIntoAirplane = "INSERT INTO Airplane(Airplane_id, Producer, Type) " + "VALUES (?,?,?);";
		try (Connection conn = DBStore.getDataSource().getConnection();
			PreparedStatement pst = conn.prepareStatement(insertIntoAirplane);) {
			pst.setInt(1, a.getAirplane_id());
			pst.setString(2, a.getProducer());
			pst.setInt(3, a.getType());

			int noOfRowsUpdated= pst.executeUpdate();
			if(noOfRowsUpdated<=0) {
				throw new DatabaseException("Inserting record into db failed for "+ a);
			}
			conn.commit();
			pst.close();
		} catch (SQLException e) {
			throw new DatabaseException("Inserting record into db failed for " + a + " ; " + e.getMessage());
		}
	}

}

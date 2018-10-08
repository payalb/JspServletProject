package dbUtility;
//package DBUtility;
//
//import java.sql.Date;
//import java.sql.SQLException;
//import java.sql.Time;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.bean.Airplane;
//import com.bean.Flight;
//import com.bean.Passanger;
//
//public class test {
//
//	public static void main(String[] args) {
//		//Passanger p =new Passanger(1,"Sohan","patil","12345",25,"King dr",19,"chicago","IL",12234,"1234567","12345678","abc");
//		List<Flight> fli = new ArrayList<>();
//		Date d= Date.valueOf("2018-8-19");
//		Date d2= Date.valueOf("2018-8-19");
//		Time t= Time.valueOf("08:23:45");
//		Time t2= Time.valueOf("08:23:45");
//		Flight f= new Flight(12,t,d,t2,d2,2,"chicago","new york");
//		Airplane air = new Airplane(2, "Boeing", 777);
//		//SQLUtility.insertPassanger(p);
//		//SQLUtility.insertAirplane(air);
//		//SQLUtility.insertFlight(f);
//	//	fli=SQLUtility.selectFlight(d2, "chicago", "new york");
//		fli = SQLUtility.selectAllFlight();
//		System.out.println(fli);
//	}
//
//}

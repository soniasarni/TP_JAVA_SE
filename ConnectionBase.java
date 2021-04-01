package tp_JRame;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBase {

	public static Connection getConnection() {
		Connection connect=null;
		String url="jdbc:mysql://localhost/";
		String db="gestion_utilisateurs";
		String username="root";
		String pwd="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection(url+db,username,pwd);
			System.out.println("connection ok");
		}catch(Exception e) {
		e.printStackTrace();
		System.out.println("connection koooo");
		}
		
		
		
	
		
		return connect;
	

	}

}

package tp_JRame;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Utilisateur_dao implements IDAO<Utilisateur> {

	Connection connect = ConnectionBase.getConnection();

		@Override
	public void create(Utilisateur object) {
		try {
			PreparedStatement req=connect.prepareStatement("INSERT INTO Utilisateur"
					+"(id,email,pwd)VALUES(?,?,?)");
			req.setInt(1,object.getId());
			req.setString(2,object.getEmail());
			req.setString(3,object.getPwd());
			req.executeUpdate();
			System.out.println("insert success");
			
		}catch (Exception e){
			e.printStackTrace();
		System.out.println("insert kooo");
		}
		
	
	
}

		@Override
		public void read(Utilisateur objet) {
			// TODO Auto-generated method stub
			
		}
}




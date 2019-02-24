package datbase.mng.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecankurban.database.mng.model.User;

import datbase.mng.model.User2;

public class ConnectionManager2 {
	
	Connection conn=null;
	
	public void getConnection() {
		System.out.println("-----PostgreSQL" + "Deneme--------");
		try {
			getClass().forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver"+"Include in your library path!");
			e.printStackTrace();
			return;
			
		}
		try {
			conn=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "root");
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		
		if(conn!=null) {
			System.out.println("You made it,take control your database now!");
			User2 temp=new User2();
			temp.setId(6);
			temp.setUsername("ferda");
			temp.setPassword("2");
			insertUser(temp);
			//userUpdate(temp);
			//userDelete(temp);
			
		}else {
			System.out.println("Failed to make connection");
		}
	}
	
	public void userDelete(User2 temp) {
		try {
			Statement stmt=conn.createStatement();
			String sql="delete from usr2 where id='" +temp.getId()+ "'";
			int count=stmt.executeUpdate(sql);
			if(count<=0) {
				//silme gerçekleþmedi
				System.out.println("baþarýsýz");
			}else {
				//silme gerçekleþti
				System.out.println("baþarýlý");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void userUpdate(User2 temp) {
		
		try {
			Statement stmt=conn.createStatement();
			String sql="Update usr2 set usrname='" +temp.getUsername()+"' where id=" +temp.getId();
			int count=stmt.executeUpdate(sql);
			if(count<=0) {
				//iþlem gerçekleþmedi
				System.out.println("baþarýsýz");
			}else {
				//iþlem gerçekleþti
				System.out.println("baþarýlý");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertUser(User2 temp) {
		try {
			Statement stmt=conn.createStatement();
			String sql="insert into usr2(id,usrname,passwd) values ("+temp.getId() + " ,'" +temp.getUsername()+ "','" + temp.getPassword() +"')";
			int count=stmt.executeUpdate(sql);
			if(count<=0) {
				System.out.println("baþarýsýz");
			}else {
				System.out.println("baþarýlý");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}




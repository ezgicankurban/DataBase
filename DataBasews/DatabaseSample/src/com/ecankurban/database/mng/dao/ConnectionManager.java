package com.ecankurban.database.mng.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecankurban.database.mng.model.User;

public class ConnectionManager {
	
	Connection conn=null;
	
	public void getConnection() {
	System.out.println("--------PostgreSQL"+"JDBC Connection Testing ----------");
	
	try {
		Class.forName("org.postgresql.Driver");
		
		
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your PostgreSQL JDBC Driver"+"Include in your library path!");
		e.printStackTrace();
		return;
		
	}
	
	System.out.println("PostgreSQL JDBC Driver Registered!");
	
	try {
		conn=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "root");
		
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

	if(conn!=null) {
		System.out.println("You made it,take control your database now!");
		User temp=new User();
		temp.setId(5);
		temp.setUsername("admin");
		temp.setPassword("2");
		insertUser(temp);
		//userUpdate(temp);
		//userDelete(temp);
	
		getAllUser();
	}else {
		System.out.println("Failed to make connection");
	}
	
}
	public void userDelete(User temp) {
		try {
			Statement stmt=conn.createStatement();
			String sql="delete from usr where id='" +temp.getId()+ "'";
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
	
	public void userUpdate(User temp) {
		
		try {
			Statement stmt=conn.createStatement();
			String sql="Update usr set adi='" +temp.getUsername()+"' where id=" +temp.getId();
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
	
	public void insertUser(User temp) {
		try {
			Statement stmt=conn.createStatement();
			String sql="insert into usr(id,adi,soyadi) values ("+temp.getId() + " ,'" +temp.getUsername()+ "','" + temp.getPassword() +"')";
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

	public void getAllUser() {
		
		try {
			
			Statement stmt=conn.createStatement();
			String sql="select adi,soyadi from usr";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println(sql);
			
			while(rs.next()) {
				
				String kuladi=rs.getString("adi");
				String sifre=rs.getString("soyadi");
				System.out.println("Kullanýcý adý:" + kuladi+ "Soyadý:" + sifre);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.newweb.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnection {
	
		public Connection con = null;
		
		public Connection dbConnect() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sitcsea","root","");
				System.out.println("connected..");
			} catch (Exception e) {
				// TODO: handle exception
//				System.out.println(e);
				e.printStackTrace();
			}
			return con;
			
		}
		

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		DbConnection dc= new DbConnection();
		dc.dbConnect();

	}

}

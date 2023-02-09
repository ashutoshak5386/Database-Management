package com.newweb.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.newweb.dbconnection.DbConnection;
import com.newweb.vo.ResultVO;
import com.newweb.vo.UserVO;

public class UserDaoImpl //data access object implementation
{
	public Connection con =null;
	public PreparedStatement ps=null;
	DbConnection dc= new DbConnection();
	ResultVO rvo= new ResultVO();
	
	public ResultVO dataInsertResultVO(UserVO uvo) 
	{
		try
		{
			//Get data from servLet
			
			String password = uvo.getPassword();
			String email = uvo.getEmail();
			
			//Check the DbConnection
			con = dc.dbConnect();
			
			//execute SQL query
			String insertQuery = "Insert INTO csea VALUES(DEFAULT,?,?)";
			ps=con.prepareStatement(insertQuery);
			ps.setString(1, email);
			ps.setString(2, password);
			
			//check transaction status
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Success..");
			}else {
				System.out.println("Failed..");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rvo;
	}
	
	
	public ResultVO dataDelete(UserVO uvo) 
	{
		try
		{
			//Get data from servLet
			
//			String password = uvo.getPassword();
			String email = uvo.getEmail();
			
			//Check the DbConnection
			con = dc.dbConnect();
			
			//execute SQL query
			String insertQuery = "DELETE FROM csea WHERE email=?";
			ps=con.prepareStatement(insertQuery);
			ps.setString(1, email);
//			ps.setString(2, password);
			
			//check transaction status
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Success..");
			}else {
				System.out.println("Failed..");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rvo;
	}
}

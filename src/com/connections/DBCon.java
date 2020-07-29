package com.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
class MYSQL{
	static Connection getConnection() {
		Connection con=null;
		try {
			String url="jdbc:mysql://localhost:3306/Himanshu";
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root","system");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
class MONGODB{
	static Connection getConnection() {
		Connection con=null;
		try {
			String url="jdbc:mongo://localhost:27017/Student";
			String driver="mongodb.jdbc.MongoDriver";
			Class.forName(driver);
			con=DriverManager.getConnection(url,"","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
public class DBCon {
	public static void main(String[] args) {
		
		Connection con=MONGODB.getConnection();
		PreparedStatement stmt;
		try {
			
			Student st1=new Student();
			st1.setId(1);
			st1.setName("Himanshu");
			stmt = con.prepareStatement("select * from students");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("Name")+"  "+rs.getInt("ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

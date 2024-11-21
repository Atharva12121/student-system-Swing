package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;

public class Student_Swing {
	public Connection connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegess","root","Akaremore@47");
		return con;
		
	}
	public int insert(Student s) throws ClassNotFoundException, SQLException {
		Connection cn= connect();
		PreparedStatement stmt= cn.prepareStatement("INSERT INTO student(name,address,roll)  VALUE (?,?,?)");	
		stmt.setString(1,s.getName());
		stmt.setString(2,s.getAddress());
		stmt.setInt(3, s.getRoll());
		int a=stmt.executeUpdate();
		return a;
	}
	public int update(Student s) throws ClassNotFoundException, SQLException
	{
		Connection cn= connect();
		PreparedStatement stmt=cn.prepareStatement("UPDATE student SET name=?, address=? WHERE roll="+s.getRoll()+"");
		stmt.setString(1,s.getName());
		stmt.setString(2,s.getAddress());
		int a=stmt.executeUpdate();
		return a;		
	}
	public int delete(Student s) throws ClassNotFoundException, SQLException
	{
		Connection cn=connect();
		PreparedStatement stmt=cn.prepareStatement("DELETE FROM student WHERE roll="+s.getRoll()+"");
		int a=stmt.executeUpdate();
		return a;
	}
	public ResultSet st() throws SQLException, ClassNotFoundException
	{
		Connection  cn=connect();
		PreparedStatement stmt=cn.prepareStatement("SELECT * FROM student");
		ResultSet rs=stmt.executeQuery();
		return rs;
	
//		while(rs.next())
//		{
//			return System.out.println(rs.getInt(1)+ " "+rs.getString(2)+ "  "+rs.getString(3));
//		}		
	}
	public int len() throws ClassNotFoundException, SQLException
	{
		Connection  cn=connect();
		PreparedStatement stmt=cn.prepareStatement("SELECT COUNT(*) FROM student");
		ResultSet rs=stmt.executeQuery();
		int j=0;
		while(rs.next())
			{
				j=rs.getInt(1);
			}	
		return j;
	}
//	public int len1(Student s) throws ClassNotFoundException, SQLException
//	{
//		Connection  cn=connect();
//		PreparedStatement stmt=cn.prepareStatement("SELECT roll FROM student WHERE roll="+s.getRoll()+"");
//		ResultSet rs=stmt.executeQuery();
//		int j=0;
//		while(rs.next())
//			{
//				j=rs.getInt(1);
//			}	
//		return j;
//	}

	public ResultSet st1(Student s) throws ClassNotFoundException, SQLException{
		Connection cn=connect();
		PreparedStatement stmt= cn.prepareStatement("SELECT * FROM student WHERE roll="+s.getRoll()+"");
		ResultSet rs=stmt.executeQuery();
		return rs;
		
	}

}

package libraryConnectDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LibraryConnectDb {
	private Connection conn;
//	private String user ;
//	private String password;
//	private String url ;
	
	public LibraryConnectDb(){
//		LibraryReadProp  objPro = new LibraryReadProp();
//		Properties props=  objPro.getProp();
//		System.out.println(props.getProperty("url"));
//		this.conn = null;
//		this.user = props.getProperty("user");
//		this.password = props.getProperty("password");
//		this.url =props.getProperty("url");
		
	}
	public Connection getConnectMySQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee_shop?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8","root","1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		
	}
	
}

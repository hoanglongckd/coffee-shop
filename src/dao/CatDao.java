package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cat;
import libraryConnectDb.LibraryConnectDb;

public class CatDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Cat> getListCategory() {
		Cat Item = null;
		ArrayList<Cat> alItem = new ArrayList<Cat>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM category ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Cat(rs.getInt("id_cat"), rs.getString("name"));
				alItem.add(Item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alItem;

	}
	public int addCat(Cat objCat) {
		int result = 0;

		conn = lb.getConnectMySQL();
		String query = "INSERT INTO category VALUES (?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, objCat.getName());
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	

}

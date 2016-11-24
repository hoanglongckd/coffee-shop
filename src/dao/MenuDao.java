package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Menu;
import libraryConnectDb.LibraryConnectDb;

public class MenuDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();
	
	public ArrayList<Menu> getListMenu() {
		Menu Item = null;
		ArrayList<Menu> alItem = new ArrayList<Menu>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM thucdon LEFT JOIN giatien ON thucdon.idThucDon = giatien.idThucDon LEFT JOIN anh ON thucdon.idAnh = anh.idAnh WHERE thucdon.idQuan =1 ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Menu(rs.getInt("idThucDon"),rs.getInt("idAnh"),rs.getString("ten"),rs.getString("duongDan"),rs.getString("tenThucDon"),rs.getInt("soLuong"),rs.getFloat("giaTien"));
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
	public ArrayList<Menu> getList() {
		Menu Item = null;
		ArrayList<Menu> alItem = new ArrayList<Menu>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM thucdon  WHERE thucdon.idQuan =1 ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Menu(rs.getInt("idThucDon"),rs.getString("tenThucDon"));
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
}

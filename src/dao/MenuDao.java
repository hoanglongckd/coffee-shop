package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Menu;
import beanAdmin.MenuAdmin;
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
				Item = new Menu(rs.getInt("idThucDon"), rs.getInt("idAnh"), rs.getString("ten"),
						rs.getString("duongDan"), rs.getString("tenThucDon"), rs.getInt("soLuong"),
						rs.getFloat("giaTien"));
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
				Item = new Menu(rs.getInt("idThucDon"), rs.getString("tenThucDon"));
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

	public ArrayList<MenuAdmin> getListMenuAdmin() {
		MenuAdmin Item = null;
		ArrayList<MenuAdmin> alItem = new ArrayList<MenuAdmin>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM thucdon LEFT JOIN giatien ON thucdon.idThucDon = giatien.idThucDon LEFT JOIN anh ON thucdon.idAnh = anh.idAnh LEFT JOIN loaithucpham ON loaithucpham.idLoaiThucPham = thucdon.idLoaiThucPham WHERE thucdon.idQuan =1 ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new MenuAdmin(rs.getInt("idThucDon"), rs.getInt("idAnh"), rs.getString("ten"),
						rs.getString("duongDan"), rs.getInt("idQuan"), rs.getInt("idLoaiThucPham"),
						rs.getString("tenLoaiThucPham"), rs.getInt("idGiaTien"), rs.getString("tenThucDon"),
						rs.getInt("soLuong"), rs.getFloat("giaTien"), rs.getInt("kieuCheBien"), rs.getString("moTa"));
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

	public int addItem(MenuAdmin itemMenu) {
		int result = 0;
		conn = lb.getConnectMySQL();
		String query = "INSERT INTO thucdon (idAnh ,idQuan , idLoaiThucPham, idGiaTien, tenThucDon,soLuong,kieuCheBien, moTa ) VALUES(?,?,?,?,?,?,?,?) ";
		try {
			pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, itemMenu.getId_picture());
			pst.setInt(2, 1);
			pst.setInt(3, itemMenu.getId_type_Menu());
			pst.setInt(4, itemMenu.getId_Cost());
			pst.setString(5, itemMenu.getName());
			pst.setInt(6, itemMenu.getCount());
			pst.setInt(7, 1);
			pst.setString(8, itemMenu.getMota());
			pst.executeUpdate();
			ResultSet rsk = pst.getGeneratedKeys();

			while (rsk.next()) {
				result = rsk.getInt(1);
			}

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

	public MenuAdmin getMenuByID(int id) {
		MenuAdmin Item = null;
		
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM thucdon LEFT JOIN giatien ON thucdon.idThucDon = giatien.idThucDon LEFT JOIN anh ON thucdon.idAnh = anh.idAnh LEFT JOIN loaithucpham ON loaithucpham.idLoaiThucPham = thucdon.idLoaiThucPham WHERE thucdon.idQuan =1 && thucdon.idThucDon= ? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new MenuAdmin(rs.getInt("idThucDon"), rs.getInt("idAnh"), rs.getString("ten"),
						rs.getString("duongDan"), rs.getInt("idQuan"), rs.getInt("idLoaiThucPham"),
						rs.getString("tenLoaiThucPham"), rs.getInt("idGiaTien"), rs.getString("tenThucDon"),
						rs.getInt("soLuong"), rs.getFloat("giaTien"), rs.getInt("kieuCheBien"), rs.getString("moTa"));
			
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
		return Item;
	}

	public int editItem(MenuAdmin itemNewMenu) {
		int result = 0;
		conn = lb.getConnectMySQL();
		String query = "UPDATE thucdon SET idLoaiThucPham=?,tenThucDon=?,moTa =? WHERE idThucDon =?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, itemNewMenu.getId_type_Menu());
			pst.setString(2, itemNewMenu.getName());
			pst.setString(3, itemNewMenu.getMota());
			pst.setInt(4, itemNewMenu.getId_Menu());
			pst.executeUpdate();
			result =1;
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

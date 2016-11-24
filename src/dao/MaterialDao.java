package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Material;
import bean.Picture;
import libraryConnectDb.LibraryConnectDb;

public class MaterialDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Material> getList() {
		Material Item = null;
		ArrayList<Material> alItem = new ArrayList<Material>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  nguyenlieu LEFT JOIN donvitinh ON nguyenlieu.idDonViTinh = donvitinh.idDonViTinh LEFT JOIN "
				+ "anh ON nguyenlieu.idAnh = anh.idAnh  WHERE nguyenlieu.idQuan = 1";
		try {
			pst = conn.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Item = new Material(rs.getInt("idNguyenLieu"),rs.getInt("idAnh"),rs.getInt("idDonViTinh"),rs.getInt("idQuan"),rs.getString("tenNguyenLieu"),rs.getString("ghiChu"),rs.getString("ten"),rs.getString("tenDonViTinh"));
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
	

	public int addItem(Material Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO nguyenlieu(idAnh,idDonViTinh,idQuan,tenNguyenLieu,ghiChu) VALUES(?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_picture());
			pst.setInt(2, Item.getUnit());
			pst.setInt(3, Item.getId_shop());
			pst.setString(4, Item.getName());
			pst.setString(5, Item.getNote());
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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

	public int editItem(Material Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  nguyenlieu SET idAnh =? ,idDonViTinh =? ,idQuan = ?,tenNguyenLieu =? ,ghiChu =? WHERE idNguyenLieu =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_picture());
			pst.setInt(2, Item.getUnit());
			pst.setInt(3, Item.getId_shop());
			pst.setString(4, Item.getName());
			pst.setString(5, Item.getNote());
			pst.setInt(6, Item.getId_material());
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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

	public Material getItemByID(int Id) {
		Material objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM nguyenlieu WHERE idNguyenLieu = ?  LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =  new Material(rs.getInt("idNguyenLieu"),rs.getInt("idAnh"),rs.getInt("idDonViTinh"),rs.getInt("idQuan"),rs.getString("tenNguyenLieu"),rs.getString("ghiChu"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return objItem;
	}

	public int delItemByID(int id) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  nguyenlieu WHERE idNguyenLieu =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,id );
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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


	public ArrayList<Picture> getListPicture() {
		Picture Item = null;
		ArrayList<Picture> alItem = new ArrayList<Picture>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  anh WHERE idQuan =1 ";
				
		try {
			pst = conn.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Item = new Picture(rs.getInt("idAnh"),rs.getString("ten"), rs.getString("duongDan"), rs.getInt("idQuan"));
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

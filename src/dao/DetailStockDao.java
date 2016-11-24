package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DetailStock;
import libraryConnectDb.LibraryConnectDb;

public class DetailStockDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<DetailStock> getList() {
		DetailStock Item = null;
		ArrayList<DetailStock> alItem = new ArrayList<DetailStock>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  chitietkho  ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			pst.setInt(1, 1);
			while (rs.next()) {
				Item = new DetailStock(rs.getInt("id"),rs.getInt("idNhapHang"),rs.getInt("idNguyenLieu"),rs.getTimestamp("ngayNhapHang"),rs.getInt("soLuongConTrongKho"),rs.getInt("tinhTrangSuDung"));
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
	

	public int addItem(DetailStock Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO chitietkho(idNhapHang,idNguyenLieu,ngayHetHan,soLuongConTrongKho,tinhTrangSuDung) VALUES(?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_import());
			pst.setInt(2, Item.getMaterial());
			pst.setTimestamp(3, Item.getDate_expiration());
			pst.setInt(4, Item.getAmountOfStock());
			pst.setInt(5, Item.getUse_status());
			
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

	public int editItem(DetailStock Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  nhaphang SET idNhapHang = ?,idNguyenLieu =?,ngayHetHan =?,soLuongConTrongKho =?,tinhTrangSuDung =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_import());
			pst.setInt(2, Item.getMaterial());
			pst.setTimestamp(3, Item.getDate_expiration());
			pst.setInt(4, Item.getAmountOfStock());
			pst.setInt(5, Item.getUse_status());
			pst.setInt(6, Item.getId_import());
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

	public DetailStock getItemByID(int Id) {
		DetailStock objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM chitietkho WHERE id = ?  LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =   new DetailStock(rs.getInt("id"),rs.getInt("idNhapHang"),rs.getInt("idNguyenLieu"),rs.getTimestamp("ngayNhapHang"),rs.getInt("soLuongConTrongKho"),rs.getInt("tinhTrangSuDung"));
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
		String query = "DELETE FROM  chitietkho WHERE id =? LIMIT 1";
		
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

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.NgayTrongTuan;
import libraryConnectDb.LibraryConnectDb;

public class NgayTrongTuanDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<NgayTrongTuan> getListNgayTrongTuan() {
		NgayTrongTuan Item = null;
		ArrayList<NgayTrongTuan> alItem = new ArrayList<NgayTrongTuan>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM NgayTrongTuan ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new NgayTrongTuan(rs.getString("TenNgay"));
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

//	public int addNgayTrongTuan(NgayTrongTuan NgayTrongTuan) {
//		conn = lb.getConnectMySQL();
//		int result =0;
//		String query = "INSERT INTO NgayTrongTuan(idQuan,tenBan,trangThai) VALUES(?,?,?)";
//		
//		try {
//			pst = conn.prepareStatement(query);
//			pst.setInt(1,NgayTrongTuan.getId_coffee_shop() );
//			pst.setString(2,NgayTrongTuan.getName_NgayTrongTuan() );
//			pst.setInt(3,NgayTrongTuan.getStatus());
//			pst.executeUpdate();
//			result =1;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				pst.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//		return result;
//	}

//	public boolean editNgayTrongTuan(NgayTrongTuan NgayTrongTuan) {
//		conn = lb.getConnectMySQL();
//		boolean result = true;
//		String query = "UPDATE  NgayTrongTuan SET tenNgayTrongTuan =?, thoiGianBatDau =?, thoiGianKetThuc =? WHERE id =? LIMIT 1";
//		
//		try {
//			pst = conn.prepareStatement(query);
//			pst.setString(1,NgayTrongTuan.getTenNgayTrongTuan() );
//			pst.setString(2,NgayTrongTuan.getThoiGianBatDau());
//			pst.setString(3,NgayTrongTuan.getThoiGianKetThuc() );
//			pst.setInt(4, NgayTrongTuan.getIdQuan());
//			pst.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			result = false;
//		}finally{
//			try {
//				pst.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		return result;
//		
//	}

	public NgayTrongTuan getItemByID(int taId) {
		NgayTrongTuan objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM NgayTrongTuan WHERE id = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,taId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new NgayTrongTuan(rs.getString("TenNgay"));
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

//	public int delNgayTrongTuanByID(int tid) {
//		conn = lb.getConnectMySQL();
//		int result =0;
//		String query = "DELETE FROM  NgayTrongTuan WHERE id =? LIMIT 1";
//		try {
//			pst = conn.prepareStatement(query);
//			pst.setInt(1,tid );
//			pst.executeUpdate();
//			result =1;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				pst.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//		return result;
//	}

}

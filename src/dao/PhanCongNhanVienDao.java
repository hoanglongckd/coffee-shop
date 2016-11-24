package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PhanCongNhanVien;
import libraryConnectDb.LibraryConnectDb;

public class PhanCongNhanVienDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<PhanCongNhanVien> getListPhanCongNhanVien() {
		PhanCongNhanVien Item = null;
		ArrayList<PhanCongNhanVien> alItem = new ArrayList<PhanCongNhanVien>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM PhanCongNhanVien where 1 ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new PhanCongNhanVien(rs.getInt("id"),rs.getInt("idLichLamViec"),rs.getInt("idNhanVien"));
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

	public boolean addPhanCongNhanVien(PhanCongNhanVien PhanCongNhanVien) {
		conn = lb.getConnectMySQL();
		boolean result =true;
		String query = "INSERT INTO PhanCongNhanVien(idLichLamViec, idNhanVien) VALUES(?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,PhanCongNhanVien.getIdLichLamViec());
			pst.setInt(2,PhanCongNhanVien.getIdNhanVien());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			result = false;
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

	public boolean editPhanCongNhanVien(PhanCongNhanVien PhanCongNhanVien) {
		conn = lb.getConnectMySQL();
		boolean result = true;
		String query = "UPDATE  PhanCongNhanVien SET idLichLamViec =?, idNhanVien =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,PhanCongNhanVien.getIdLichLamViec() );
			pst.setInt(2,PhanCongNhanVien.getIdNhanVien());

			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
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

//	public PhanCongNhanVien getItemByID(int taId) {
//		PhanCongNhanVien objItem = null;
//		conn = lb.getConnectMySQL();
//		
//		String query = "SELECT * FROM PhanCongNhanVien WHERE id = ? LIMIT 1";
//		
//		try {
//			pst = conn.prepareStatement(query);
//			pst.setInt(1,taId );
//			rs = pst.executeQuery();
//			if(rs.next()){
//				objItem = new PhanCongNhanVien(rs.getInt("id"),rs.getString("tenPhanCongNhanVien"),
//						rs.getString("thoiGianKetThuc"),rs.getString("thoiGianBatDau"), rs.getInt("idQuan"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				rs.close();
//				pst.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		return objItem;
//	}

	public int delPhanCongNhanVienByID(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  PhanCongNhanVien WHERE Id =? LIMIT 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,tid );
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

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.LichLamViec;
import libraryConnectDb.LibraryConnectDb;

public class LichLamViecDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<LichLamViec> getListLichLamViec() {
		LichLamViec Item = null;
		ArrayList<LichLamViec> alItem = new ArrayList<LichLamViec>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM lichlamviec,calamviec where lichlamviec.Id = calamviec.IdCaLamViec ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new LichLamViec(rs.getInt("id"),rs.getInt("idCaLamViec"),rs.getString("TenCaLamViec"),
						rs.getString("TenNgay"),rs.getString("Date_time"), rs.getString("GhiChu"));
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

	public boolean addLichLamViec(LichLamViec LichLamViec) {
		conn = lb.getConnectMySQL();
		boolean result =true;
		String query = "INSERT INTO LichLamViec(idCaLamViec, TenNgay, Date_time, GhiChu) VALUES(?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,LichLamViec.getIdCaLamViec());
			pst.setString(2,LichLamViec.getTenNgay());
			pst.setString(3,LichLamViec.getDate());
			pst.setString(3,LichLamViec.getGhiChu());
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

	public boolean editLichLamViec(LichLamViec LichLamViec) {
		conn = lb.getConnectMySQL();
		boolean result = true;
		String query = "UPDATE  LichLamViec SET idCaLamViec =?, TenNgay =?, Date_time =?  GhiChu = ? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,LichLamViec.getIdCaLamViec() );
			pst.setString(2,LichLamViec.getTenNgay());
			pst.setString(3,LichLamViec.getDate() );
			pst.setString(4, LichLamViec.getGhiChu());
			pst.setInt(5,LichLamViec.getId() );

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

//	public LichLamViec getItemByID(int taId) {
//		LichLamViec objItem = null;
//		conn = lb.getConnectMySQL();
//		
//		String query = "SELECT * FROM LichLamViec WHERE id = ? LIMIT 1";
//		
//		try {
//			pst = conn.prepareStatement(query);
//			pst.setInt(1,taId );
//			rs = pst.executeQuery();
//			if(rs.next()){
//				objItem = new LichLamViec(rs.getInt("id"),rs.getString("tenLichLamViec"),
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

	public int delLichLamViecByID(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  LichLamViec WHERE Id =? LIMIT 1";
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

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CaLamViec;
import libraryConnectDb.LibraryConnectDb;

public class CaLamViecDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<CaLamViec> getListCaLamViec() {
		CaLamViec Item = null;
		ArrayList<CaLamViec> alItem = new ArrayList<CaLamViec>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM calamviec ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new CaLamViec(rs.getInt("id"),rs.getString("tenCaLamViec"),
						rs.getString("thoiGianKetThuc"),rs.getString("thoiGianBatDau"), rs.getInt("idQuan"));
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

//	public int addCaLamViec(CaLamViec CaLamViec) {
//		conn = lb.getConnectMySQL();
//		int result =0;
//		String query = "INSERT INTO CaLamViec(idQuan,tenBan,trangThai) VALUES(?,?,?)";
//		
//		try {
//			pst = conn.prepareStatement(query);
//			pst.setInt(1,CaLamViec.getId_coffee_shop() );
//			pst.setString(2,CaLamViec.getName_CaLamViec() );
//			pst.setInt(3,CaLamViec.getStatus());
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

	public boolean editCaLamViec(CaLamViec CaLamViec) {
		conn = lb.getConnectMySQL();
		boolean result = true;
		String query = "UPDATE  calamviec SET tenCaLamViec =?, thoiGianBatDau =?, thoiGianKetThuc =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,CaLamViec.getTenCaLamViec() );
			pst.setString(2,CaLamViec.getThoiGianBatDau());
			pst.setString(3,CaLamViec.getThoiGianKetThuc() );
			pst.setInt(4, CaLamViec.getIdQuan());
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

	public CaLamViec getItemByID(int taId) {
		CaLamViec objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM calamviec WHERE id = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,taId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new CaLamViec(rs.getInt("id"),rs.getString("tenCaLamViec"),
						rs.getString("thoiGianKetThuc"),rs.getString("thoiGianBatDau"), rs.getInt("idQuan"));
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

	public int delCaLamViecByID(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  calamviec WHERE id =? LIMIT 1";
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

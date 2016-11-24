package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.VangNghi;
import libraryConnectDb.LibraryConnectDb;

public class VangNghiDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<VangNghi> getListVangNghi() {
		VangNghi Item = null;
		ArrayList<VangNghi> alItem = new ArrayList<VangNghi>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM VangNghi ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new VangNghi(rs.getInt("idVangNghi"),rs.getInt("idNhanVien"),rs.getString("NgayVang"),
						rs.getString("GhiChu"));
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
	
	public ArrayList<VangNghi> getListVangNghi(int idQuan) {
		VangNghi Item = null;
		ArrayList<VangNghi> alItem = new ArrayList<VangNghi>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM VangNghi where idQuan ="+idQuan;
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new VangNghi(rs.getInt("idVangNghi"),rs.getInt("idNhanVien"),rs.getString("NgayVang"),
						rs.getString("GhiChu"));
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

	public boolean addVangNghi(VangNghi VangNghi) {
		conn = lb.getConnectMySQL();
		boolean result =true;
		String query = "INSERT INTO VangNghi(idNhanVien, NgayVang, GhiChu) VALUES(?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,VangNghi.getIdNhanVien());
			pst.setString(2,VangNghi.getNgayVang());
			pst.setString(3,VangNghi.getGhiChu());
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

//	public boolean editVangNghi(VangNghi VangNghi) {
//		conn = lb.getConnectMySQL();
//		boolean result = true;
//		String query = "UPDATE  VangNghi SET  NgayVang =? WHERE idVangNghi =? LIMIT 1";
//		
//		try {
//			pst = conn.prepareStatement(query);
//			pst.setString(1,VangNghi.getTen());
//			pst.setString(2,VangNghi.getDuongDan());
//			pst.setInt(3,VangNghi.getId() );
//
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

	public VangNghi getItemByID(int taId) {
		VangNghi objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM VangNghi WHERE idVangNghi = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,taId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new VangNghi(rs.getInt("idVangNghi"),rs.getInt("idNhanVien"),rs.getString("NgayVang"),
						rs.getString("GhiChu"));
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

	public int delVangNghiByID(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  VangNghi WHERE idVangNghi =? LIMIT 1";
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

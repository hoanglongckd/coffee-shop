package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Quan;
import libraryConnectDb.LibraryConnectDb;

public class QuanDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Quan> getListQuan() {
		Quan Item = null;
		ArrayList<Quan> alItem = new ArrayList<Quan>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM Quan ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Quan(rs.getInt("idQuan"),rs.getString("TenQuan"),rs.getString("DiaChi"),
						rs.getString("Sdt"),rs.getString("GhiChu"));
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

	public boolean addQuan(Quan Quan) {
		conn = lb.getConnectMySQL();
		boolean result =true;
		String query = "INSERT INTO Quan(TenQuan, DiaChi, Sdt, GhiChu) VALUES(?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,Quan.getTen());
			pst.setString(2,Quan.getDiaChi());
			pst.setString(3,Quan.getSdt());
			pst.setString(4,Quan.getGhiChu());
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

	public boolean editQuan(Quan Quan) {
		conn = lb.getConnectMySQL();
		boolean result = true;
		String query = "UPDATE  Quan SET TenQuan =?, DiaChi =?, Sdt =?  GhiChu = ? WHERE idQuan =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,Quan.getTen());
			pst.setString(2,Quan.getDiaChi());
			pst.setString(3,Quan.getSdt());
			pst.setString(4,Quan.getGhiChu());
			pst.setInt(5,Quan.getId() );

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

	public Quan getItemByID(int taId) {
		Quan objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM Quan WHERE idQuan = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,taId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Quan(rs.getInt("idQuan"),rs.getString("TenQuan"),rs.getString("DiaChi"),
						rs.getString("Sdt"),rs.getString("GhiChu"));
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

	public int delQuanByID(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  Quan WHERE idQuan =? LIMIT 1";
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

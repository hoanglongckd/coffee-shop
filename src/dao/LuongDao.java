package dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Luong;
import libraryConnectDb.LibraryConnectDb;

public class LuongDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Luong> getListLuong() {
		Luong Item = null;
		ArrayList<Luong> alItem = new ArrayList<Luong>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM Luong ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Luong(rs.getInt("idLuong"),rs.getInt("idNhanVien"),rs.getInt("soTien"));
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
	

	public boolean addLuong(Luong Luong) {
		conn = lb.getConnectMySQL();
		boolean result =true;
		String query = "INSERT INTO Luong(idNhanVien,soTien) VALUES(?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Luong.getIdNhanVien());
			pst.setInt(2,Luong.getLuong());
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

	public boolean editLuong(Luong Luong) {
		conn = lb.getConnectMySQL();
		boolean result = true;
		String query = "UPDATE  Luong SET soTien =? WHERE idLuong =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Luong.getLuong());
			pst.setInt(2,Luong.getIdLuong());

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

	public Luong getItemById(int taId) {
		Luong objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM Luong WHERE idLuong = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,taId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Luong(rs.getInt("idLuong"),rs.getInt("idNhanVien"),rs.getInt("soTien"));
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
	public Luong getItemByIdNhanVien(int idNhanVien) {
		Luong objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM Luong WHERE idNhanVien = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,idNhanVien );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Luong(rs.getInt("idLuong"),rs.getInt("idNhanVien"),rs.getInt("soTien"));
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
	public int delLuongById(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  Luong WHERE idLuong =? LIMIT 1";
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

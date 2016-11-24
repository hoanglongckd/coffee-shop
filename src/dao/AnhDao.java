package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Anh;
import libraryConnectDb.LibraryConnectDb;

public class AnhDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Anh> getListAnh() {
		Anh Item = null;
		ArrayList<Anh> alItem = new ArrayList<Anh>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM Anh ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Anh(rs.getInt("idAnh"),rs.getString("ten"),rs.getString("duongDan"),
						rs.getInt("idQuan"));
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
	
	public ArrayList<Anh> getListAnh(int idQuan) {
		Anh Item = null;
		ArrayList<Anh> alItem = new ArrayList<Anh>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM Anh where idQuan ="+idQuan;
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Anh(rs.getInt("idAnh"),rs.getString("ten"),rs.getString("duongDan"),
						rs.getInt("idQuan"));
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

	public boolean addAnh(Anh Anh) {
		conn = lb.getConnectMySQL();
		boolean result =true;
		String query = "INSERT INTO Anh(ten, duongDan, idQuan) VALUES(?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,Anh.getTen());
			pst.setString(2,Anh.getDuongDan());
			pst.setInt(3,Anh.getIdQuan());
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

	public boolean editAnh(Anh Anh) {
		conn = lb.getConnectMySQL();
		boolean result = true;
		String query = "UPDATE  Anh SET ten =?, duongDan =? WHERE idAnh =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,Anh.getTen());
			pst.setString(2,Anh.getDuongDan());
			pst.setInt(3,Anh.getId() );

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

	public Anh getItemByID(int taId) {
		Anh objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM anh WHERE idAnh = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,taId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Anh(rs.getInt("idAnh"),rs.getString("ten"),rs.getString("duongDan"),
						rs.getInt("idQuan"));
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

	public int delAnhByID(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  Anh WHERE idAnh =? LIMIT 1";
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

	public Anh getItemByName(String tenAnh) {
		Anh objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM Anh WHERE ten = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, tenAnh);
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Anh(rs.getInt("idAnh"),rs.getString("ten"),rs.getString("duongDan"),
						rs.getInt("idQuan"));
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

}

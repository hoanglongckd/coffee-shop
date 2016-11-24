package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Unit;
import libraryConnectDb.LibraryConnectDb;

public class UnitDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Unit> getList() {
		Unit Item = null;
		ArrayList<Unit> alItem = new ArrayList<Unit>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  donvitinh ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Unit(rs.getInt("idDonViTinh"), rs.getString("tenDonViTinh"));
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
	

	public int addItem(Unit Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO donvitinh(tenDonViTinh) VALUES(?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,Item.getName() );
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

	public int editItem(Unit Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  donvitinh SET tenDonViTinh= ? WHERE idDonViTinh =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1,Item.getName());
			pst.setInt(2, Item.getId_unit());
			
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

	public Unit getItemByID(int Id) {
		Unit objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM donvitinh WHERE idDonViTinh = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =  new Unit(rs.getInt("idDonViTinh"), rs.getString("tenDonViTinh"));
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
		String query = "DELETE FROM  donvitinh WHERE idDonViTinh =? LIMIT 1";
		
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

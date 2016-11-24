package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cost;
import libraryConnectDb.LibraryConnectDb;

public class CostDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Cost> getList() {
		Cost Item = null;
		ArrayList<Cost> alItem = new ArrayList<Cost>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM giatien ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Cost(rs.getInt("id"), rs.getInt("idThucDon"), rs.getFloat("giaTien"),rs.getTimestamp("NgayCapNhap"));
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
	

	public int addItem(Cost Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO giatien(idThucDon,giaTien,NgayCapNhat) VALUES(?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Item.getId_menu() );
			pst.setFloat(2, Item.getCost());
			pst.setTimestamp(3, Item.getDate_update());
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

	public int editItem(Cost Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  giatien SET idThucDon= ?,giaTien = ?,NgayCapNhat =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Item.getId_menu());
			pst.setFloat(2, Item.getCost());
			pst.setTimestamp(3, Item.getDate_update());
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

	public Cost getItemByID(int Id) {
		Cost objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM giatien WHERE idGiaTien = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Cost(rs.getInt("idGiaTien"), rs.getInt("idThucDon"), rs.getFloat("giaTien"),rs.getTimestamp("NgayCapNhap"));
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
		String query = "DELETE FROM  giatien WHERE id =? LIMIT 1";
		
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


	public Cost getItemByIdMenu(int id_menu) {
		Cost objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM giatien WHERE idThucDon = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,id_menu );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Cost(rs.getInt("idGiaTien"), rs.getInt("idThucDon"), rs.getFloat("giaTien"),rs.getTimestamp("NgayCapNhap"));
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

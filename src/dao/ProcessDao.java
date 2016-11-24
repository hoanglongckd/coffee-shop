package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Process;
import libraryConnectDb.LibraryConnectDb;

public class ProcessDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Process> getList() {
		Process Item = null;
		ArrayList<Process> alItem = new ArrayList<Process>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  chebien INNER JOIN thucdon ON chebien.idThucDon = thucdon.idThucDon INNER JOIN nguyenlieu ON chebien.idNguyenLieu = nguyenlieu.idNguyenLieu WHERE chebien.idQuan = 1 ";
		try {
			pst = conn.prepareStatement(query);
			
			rs = pst.executeQuery();
		
			while (rs.next()) {
				Item = new Process(rs.getInt("idCheBien"), rs.getInt("idNguyenLieu"),rs.getInt("idQuan"), rs.getInt("soLuong"), rs.getInt("idThucDon"),rs.getString("thucdon.tenThucDon"),rs.getString("nguyenlieu.tenNguyenLieu"));
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
	

	public int addItem(Process Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO chebien(idQuan,soLuong,idThucDon,idNguyenLieu) VALUES(?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setInt(4,Item.getId_material() );
			pst.setFloat(1, 1);
			pst.setInt(2, Item.getQuantity());
			pst.setInt(3, Item.getId_menu());
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

	public int editItem(Process Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  chebien SET idNguyenLieu= ?,idQuan = ?,soLuong =? ,idThucDon =? WHERE idCheBien =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Item.getId_material());
			pst.setInt(2, Item.getId_shop());
			pst.setInt(3, Item.getQuantity());
			pst.setInt(4, Item.getId_menu());
			pst.setInt(5, Item.getId());
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

	public Process getItemByID(int Id) {
		Process objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM chebien WHERE idCheBien = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Process(rs.getInt("idCheBien"), rs.getInt("idNguyenLieu"),rs.getInt("idQuan"), rs.getInt("soLuong"), rs.getInt("idThucDon"));
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
		String query = "DELETE FROM  chebien WHERE idCheBien =? LIMIT 1";
		
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

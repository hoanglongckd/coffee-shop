package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.MaterialsUseInDay;
import libraryConnectDb.LibraryConnectDb;

public class MaterialUseInDayDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<MaterialsUseInDay> getList() {
		MaterialsUseInDay Item = null;
		ArrayList<MaterialsUseInDay> alItem = new ArrayList<MaterialsUseInDay>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  nguyenlieutrongngay  ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			pst.setInt(1, 1);
			while (rs.next()) {
				Item = new MaterialsUseInDay(rs.getInt("id"),rs.getInt("idChiTietKho"),rs.getInt("soLuongDaBan"));
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
	

	public int addItem(MaterialsUseInDay Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO nguyenlieutrongngay(idChiTietKho,soLuongDaBan) VALUES(?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_DetailStock());
			pst.setInt(2, Item.getAcountSold());
		
			
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

	public int editItem(MaterialsUseInDay Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  nguyenlieutrongngay SET idChiTietKho =?,soLuongDaBan =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_DetailStock());
			pst.setInt(2, Item.getAcountSold());
			pst.setInt(3, Item.getId());
			
			
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

	public MaterialsUseInDay getItemByID(int Id) {
		MaterialsUseInDay objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM nguyenlieutrongngay WHERE id = ?  LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =   new MaterialsUseInDay(rs.getInt("id"),rs.getInt("idChiTietKho"),rs.getInt("soLuongDaBan"));
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
		String query = "DELETE FROM  nguyenlieutrongngay WHERE id =? LIMIT 1";
		
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

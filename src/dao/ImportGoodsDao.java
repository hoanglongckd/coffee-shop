package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ImportGoods;
import libraryConnectDb.LibraryConnectDb;

public class ImportGoodsDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<ImportGoods> getList() {
		ImportGoods Item = null;
		ArrayList<ImportGoods> alItem = new ArrayList<ImportGoods>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  nhaphang WHERE idQuan = ? ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			pst.setInt(1, 1);
			while (rs.next()) {
				Item = new ImportGoods(rs.getInt("id"),rs.getInt("idNguyenLieu"),rs.getInt("idNhanVien"),rs.getInt("idQuan"),rs.getInt("soLuong"), rs.getTimestamp("ngayNhapHang"), rs.getFloat("soTien"));
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
	

	public int addItem(ImportGoods Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO nhaphang(idNguyenLieu,idNhanVien,idQuan,soLuong,ngayNhapHang,soTien) VALUES(?,?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_material());
			pst.setInt(2, Item.getId_staff());
			pst.setInt(3, Item.getId_shop());
			pst.setInt(4, Item.getCount_goods());
			pst.setTimestamp(5, Item.getDate_import());
			pst.setFloat(6, Item.getCount_money());
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

	public int editItem(ImportGoods Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  nhaphang SET idNguyenLieu =?,idNhanVien =? ,idQuan =?,soLuong =?,ngayNhapHang =?,soTien =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_material());
			pst.setInt(2, Item.getId_staff());
			pst.setInt(3, Item.getId_shop());
			pst.setInt(4, Item.getCount_goods());
			pst.setTimestamp(5, Item.getDate_import());
			pst.setFloat(6, Item.getCount_money());
			pst.setInt(7, Item.getId_import());
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

	public ImportGoods getItemByID(int Id) {
		ImportGoods objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM nhaphang WHERE id = ?  LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =  new ImportGoods(rs.getInt("id"),rs.getInt("idNguyenLieu"),rs.getInt("idNhanVien"),rs.getInt("idQuan"),rs.getInt("soLuong"), rs.getTimestamp("ngayNhapHang"), rs.getFloat("soTien"));
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
		String query = "DELETE FROM  nhaphang WHERE id =? LIMIT 1";
		
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

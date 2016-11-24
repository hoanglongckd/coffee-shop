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
		String query = "SELECT * FROM  nhaphang INNER JOIN nguyenlieu ON nhaphang.idNguyenLieu = nguyenlieu.idNguyenLieu LEFT JOIN nhanvien ON nhanvien.idNhanVien = nhaphang.idNhanVien LEFT JOIN chitietkho ON chitietkho.idNhapHang = nhaphang.idNhapHang WHERE nhaphang.idQuan = 1 ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Item = new ImportGoods(rs.getInt("idNhapHang"),rs.getInt("idNguyenLieu"),rs.getString("tenNguyenLieu"),rs.getInt("idNhanVien"), rs.getString("tenNhanVien"),rs.getInt("idQuan"), rs.getInt("soLuong"), rs.getTimestamp("ngayNhapHang"), rs.getFloat("soTien"),rs.getTimestamp("ngayHetHan"), rs.getInt("tinhTrangSuDung"));
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
			pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, Item.getId_material());
			pst.setInt(2, Item.getId_staff());
			pst.setInt(3, Item.getId_shop());
			pst.setInt(4, Item.getCount_goods());
			pst.setTimestamp(5, Item.getDate_import());
			pst.setFloat(6, Item.getCount_money());
			pst.executeUpdate();
			ResultSet rsk = pst.getGeneratedKeys();
			while(rsk.next()){
				result = rsk.getInt(1);
			}
			
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
		String query = "UPDATE  nhaphang SET idNguyenLieu =?,idNhanVien =? ,idQuan =?,soLuong =?,ngayNhapHang =?,soTien =? WHERE idNhapHang =? LIMIT 1";
		
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
		
		String query = "SELECT * FROM  nhaphang INNER JOIN nguyenlieu ON nhaphang.idNguyenLieu = nguyenlieu.idNguyenLieu LEFT JOIN nhanvien ON nhanvien.idNhanVien = nhaphang.idNhanVien LEFT JOIN chitietkho ON chitietkho.idNhapHang = nhaphang.idNhapHang WHERE nhaphang.idQuan = 1 && nhaphang.idNhapHang =?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new ImportGoods(rs.getInt("idNhapHang"),rs.getInt("idNguyenLieu"),rs.getString("tenNguyenLieu"),rs.getInt("idNhanVien"), rs.getString("tenNhanVien"),rs.getInt("idQuan"), rs.getInt("soLuong"), rs.getTimestamp("ngayNhapHang"), rs.getFloat("soTien"),rs.getTimestamp("ngayHetHan"), rs.getInt("tinhTrangSuDung"));
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

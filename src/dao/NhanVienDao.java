package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.NhanVien;
import libraryConnectDb.LibraryConnectDb;

public class NhanVienDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<NhanVien> getListNhanVien() {
		NhanVien Item = null;
		ArrayList<NhanVien> alItem = new ArrayList<NhanVien>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM nhanvien ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new NhanVien(rs.getInt("idNhanVien"),rs.getString("duongDan"),rs.getString("tenQuan"),
						rs.getString("tenNhanVien"),rs.getString("ghiChu"));
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
	
	public ArrayList<NhanVien> getListNhanVienDetailByIdQuan(int i) {
		NhanVien Item = null;
		ArrayList<NhanVien> alItem = new ArrayList<NhanVien>();
		conn = lb.getConnectMySQL();
		String query = "SELECT nhanvien.idNhanVien,nhanvien.tenNhanVien, anh.duongDan,quan.tenQuan,nhanvien.ghiChu "
				+ "FROM nhanvien, anh, quan "
				+ "Where nhanvien.idAnh = anh.idAnh and nhanvien.idQuan = quan.idQuan and quan.idQuan ="+i+""
						+ " order BY nhanvien.idNhanVien DESC";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new NhanVien(rs.getInt("idNhanVien"),rs.getString("duongDan"),rs.getString("tenQuan"),
						rs.getString("tenNhanVien"),rs.getString("ghiChu"));
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

	public boolean addNhanVien(NhanVien NhanVien) {
		conn = lb.getConnectMySQL();
		boolean result =true;
		String query = "INSERT INTO nhanvien(idAnh, idQuan, tenNhanVien, ghiChu) VALUES(?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,NhanVien.getIdAnh());
			pst.setInt(2,NhanVien.getIdQuan());
			pst.setString(3,NhanVien.getTen());
			pst.setString(4,NhanVien.getGhiChu());
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

	public boolean editNhanVien(NhanVien NhanVien) {
		conn = lb.getConnectMySQL();
		boolean result = true;
		String query = "UPDATE  NhanVien SET idAnh =?, idQuan =?, tenNhanVien =?,  ghiChu = ? WHERE idNhanVien =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,NhanVien.getIdAnh() );
			pst.setInt(2,NhanVien.getIdQuan());
			pst.setString(3,NhanVien.getTen());
			pst.setString(4, NhanVien.getGhiChu());
			pst.setInt(5,NhanVien.getId() );

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

	public NhanVien getItemByID(int taId) {
		NhanVien objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM NhanVien WHERE idNhanVien = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,taId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new NhanVien(rs.getInt("idNhanVien"),rs.getInt("idAnh"),rs.getInt("idQuan"),
						rs.getString("tenNhanVien"),rs.getString("ghiChu"));
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

	public int delNhanVienById(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  NhanVien WHERE idNhanVien =? LIMIT 1";
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

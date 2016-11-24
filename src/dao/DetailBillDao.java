package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DetailBill;
import libraryConnectDb.LibraryConnectDb;

public class DetailBillDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<DetailBill> getList() {
		DetailBill Item = null;
		ArrayList<DetailBill> alItem = new ArrayList<DetailBill>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  chitiethoadon  ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Item = new DetailBill(rs.getInt("id"),rs.getInt("idHoaDon"),rs.getInt("idThucDon"),rs.getInt("soLuong"), rs.getFloat("soTien"),rs.getInt("trangThaiPhucVu"));
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
	

	public int addItem(DetailBill Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO chitiethoadon(idHoaDon,idThucDon,soLuong,soTien,trangThaiPhucVu) VALUES(?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_bill());
			System.out.println("thu "+Item.getId_bill());
			pst.setInt(2, Item.getId_menu());
			pst.setInt(3, Item.getCount_menu());
			pst.setFloat(4, Item.getCount_money());
			pst.setInt(5, Item.getStatus_serve());
			
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

	public int editItem(DetailBill Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  nhaphang SET idHoaDon =?,idThucDon =?,soLuong = ?,soTien =? ,trangThaiPhucVu =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_bill());
			pst.setInt(2, Item.getId_menu());
			pst.setInt(3, Item.getCount_menu());
			pst.setFloat(4, Item.getCount_money());
			pst.setInt(5, Item.getStatus_serve());
			pst.setFloat(6, Item.getCount_money());
			pst.setInt(7, Item.getId_detail());
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

	public DetailBill getItemByID(int Id) {
		DetailBill objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM chitiethoadon WHERE id = ?  LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =   new DetailBill(rs.getInt("id"),rs.getInt("idHoaDon"),rs.getInt("idThucDon"),rs.getInt("soLuong"), rs.getFloat("soTien"),rs.getInt("trangThaiPhucVu"));
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
		String query = "DELETE FROM  chitiethoadon WHERE id =? LIMIT 1";
		
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


	public ArrayList<DetailBill> getOrderByIdBill(int idBill) {
		DetailBill Item = null;
		ArrayList<DetailBill> alItem = new ArrayList<DetailBill>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  chitiethoadon INNER JOIN giatien ON chitiethoadon.idThucDon = giatien.idThucDon  WHERE idHoaDon =?  ";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, idBill);
			rs = pst.executeQuery();
			System.out.println(query);
			while (rs.next()) {
				Item = new DetailBill(rs.getInt("idChiTietHoaDon"),rs.getInt("idHoaDon"),rs.getInt("idThucDon"),rs.getInt("soLuong"), rs.getFloat("soTien"),rs.getInt("trangThaiPhucVu"),rs.getFloat("giaTien"));
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


	public float getSumMoney(int idBill) {
		conn = lb.getConnectMySQL();
		float money =0;
		String query = "SELECT sum(soTien) AS total FROM  chitiethoadon WHERE idHoaDon =? ";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,idBill );
			rs = pst.executeQuery();
			while(rs.next()){
				money += rs.getInt("total");
				System.out.println("i"+money);
			}
			System.out.println(money);
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
		
		return money;
	}

}

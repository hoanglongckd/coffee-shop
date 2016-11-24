package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Bill;
import libraryConnectDb.LibraryConnectDb;

public class BillDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Bill> getList() {
		Bill Item = null;
		ArrayList<Bill> alItem = new ArrayList<Bill>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM  hoadon ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Bill(rs.getInt("idHoaDon"),rs.getInt("idNhanVien"),rs.getInt("idBan"),rs.getInt("trangThaiThanhToan"),rs.getTimestamp("ngayLapHoaDon"),rs.getString("ghiChu"));
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
	public static void main(String[] args) {
		BillDao Item = new BillDao();
		ArrayList<Bill> al = new ArrayList<>();
		al = Item.getList();
		for(Bill i : al){
			System.out.println(i.getId_table());
		}
	}

	public int addItem(Bill Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO hoadon(idNhanVien,idban,trangThaiThanhToan,ngayLapHoaDon,ghiChu,tongTien) VALUES(?,?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, Item.getId_staff());
			pst.setInt(2, Item.getId_table());
			pst.setInt(3, Item.getStatus_pay());
			pst.setTimestamp(4, Item.getDate_single_up());
			pst.setString(5, Item.getNote());
			pst.setFloat(6, Item.getSumMoney());
			pst.executeUpdate();
			ResultSet rsk = pst.getGeneratedKeys();
			while(rsk.next()){
				result = rsk.getInt(1);
				System.err.println("a"+result);
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

	public int editItem(Bill Item) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  hoadon SET idNhanVien =?,idban =? ,trangThaiThanhToan = ?,ngayLapHoaDon =? ,ghiChu =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, Item.getId_staff());
			pst.setInt(2, Item.getId_table());
			pst.setInt(3, Item.getStatus_pay());
			pst.setTimestamp(4, Item.getDate_single_up());
			pst.setString(5, Item.getNote());
			pst.setInt(6, Item.getId_bill());
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

	public Bill getItemByID(int Id) {
		Bill objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM hoadon WHERE id = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,Id );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem =  new Bill(rs.getInt("idHoaDon"),rs.getInt("idNhanVien"),rs.getInt("idBan"),rs.getInt("trangThaiThanhToan"),rs.getTimestamp("ngayLapHoaDon"),rs.getString("ghiChu"));
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
		String query = "DELETE FROM  hoadon WHERE id =? LIMIT 1";
		
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
	public Bill getItemByIdTable(int idTable) {
		conn = lb.getConnectMySQL();
		Bill Item  = null;
		String query = "SELECT * FROM hoadon WHERE idBan = ? && trangThaiThanhToan =? ";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,idTable );
			pst.setInt(2, 0);
			rs = pst.executeQuery();
			if(rs.next()){
				Item = new Bill(rs.getInt("idHoaDon"),rs.getInt("idNhanVien"),rs.getInt("idBan"),rs.getInt("trangThaiThanhToan"),rs.getFloat("tongTien"),rs.getTimestamp("ngayLapHoaDon"),rs.getString("ghiChu"));
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
		return Item;
	}
	public void setStatusPay(int id) {
		conn = lb.getConnectMySQL();
		String query = "UPDATE  hoadon SET  trangThaiThanhToan = ? WHERE idHoaDon =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, 1);
			pst.setInt(2, id);
			
			pst.executeUpdate();
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
		
		
		
	}
	public void setSumMoney(int idBill, float money) {
		conn = lb.getConnectMySQL();
		String query = "UPDATE  hoadon SET  tongTien= ? WHERE idHoaDon =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setFloat(1, money);
			pst.setInt(2, idBill);
			
			pst.executeUpdate();
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
		
	}
	public int getIbBillByIDTable(int idTable) {
		conn = lb.getConnectMySQL();
		int result   = 0;
		String query = "SELECT * FROM hoadon WHERE idBan = ? && trangThaiThanhToan =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,idTable );
			pst.setInt(2, 0);
			rs = pst.executeQuery();
			if(rs.next()){
				result = rs.getInt("idHoaDon");
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
		return result;
	}

}

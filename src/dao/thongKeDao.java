package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ThongkeBean;
import libraryConnectDb.LibraryConnectDb;

public class thongKeDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public  ArrayList<ThongkeBean> alItem(String year, String month) {
		ThongkeBean Item = null;
		ArrayList<ThongkeBean> alItem = new ArrayList<ThongkeBean>();
		conn = lb.getConnectMySQL();
		String query = "select * from ("
				+ " select thucdon.idThucDon, thucdon.tenThucDon AS ten1, sum(nhaphang.soTien) as fee, "
				+ " sum(nhaphang.soLuong) as slNhap from thucdon"
				+ " join nhaphang on thucdon.idThucDon = nhaphang.idThucDon"
				+ " where YEAR(nhaphang.ngayNhapHang) = ? and MONTH(nhaphang.ngayNhapHang) = ?"
				+ " group by (thucdon.idThucDon)" + " ) as a" + " left join ("
				+ " select thucdon.idThucDon, thucdon.tenThucDon AS ten2, sum(chitiethoadon.soTien) as profit, "
				+ " sum(chitiethoadon.soLuong) as slBan from thucdon" + " join chitiethoadon"
				+ " on thucdon.idThucDon = chitiethoadon.idThucDon" + " join hoadon"
				+ " on chitiethoadon.idHoaDon = hoadon.idHoaDon"
				+ " where YEAR(hoadon.ngayLapHoaDon) = ? and MONTH(hoadon.ngayLapHoaDon) = ?"
				+ " group by (thucdon.idThucDon)" + " ) as b" + " on a.idThucDon = b.idThucDon" + " union all"
				+ " select * from (" + " select thucdon.idThucDon, thucdon.tenThucDon AS ten1, sum(nhaphang.soTien) as fee, "
				+ " sum(nhaphang.soLuong) as slNhap from thucdon" + " join nhaphang"
				+ " on thucdon.idThucDon = nhaphang.idThucDon"
				+ " where YEAR(nhaphang.ngayNhapHang) = ? and MONTH(nhaphang.ngayNhapHang) = ?"
				+ " group by (thucdon.idThucDon)" + " ) as a" + " right join ("
				+ " select thucdon.idThucDon, thucdon.tenThucDon AS ten2, sum(chitiethoadon.soTien) as profit, "
				+ " sum(chitiethoadon.soLuong) as slBan from thucdon" + " join chitiethoadon"
				+ " on thucdon.idThucDon = chitiethoadon.idThucDon" + " join hoadon"
				+ " on chitiethoadon.idHoaDon = hoadon.idHoaDon"
				+ " where YEAR(hoadon.ngayLapHoaDon) = ? and MONTH(hoadon.ngayLapHoaDon) = ?"
				+ " group by (thucdon.idThucDon)" + " ) as b" + " on a.idThucDon = b.idThucDon";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, year);
			pst.setString(2, month);
			pst.setString(3, year);
			pst.setString(4, month);
			pst.setString(5, year);
			pst.setString(6, month);
			pst.setString(7, year);
			pst.setString(8, month);
			rs = pst.executeQuery();
			while (rs.next()) {
				if(rs.getString("ten1")!=null){
					ThongkeBean item = new ThongkeBean(rs.getString("ten1"), rs.getLong("fee"), rs.getInt("slNhap"),rs.getLong("profit"), rs.getInt("slBan"));
					alItem.add(item);
				}else{
					ThongkeBean item = new ThongkeBean(rs.getString("ten2"), rs.getLong("fee"), rs.getInt("slNhap"),rs.getLong("profit"), rs.getInt("slBan"));
					alItem.add(item);
				}
				
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
	
	public  ArrayList<ThongkeBean> getListThongKeByNam(String year) {
		ThongkeBean Item = null;
		ArrayList<ThongkeBean> alItem = new ArrayList<ThongkeBean>();
		conn = lb.getConnectMySQL();
		String query = "select * from ("
				+ " select thucdon.idThucDon, thucdon.tenThucDon AS ten1, sum(nhaphang.soTien) as fee, "
				+ " sum(nhaphang.soLuong) as slNhap from thucdon"
				+ " join nhaphang on thucdon.idThucDon = nhaphang.idThucDon"
				+ " where YEAR(nhaphang.ngayNhapHang) = ? "
				+ " group by (thucdon.idThucDon)" + " ) as a" + " left join ("
				+ " select thucdon.idThucDon, thucdon.tenThucDon AS ten2, sum(chitiethoadon.soTien) as profit, "
				+ " sum(chitiethoadon.soLuong) as slBan from thucdon" + " join chitiethoadon"
				+ " on thucdon.idThucDon = chitiethoadon.idThucDon" + " join hoadon"
				+ " on chitiethoadon.idHoaDon = hoadon.idHoaDon"
				+ " where YEAR(hoadon.ngayLapHoaDon) = ? "
				+ " group by (thucdon.idThucDon)" + " ) as b" + " on a.idThucDon = b.idThucDon" + " union all"
				+ " select * from (" + " select thucdon.idThucDon, thucdon.tenThucDon AS ten1, sum(nhaphang.soTien) as fee, "
				+ " sum(nhaphang.soLuong) as slNhap from thucdon" + " join nhaphang"
				+ " on thucdon.idThucDon = nhaphang.idThucDon"
				+ " where YEAR(nhaphang.ngayNhapHang) = ? "
				+ " group by (thucdon.idThucDon)" + " ) as a" + " right join ("
				+ " select thucdon.idThucDon, thucdon.tenThucDon AS ten2, sum(chitiethoadon.soTien) as profit, "
				+ " sum(chitiethoadon.soLuong) as slBan from thucdon" + " join chitiethoadon"
				+ " on thucdon.idThucDon = chitiethoadon.idThucDon" + " join hoadon"
				+ " on chitiethoadon.idHoaDon = hoadon.idHoaDon"
				+ " where YEAR(hoadon.ngayLapHoaDon) = ? "
				+ " group by (thucdon.idThucDon)" + " ) as b" + " on a.idThucDon = b.idThucDon";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, year);
			pst.setString(2, year);
			pst.setString(3, year);
			pst.setString(4, year);
			rs = pst.executeQuery();
			while (rs.next()) {
				if(rs.getString("ten1")!=null){
					ThongkeBean item = new ThongkeBean(rs.getString("ten1"), rs.getLong("fee"), rs.getInt("slNhap"),rs.getLong("profit"), rs.getInt("slBan"));
					alItem.add(item);
				}else{
					ThongkeBean item = new ThongkeBean(rs.getString("ten2"), rs.getLong("fee"), rs.getInt("slNhap"),rs.getLong("profit"), rs.getInt("slBan"));
					alItem.add(item);
				}
				
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
	thongKeDao item = new thongKeDao();
	for(ThongkeBean i : item.alItem("2016", "11")){
		System.out.println("d "+i.getProfit());
	}
}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import bean.Table;
import libraryConnectDb.LibraryConnectDb;

public class TableDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	LibraryConnectDb lb = new LibraryConnectDb();

	public ArrayList<Table> getListTable() {
		Table Item = null;
		ArrayList<Table> alItem = new ArrayList<Table>();
		conn = lb.getConnectMySQL();
		String query = "SELECT * FROM ban ";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				Item = new Table(rs.getInt("idBan"),rs.getInt("idQuan"),rs.getString("tenBan"), rs.getInt("trangThai"));
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

	public int addTable(Table table) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "INSERT INTO ban(idQuan,tenBan,trangThai) VALUES(?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,table.getId_coffee_shop() );
			pst.setString(2,table.getName_table() );
			pst.setInt(3,table.getStatus());
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

	public int editTable(Table table) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "UPDATE  ban SET idQuan =?, tenBan =?,trangThai =? WHERE id =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,table.getId_coffee_shop() );
			pst.setString(2,table.getName_table() );
			pst.setInt(3,table.getStatus() );
			pst.setInt(4, table.getId_table());
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

	public Table getItemByID(int taId) {
		Table objItem = null;
		conn = lb.getConnectMySQL();
		
		String query = "SELECT * FROM ban WHERE id = ? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,taId );
			rs = pst.executeQuery();
			if(rs.next()){
				objItem = new Table(taId, rs.getInt("idQuan"), rs.getString("tenBan"), rs.getInt("trangThai"));
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

	public int delTableByID(int tid) {
		conn = lb.getConnectMySQL();
		int result =0;
		String query = "DELETE FROM  ban WHERE id =? LIMIT 1";
		
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

	public void setStatusTable(int idTable, int status) {
		conn = lb.getConnectMySQL();
		String query = "UPDATE  ban SET  trangThai =? WHERE idBan =? LIMIT 1";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,status );
			pst.setInt(2,idTable );
			
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

	public boolean getStatusTable(int idTable) {
		conn = lb.getConnectMySQL();
		boolean result = true;
		String query = "SELECT *FROM  ban WHERE idBan =? ";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1,idTable);
			rs = pst.executeQuery();
			while(rs.next()){
				if(rs.getInt("trangThai")==1){
					result = false;
					System.err.println("b"+result);
					break;
				}
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

}

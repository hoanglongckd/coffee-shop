package bo;

import java.util.ArrayList;

import bean.Table;
import dao.TableDao;



public class TableBo {
	TableDao  tabledao   = new TableDao();
	public ArrayList<Table> getListTable() {
		return tabledao.getListTable();
	}

	public int addItem(Table table) {
		return tabledao.addTable(table);
	}
	public int editItem(Table table) {
		return tabledao.editTable(table);
	}

	public Table getItemById(int taId) {
		
		return tabledao.getItemByID(taId);
	}

	public int delItem(int tid) {
		return tabledao.delTableByID(tid);
	}

	public void setStatusTable(int idTable, int status) {
		 tabledao.setStatusTable(idTable,status);
		
	}

	public  boolean getStatusTable(int idTable) {
		return tabledao.getStatusTable(idTable);
	}

	
}

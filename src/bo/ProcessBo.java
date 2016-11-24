package bo;

import java.util.ArrayList;

import bean.Process;
import dao.ProcessDao;



public class ProcessBo {
	ProcessDao  itemDao   = new ProcessDao();
	public ArrayList<Process> getList() {
		return itemDao.getList();
	}

	public int addItem(Process Item) {
		return itemDao.addItem(Item);
	}
	public int editItem(Process Item) {
		return itemDao.editItem(Item);
	}

	public Process getItemById(int Id) {
		
		return itemDao.getItemByID(Id);
	}

	public int delItem(int id) {
		return itemDao.delItemByID(id);
	}

	
}

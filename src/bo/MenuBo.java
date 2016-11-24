package bo;

import java.util.ArrayList;

import bean.Menu;
import dao.MenuDao;

public class MenuBo {
	MenuDao menuDao = new MenuDao();

	public ArrayList<Menu> getListMenu() {
		return menuDao.getListMenu();
	}
	public ArrayList<Menu> getList() {
		return menuDao.getList();
	}
}

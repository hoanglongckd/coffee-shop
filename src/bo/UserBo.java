package bo;

import bean.User;
import dao.UserDao;

public class UserBo {
	UserDao userDao = new UserDao();

	public User CheckLogin(String username, String password) {
		return userDao.checkLogin(username, password);
	}

	public void setItemInStatus(int id_user) {
		 userDao.setItemStatus(id_user);
		
	}

	public User getItemByIdNhanVien(int idNhanVien) {
		return userDao.getItemByIdNhanVien(idNhanVien);
	}

	public boolean editItem(User user) {
		return userDao.editUser(user);		
	}

	public boolean addItem(User user) {
		return userDao.addUser(user);
	}
	public boolean checkExistUsername(String username, int idNhanVien){
		return userDao.checkExistUsername(username,idNhanVien);
	}
}

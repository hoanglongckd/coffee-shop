package beanAdmin;

import java.util.ArrayList;

import bean.LoginedAccount;
import bean.User;

public class ForLoginApp {

	public boolean checkLoginApp(LoginedAccount loginAcount, ArrayList<LoginedAccount> al, User Item) {
		boolean result = true;
		for (LoginedAccount login : al) {
			if (login.getId_user() == Item.getId_user()) {
				result = false;
			} else {
				result = true;
			}
		}
		return result;

	}

}

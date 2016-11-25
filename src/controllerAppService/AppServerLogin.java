package controllerAppService;

import java.util.ArrayList;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.LoginedAccount;
import bean.PrimitiveType;
import bean.User;
import beanAdmin.ForLoginApp;
import bo.UserBo;

@Path("/serverApp")
public class AppServerLogin {
	private static final LoginedAccount LoginedAccount = null;
	static ArrayList<LoginedAccount> alCheck = new ArrayList<LoginedAccount>();
	UserBo userBo = new UserBo();

	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_XML)
	public Response Login(@QueryParam("username") String username, @QueryParam("password") String password) {
		// boolean check = userBo.CheckLogin(username, password);
		PrimitiveType<String> result = new PrimitiveType<>();
		ForLoginApp ItemCheck = new ForLoginApp();
		User Item = userBo.CheckLogin(username, password);
		if (Item != null) {
			if (!alCheck.isEmpty()) {
				boolean check = ItemCheck.checkLoginApp(LoginedAccount, alCheck, Item);
				if (check == false) {
					alCheck.remove(LoginedAccount);
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					alCheck.add(new LoginedAccount(Item.getId_NV(), username, uuid, Item.getId_NV()));
					result.setValue(uuid);
				} else {
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					alCheck.add(new LoginedAccount(Item.getId_NV(), username, uuid, Item.getId_NV()));
					result.setValue(uuid);
				}

			} else {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				alCheck.add(new LoginedAccount(Item.getId_NV(), username, uuid, Item.getId_NV()));
				result.setValue(uuid);
			}
		} else {
			result.setValue("false");
		}
		return Response.status(200).entity(result).build();
	}

	public static ArrayList<LoginedAccount> getListLoginedAccounts() {
		return alCheck;
	}
}
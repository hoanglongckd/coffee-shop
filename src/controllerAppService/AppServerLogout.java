package controllerAppService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.LoginedAccount;
import bean.PrimitiveType;
import bo.UserBo;

@Path("/serverApp")
public class AppServerLogout {

	UserBo userBo = new UserBo();

	@GET
	@Path("/logout")
	@Produces(MediaType.APPLICATION_XML)
	public Response Login(@QueryParam("username") String username, @QueryParam("key") String key) {
		// boolean check = userBo.CheckLogin(username, password);
		PrimitiveType<Integer> result = new PrimitiveType<>();
//chay coi hey
		ArrayList<LoginedAccount> listLoginedAccounts = AppServerLogin.getListLoginedAccounts();
		if (!listLoginedAccounts.isEmpty()) {
			for (LoginedAccount loginedAccount : listLoginedAccounts) {
				if (username.equals(loginedAccount.getUsername()) && key.equals(loginedAccount.getKey())) {
					result.setValue(1);
					System.out.println("v3");
					listLoginedAccounts.remove(loginedAccount);
					break;
				} else {
					
					result.setValue(0);
					
				}
			}
		} else {
			
			result.setValue(0);
		}
		return Response.status(200).entity(result).build();
	}

}

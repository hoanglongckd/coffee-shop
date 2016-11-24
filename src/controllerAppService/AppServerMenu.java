package controllerAppService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.ListMenuType;
import bean.LoginedAccount;
import bean.Menu;
import bo.MenuBo;

@Path("/serverMenu")
public class AppServerMenu {

	MenuBo menuBo = new MenuBo();	

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public Response getListTable(@QueryParam("key") String key) {
		ListMenuType<List<Menu>> result = new ListMenuType<>();
		ArrayList<LoginedAccount> listLoginedAccounts = AppServerLogin.getListLoginedAccounts();
		if(!listLoginedAccounts.isEmpty()){
			for (LoginedAccount loginedAccount : listLoginedAccounts) {
				if(key.equals(loginedAccount.getKey())){
					
					List<Menu> menuList = menuBo.getListMenu();
					result.setValue(menuList);
					break;
				}else{
					
					result.setValue(null);
				}
			}
		}else{
			
			result.setValue(null);
		}
		return Response.status(200).entity(result).build();

	}
	

}

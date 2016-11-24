package controllerAppService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.ListTableType;
import bean.LoginedAccount;
import bean.Table;
import bo.TableBo;

@Path("/serverTable")
public class AppServerTable {

	TableBo taBo = new TableBo();
	
	

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)

	public Response getListTable(@QueryParam("key") String key) {
		ListTableType<List<Table>> result = new ListTableType<>();
		ArrayList<LoginedAccount> listLoginedAccounts = AppServerLogin.getListLoginedAccounts();
		if(!listLoginedAccounts.isEmpty()){
			for (LoginedAccount loginedAccount : listLoginedAccounts) {
				if(key.equals(loginedAccount.getKey())){
					
					List<Table> tableList = taBo.getListTable();
					result.setValue(tableList);
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
	
	
	

//	@POST
//	@Path("/addTable")
//	@Consumes(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_XML)
//	public Response addPlace(Table Item) {
//		PrimitiveType<Integer> result = new PrimitiveType<>();
//		int xm = taBo.addItem(Item);
//		result.setValue(xm);
//		
//		return Response.status(200).entity(result).build();//just test
//	}
	
}

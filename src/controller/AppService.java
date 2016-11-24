package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.Cat;
import bean.Table;
import bo.TableBo;

@Path("/server")
public class AppService {

	TableBo taBo = new TableBo();

	@POST
	@Path("/param")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response postMsg(Cat objCat) {
		String output = "POST:Jersey say : " + objCat.getName();
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/listTable")
	@Produces(MediaType.APPLICATION_XML)

	public ArrayList<Table> getListTable() {

		return taBo.getListTable();

	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void login(@FormParam("username") String username,
		      @FormParam("password") String password,
		      @Context HttpServletResponse servletResponse) {
		System.out.println(username);
		System.out.println(password);
//		String output = "POST:Jersey say : " + objCat.getName();
//		return Response.status(200).entity(output).build();
	}

//	@POST
//	@Path("/addTable")
//	@Consumes(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_XML)
//	public Response addPlace(Table Item) {
//		 Table result = taBo.addItem(Item);
//		return Response.status(200).entity(result).build();//just test
//	}
	// @GET
	// @Path("/listMenu")
	// @Produces(MediaType.APPLICATION_JSON)
	// public ArrayList<Table> getListMenu() {
	//
	// return taBo.getListMenu();
	//
	// }
}

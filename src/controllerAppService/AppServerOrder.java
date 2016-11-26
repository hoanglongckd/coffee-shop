package controllerAppService;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.Bill;
import bean.DetailBill;
import bean.LoginedAccount;
import bean.Order;
import bean.OrderList;
import bean.PrimitiveType;
import bo.BillBo;
import bo.CostBo;
import bo.DetailBillBo;
import bo.DetailStockBo;
import bo.OrderBo;
import bo.StockBo;
import bo.TableBo;

@Path("/serverOrder")
public class AppServerOrder {
	OrderBo orderBo = new OrderBo();
	BillBo billBo = new BillBo();
	DetailBillBo detailBillBo = new DetailBillBo();
	TableBo tableBo = new TableBo();
	CostBo costBo = new CostBo();

	DetailStockBo detaiStockBo = new DetailStockBo();
	StockBo stickBo = new StockBo();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Order> getList() {
		return orderBo.getList();
	}

	@POST
	@Path("/Menu")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response orderMenu(OrderList Item) {
		ArrayList<LoginedAccount> listLoginedAccounts = AppServerLogin.getListLoginedAccounts();
		PrimitiveType<Integer> result = new PrimitiveType<>();
		if (!listLoginedAccounts.isEmpty()) {
			for (LoginedAccount loginedAccount : listLoginedAccounts) {
				if (Item.getKey().equals(loginedAccount.getKey())) {

					if (tableBo.getStatusTable(Item.getIdTable()) == true) {
						int idBill = billBo.addItem(new Bill(Item.getIdTable(), loginedAccount.getIdStaff()));
						tableBo.setStatusTable(Item.getIdTable(), 1);

						for (Order order : Item.getOrders()) {
							float money = costBo.getItemByIdMenu(order.getId_menu()).getCost() * order.getCount_menu();
							detailBillBo.addItem(
									new DetailBill(0, idBill, order.getId_menu(), order.getCount_menu(), money, 0));
							boolean checkIdMenu = detaiStockBo.checkIdMenuByID(order.getId_menu());
							if (checkIdMenu == true) {
								int res1 = detaiStockBo.getAcountGoodByIDMenu(order.getId_menu());
								if (res1 > 0) {
									detaiStockBo.setAcountGoodByID(order.getId_menu(), (res1 - order.getCount_menu()));
									boolean checkStocIdMenu = stickBo.getItemByIdMaterial(order.getId_menu());
									if (checkStocIdMenu == true) {
										int countStock = stickBo.getQuality(order.getId_menu());
										stickBo.setQualityByIDMaterial(order.getId_menu(),
												countStock - order.getCount_menu());
									}
								}
							}
						}
						float money = detailBillBo.getSumMoney(idBill);
						billBo.setSumMoney(idBill, money);
						result.setValue(1);
						break;
					} else {
						int idBill = billBo.getIbBillByIDTable(Item.getIdTable());

						for (Order order : Item.getOrders()) {
							float money = costBo.getItemByIdMenu(order.getId_menu()).getCost() * order.getCount_menu();
							detailBillBo.addItem(
									new DetailBill(0, idBill, order.getId_menu(), order.getCount_menu(), money, 0));
							boolean checkIdMenu = detaiStockBo.checkIdMenuByID(order.getId_menu());
							System.out.println("te1" + checkIdMenu);
							if (checkIdMenu == true) {
								int res1 = detaiStockBo.getAcountGoodByIDMenu(order.getId_menu());
								if (res1 > 0) {
									detaiStockBo.setAcountGoodByID(order.getId_menu(), (res1 - order.getCount_menu()));
									boolean checkStocIdMenu = stickBo.getItemByIdMaterial(order.getId_menu());
									if (checkStocIdMenu == true) {
										int countStock = stickBo.getQuality(order.getId_menu());
										stickBo.setQualityByIDMaterial(order.getId_menu(),
												countStock - order.getCount_menu());
									}
								}
							}
						}
						float money = detailBillBo.getSumMoney(idBill);
						billBo.setSumMoney(idBill, money);
						result.setValue(1);
						break;
					}
				} else {
					result.setValue(0);
				}
			}
		} else {
			result.setValue(0);
		}

		return Response.status(200).entity(result).build();// just test
	}

}

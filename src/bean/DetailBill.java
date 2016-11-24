package bean;

public class DetailBill {
	private int id_detail;
	private int id_bill;
	private int id_menu;
	private int count_menu;
	private float count_money;
	private int status_serve;
	private float cost_menu;
	public int getId_detail() {
		return id_detail;
	}
	public void setId_detail(int id_detail) {
		this.id_detail = id_detail;
	}
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}
	public int getCount_menu() {
		return count_menu;
	}
	public void setCount_menu(int count_menu) {
		this.count_menu = count_menu;
	}
	public float getCount_money() {
		return count_money;
	}
	public void setCount_money(float count_money) {
		this.count_money = count_money;
	}
	public int getStatus_serve() {
		return status_serve;
	}
	public void setStatus_serve(int status_serve) {
		this.status_serve = status_serve;
	}
	
	public float getCost_menu() {
		return cost_menu;
	}
	public void setCost_menu(float cost_menu) {
		this.cost_menu = cost_menu;
	}
	public DetailBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailBill(int id_detail, int id_bill, int id_menu, int count_menu, float count_money, int status_serve) {
		super();
		this.id_detail = id_detail;
		this.id_bill = id_bill;
		this.id_menu = id_menu;
		this.count_menu = count_menu;
		this.count_money = count_money;
		this.status_serve = status_serve;
	}
	public DetailBill(int id_bill, int id_menu, int count_menu) {
		super();
		this.id_bill = id_bill;
		this.id_menu = id_menu;
		this.count_menu = count_menu;
	}
	public DetailBill(int id_detail, int id_bill, int id_menu, int count_menu, float count_money, int status_serve,
			float cost_menu) {
		super();
		this.id_detail = id_detail;
		this.id_bill = id_bill;
		this.id_menu = id_menu;
		this.count_menu = count_menu;
		this.count_money = count_money;
		this.status_serve = status_serve;
		this.cost_menu = cost_menu;
	}
	
	

}

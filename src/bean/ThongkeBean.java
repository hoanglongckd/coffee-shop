package bean;

public class ThongkeBean {
	private String name_menu;
	private long fee;
	private int slnhap;
	private long profit;
	private int slBan;
	public ThongkeBean(String name_menu, long fee, int slnhap, long profit, int slBan) {
		super();
		this.name_menu = name_menu;
		this.fee = fee;
		this.slnhap = slnhap;
		this.profit = profit;
		this.slBan = slBan;
	}
	public String getName_menu() {
		return name_menu;
	}
	public void setName_menu(String name_menu) {
		this.name_menu = name_menu;
	}
	public long getFee() {
		return fee;
	}
	public void setFee(long fee) {
		this.fee = fee;
	}
	public int getSlnhap() {
		return slnhap;
	}
	public void setSlnhap(int slnhap) {
		this.slnhap = slnhap;
	}
	public long getProfit() {
		return profit;
	}
	public void setProfit(long profit) {
		this.profit = profit;
	}
	public int getSlBan() {
		return slBan;
	}
	public void setSlBan(int slBan) {
		this.slBan = slBan;
	}
	
	
	

}

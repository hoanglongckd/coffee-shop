package bean;

public class Stock {
	private int id_stock;
	private int id_material;
	private int id_shop;
	private int totalNumber;
	private String name_material;
	public int getId_stock() {
		return id_stock;
	}
	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}
	public int getId_material() {
		return id_material;
	}
	public void setId_material(int id_material) {
		this.id_material = id_material;
	}
	public int getId_shop() {
		return id_shop;
	}
	public void setId_shop(int id_shop) {
		this.id_shop = id_shop;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	public String getName_material() {
		return name_material;
	}
	public void setName_material(String name_material) {
		this.name_material = name_material;
	}
	public Stock(int id_stock, int id_material, int id_shop, int totalNumber) {
		super();
		this.id_stock = id_stock;
		this.id_material = id_material;
		this.id_shop = id_shop;
		this.totalNumber = totalNumber;
	}
	
	public Stock(int id_stock, int id_material, int id_shop, int totalNumber, String name_material) {
		super();
		this.id_stock = id_stock;
		this.id_material = id_material;
		this.id_shop = id_shop;
		this.totalNumber = totalNumber;
		this.name_material = name_material;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

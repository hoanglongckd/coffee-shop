package bean;

public class Process {
	private int id;
	private int id_menu;
	private int id_material;
	private int id_shop;
	private int quantity;
	private String name_menu;
	private String name_material;
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName_menu() {
		return name_menu;
	}
	public void setName_menu(String name_menu) {
		this.name_menu = name_menu;
	}
	public String getName_material() {
		return name_material;
	}
	public void setName_material(String name_material) {
		this.name_material = name_material;
	}
	public Process(int id, int id_menu, int id_material, int id_shop, int quantity) {
		super();
		this.id = id;
		this.id_menu = id_menu;
		this.id_material = id_material;
		this.id_shop = id_shop;
		this.quantity = quantity;
	}
	
	public Process(int id, int id_menu, int id_material, int id_shop, int quantity, String name_menu,
			String name_material) {
		super();
		this.id = id;
		this.id_menu = id_menu;
		this.id_material = id_material;
		this.id_shop = id_shop;
		this.quantity = quantity;
		this.name_menu = name_menu;
		this.name_material = name_material;
	}
	public Process() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

package beanAdmin;

public class MenuAdmin {
	private int id_Menu;
	private int id_picture;
	private String name_pictute;
	private String link;
	private int id_Shop;
	private int id_type_Menu;
	private String name_type_menu;
	private  int id_Cost;
	private String name;
	private int count;
	private float price;
	private  int kieuchebien;
	private  String  mota;
	public int getId_Menu() {
		return id_Menu;
	}
	public void setId_Menu(int id_Menu) {
		this.id_Menu = id_Menu;
	}
	public int getId_picture() {
		return id_picture;
	}
	public void setId_picture(int id_picture) {
		this.id_picture = id_picture;
	}
	public String getName_pictute() {
		return name_pictute;
	}
	public void setName_pictute(String name_pictute) {
		this.name_pictute = name_pictute;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getId_Shop() {
		return id_Shop;
	}
	public void setId_Shop(int id_Shop) {
		this.id_Shop = id_Shop;
	}
	public int getId_type_Menu() {
		return id_type_Menu;
	}
	public void setId_type_Menu(int id_type_Menu) {
		this.id_type_Menu = id_type_Menu;
	}
	public int getId_Cost() {
		return id_Cost;
	}
	public void setId_Cost(int id_Cost) {
		this.id_Cost = id_Cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getKieuchebien() {
		return kieuchebien;
	}
	public void setKieuchebien(int kieuchebien) {
		this.kieuchebien = kieuchebien;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	

	public String getName_type_menu() {
		return name_type_menu;
	}
	public void setName_type_menu(String name_type_menu) {
		this.name_type_menu = name_type_menu;
	}
	public MenuAdmin(int id_Menu, int id_picture, String name_pictute, String link, int id_Shop, int id_type_Menu,
			String name_type_menu, int id_Cost, String name, int count, float price, int kieuchebien, String mota) {
		super();
		this.id_Menu = id_Menu;
		this.id_picture = id_picture;
		this.name_pictute = name_pictute;
		this.link = link;
		this.id_Shop = id_Shop;
		this.id_type_Menu = id_type_Menu;
		this.name_type_menu = name_type_menu;
		this.id_Cost = id_Cost;
		this.name = name;
		this.count = count;
		this.price = price;
		this.kieuchebien = kieuchebien;
		this.mota = mota;
	}
	public MenuAdmin(int id_Menu, int id_picture, int id_Shop, int id_type_Menu, int id_Cost, String name, int count,
			int kieuchebien, String mota) {
		super();
		this.id_Menu = id_Menu;
		this.id_picture = id_picture;
		this.id_Shop = id_Shop;
		this.id_type_Menu = id_type_Menu;
		this.id_Cost = id_Cost;
		this.name = name;
		this.count = count;
		this.kieuchebien = kieuchebien;
		this.mota = mota;
	}
	
	
}

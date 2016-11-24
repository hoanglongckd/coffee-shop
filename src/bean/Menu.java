package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "menu")
public class Menu {
	private int id_Menu;
	private int id_picture;
	private String name_pictute;
	private String link;
	//private int id_Shop;
	//private int id_type_Menu;
	//private  int id_Cost;
	private String name;
	private int count;
	private float price;
	//private  int kieuchebien;
	//private  int mota;
	public int getId_Menu() {
		return id_Menu;
	}
	
	@XmlElement
	public void setId_Menu(int id_Menu) {
		this.id_Menu = id_Menu;
	}

	
	public int getId_picture() {
		return id_picture;
	}
	@XmlElement
	public void setId_picture(int id_picture) {
		this.id_picture = id_picture;
	}
	
	
//	public int getId_Shop() {
//		return id_Shop;
//	}
//	
//	public void setId_Shop(int id_Shop) {
//		this.id_Shop = id_Shop;
//	}
//	
//	public int getId_type_Menu() {
//		return id_type_Menu;
//	}
//	@XmlElement
//	public void setId_type_Menu(int id_type_Menu) {
//		this.id_type_Menu = id_type_Menu;
//	}
//	public int getId_Cost() {
//		return id_Cost;
//	}
//	
//	public void setId_Cost(int id_Cost) {
//		this.id_Cost = id_Cost;
//	}
//	public int getKieuchebien() {
//		return kieuchebien;
//	}
//	
//	public void setKieuchebien(int kieuchebien) {
//		this.kieuchebien = kieuchebien;
//	}
//	public int getMota() {
//		return mota;
//	}
//	
//	public void setMota(int mota) {
//		this.mota = mota;
//	}
//	
	
	

	public float getPrice() {
		return price;
	}

	public Menu(int id_Menu, int id_picture, String name_pictute, String link, String name, int count, float price) {
	super();
	this.id_Menu = id_Menu;
	this.id_picture = id_picture;
	this.name_pictute = name_pictute;
	this.link = link;
	this.name = name;
	this.count = count;
	this.price = price;
}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName_pictute() {
		return name_pictute;
	}
	@XmlElement
	public void setName_pictute(String name_pictute) {
		this.name_pictute = name_pictute;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	@XmlElement
	public void setCount(int count) {
		this.count = count;
	}
	public Menu(int id_Menu, int id_picture, String name_pictute, String name, int count) {
		this.id_Menu = id_Menu;
		this.id_picture = id_picture;
		this.name_pictute = name_pictute;
		this.name = name;
		this.count = count;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int id_Menu, String name) {
		super();
		this.id_Menu = id_Menu;
		this.name = name;
	}
	

}

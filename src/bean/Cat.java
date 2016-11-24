package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public class Cat {
	private int id_cat;
	private String name;
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_cat() {
		return id_cat;
	}
	@XmlElement
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public Cat(int id_cat, String name) {
		super();
		this.id_cat = id_cat;
		this.name = name;
	}
	
}


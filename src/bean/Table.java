package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Table {
	private int id_table;
	private int id_coffee_shop;
	private String name_table;
	private int status;

	public int getId_table() {
		return id_table;
	}

	@XmlElement
	public void setId_table(int id_table) {
		this.id_table = id_table;
	}

	public int getId_coffee_shop() {
		return id_coffee_shop;
	}
	@XmlElement
	public void setId_coffee_shop(int id_coffee_shop) {
		this.id_coffee_shop = id_coffee_shop;
	}

	public String getName_table() {
		return name_table;
	}
	@XmlElement
	public void setName_table(String name_table) {
		this.name_table = name_table;
	}

	public int getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(int status) {
		this.status = status;
	}

	public Table(int id_table, int id_coffee_shop, String name_table, int status) {
		super();
		this.id_table = id_table;
		this.id_coffee_shop = id_coffee_shop;
		this.name_table = name_table;
		this.status = status;
	}

	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Table [id_table=" + id_table + ", id_coffee_shop=" + id_coffee_shop + ", name_table=" + name_table
				+ ", status=" + status + "]";
	}

}

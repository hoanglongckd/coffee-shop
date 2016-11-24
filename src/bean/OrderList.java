package bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
public class OrderList {
	private List<Order> orders;

	private int idTable;
	private String key;
	

	public int getIdTable() {
		return idTable;
	}
	@XmlElement
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public String getKey() {
		return key;
	}
	@XmlElement
	public void setKey(String key) {
		this.key = key;
	}
	public List<Order> getOrders() {
		return orders;
	}

	@XmlElement
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}

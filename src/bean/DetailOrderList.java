package bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
public class DetailOrderList {
	private List<DetailBill> detaiBill;
	
	private float sumMoney;

	public List<DetailBill> getDetaiBill() {
		return detaiBill;
	}
	@XmlElement
	public void setDetaiBill(List<DetailBill> detaiBill) {
		this.detaiBill = detaiBill;
	}

	public float getSumMoney() {
		return sumMoney;
	}
	@XmlElement
	public void setSumMoney(float sumMoney) {
		this.sumMoney = sumMoney;
	}
	
	public DetailOrderList() {}
	
	public DetailOrderList(List<DetailBill> arrayList, float sumMoney) {
		super();
		this.detaiBill = arrayList;
		this.sumMoney = sumMoney;
	}
	
	
}

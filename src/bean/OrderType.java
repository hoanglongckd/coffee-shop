package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class OrderType<T> {
	private DetailOrderList value;

	public DetailOrderList getValue() {
		return value;
	}
	
	@XmlElement
	public void setValue(DetailOrderList detaiOrderList) {
		this.value = detaiOrderList;
	}

}

package bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "arrTable")
public class ListMenuType<T> {
	private List<Menu> value;

	public List<Menu> getValue() {
		return value;
	}
	
	@XmlElement
	public void setValue(List<Menu> tableList) {
		this.value = tableList;
	}

}

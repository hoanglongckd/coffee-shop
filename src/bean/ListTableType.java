package bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "arrTable")
public class ListTableType<T> {
	private List<Table> value;

	public List<Table> getValue() {
		return value;
	}
	
	@XmlElement
	public void setValue(List<Table> tableList) {
		this.value = tableList;
	}

	public ListTableType() {
		super();
		// TODO Auto-generated constructor stub
	}

}

package bean;

public class TypeMenu {
	private int idType;
	private String nameType;
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getNameType() {
		return nameType;
	}
	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	public TypeMenu(int idType, String nameType) {
		super();
		this.idType = idType;
		this.nameType = nameType;
	}
	

}

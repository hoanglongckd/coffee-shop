package bean;

public class Picture {
	private int idPicture;
	private String name;
	private String link;
	private int idShop;
	public int getIdPicture() {
		return idPicture;
	}
	public void setIdPicture(int idPicture) {
		this.idPicture = idPicture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getIdShop() {
		return idShop;
	}
	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}
	public Picture(int idPicture, String name, String link, int idShop) {
		super();
		this.idPicture = idPicture;
		this.name = name;
		this.link = link;
		this.idShop = idShop;
	}
	

}

package bean;

public class MaterialsUseInDay {
	private int id;
	private int id_DetailStock;
	private int acountSold;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_DetailStock() {
		return id_DetailStock;
	}
	public void setId_DetailStock(int id_DetailStock) {
		this.id_DetailStock = id_DetailStock;
	}
	public int getAcountSold() {
		return acountSold;
	}
	public void setAcountSold(int acountSold) {
		this.acountSold = acountSold;
	}
	public MaterialsUseInDay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MaterialsUseInDay(int id, int id_DetailStock, int acountSold) {
		super();
		this.id = id;
		this.id_DetailStock = id_DetailStock;
		this.acountSold = acountSold;
	}
	
	
	

}

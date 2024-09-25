package food;

public class SnackBackDTO {
	int num;
	String foodname ;
	int price;
	int amount;
	int pricetot;
	String id;
	
	public SnackBackDTO() {
		
	}
	
	public SnackBackDTO(int num) {
		super();
		this.num = num;
	}
	
	public SnackBackDTO(int num, String foodname, int price, int amount, int pricetot) {
		super();
		this.num = num;
		this.foodname = foodname;
		this.price = price;
		this.amount = amount;
		this.pricetot = pricetot;
	}
	
	public SnackBackDTO(int num, String foodname, int price, int amount, int pricetot, String id) {
		super();
		this.num = num;
		this.foodname = foodname;
		this.price = price;
		this.amount = amount;
		this.pricetot = pricetot;
		this.id = id;
	}


	@Override
	public String toString() {
		String str = String.format("%s  %s개",foodname,amount);
		return str;
	}
	


	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPricetot() {
		return pricetot;
	}
	public void setPricetot(int pricetot) {
		this.pricetot = pricetot;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	

}

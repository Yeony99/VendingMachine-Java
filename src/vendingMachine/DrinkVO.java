package vendingMachine;

public class DrinkVO {
	
	private String drinkName;
	private int drinkPrice;
	private int count; // 음료재고
	private int soldCount;// 팔린개수

	public DrinkVO() {
		
		this.soldCount=0;
	}

	

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSoldCount() {
		return soldCount;
	}

	public void setSoldCount(int soldCount) {
		this.soldCount = soldCount;
	}
}

package vendingMachine;

public class VendingVO {

	private int money; // 자판기 안에있는 천원짜리 지폐 개수
	private int coin5; // 500원짜리 개수
	private int coin1; // 100원짜리 개수
	

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getCoin5() {
		return coin5;
	}

	public void setCoin5(int coin5) {
		this.coin5 = coin5;
	}

	public int getCoin1() {
		return coin1;
	}

	public void setCoin1(int coin1) {
		this.coin1 = coin1;
	}


}

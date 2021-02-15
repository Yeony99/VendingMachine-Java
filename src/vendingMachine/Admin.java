package vendingMachine;

public interface Admin {
	// 동전입금
	public void deposit(int coin1, int coin5);

	// 지폐출금
	public void withdraw(int money);

	// 지폐잔액조회
	public void showMoney(int money);

	// 거스름돈 수량확인
	public void showCoins(int coin5, int coin1);

	// 매출 관리 함수
	public void salesInfo();

	
	
	// 관리자 비밀번호 맞는지 확인
	public boolean isRightPassword(String password);

	//음료 채우기 
	public void addDrink();
	
	//음료 삭제
	public void deleteDrink(String drinkNum);
	
	//음료 정보 변경
	public void changeDrink(String drinkName);
}

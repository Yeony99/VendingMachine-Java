package vendingMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

//관리자가 하는일 -돈
//동전입금, 지폐출금, 동전재고, 지폐재고, 판매현황
public class AdminImplMoney implements Admin {
	Scanner sc = new Scanner(System.in);

	private TransactionVO[] transactionList;// 거래내역
	private int totalTransaction = 0;
	private VendingVO v;
	private String password = "admin";
	
	Vending vv = new Vending();
	DrinkVO drink=new DrinkVO();


	public AdminImplMoney(VendingVO v) {
		allocation(50);
		this.v = v;
	}

	private void allocation(int capacity) {
		TransactionVO[] temp = new TransactionVO[capacity];
		if (transactionList != null && transactionList.length > 0) {
			System.arraycopy(transactionList, 0, temp, 0, transactionList.length);
		}
		transactionList = temp;
	}

	//거래내역
	public TransactionVO[] getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(TransactionVO[] transactionList) {
		this.transactionList = transactionList;
	}

	public boolean addTransaction(TransactionVO vo) {
		// 거래 내역 등록
		if (totalTransaction >= transactionList.length) {
			allocation(transactionList.length + 50);
		}

		transactionList[totalTransaction++] = vo;

		return true;
	}

	@Override // 동전입금
	public void deposit(int coin1, int coin5) {
		try {
			System.out.println("100원짜리 동전의 개수를 입력하세요.");
			int n = sc.nextInt();
			coin1 += n;
			System.out.println("500원짜리 동전의 개수를 입력하세요.");
			int m = sc.nextInt();
			coin5 += m;

			v.setCoin1(coin1);
			v.setCoin5(coin5);
			System.out.println("입금 완료");
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력 가능합니다.");
		}

	}

	@Override // 지폐출금
	public void withdraw(int money) {
		if (money > v.getMoney()) {
			System.out.println("입력 범위 초과로 출금할 수 없습니다");
			return;
		}
		money = v.getMoney() - money;
		v.setMoney(money);
		System.out.println("출금 완료");
	}

	@Override // 지폐잔액조회
	public void showMoney(int money) {
		System.out.printf("%d원입니다.\n", money * 1000);
	}

	@Override // 거스름돈 수량확인
	public void showCoins( int coin1,int coin5) {

		System.out.println("500원: " + coin5 + "개, 100원: " + coin1 + "개");
	}

	@Override // 매출 관리 함수
	public void salesInfo() {
		int totalSoldCount = 0;
		int totalMoney = 0;
		if (totalTransaction == 0) {
			System.out.println("거래 내역이 없습니다");
			return;
		}
		for (int i = 0; i < totalTransaction; i++) {
			System.out.println(transactionList[i]);
			totalSoldCount += transactionList[i].getDrinkCount();
			totalMoney += transactionList[i].getTotalMoney();
		}
		System.out.println("총 팔린 음료 개수: " + totalSoldCount);
		System.out.println("총 매출액: " + totalMoney);

	}

	@Override // 비밀번호가 admin이 맞는지 체크하는것
	public boolean isRightPassword(String password) {
		if(password.equals(this.password)) {
			return true;
		}
		return false;
	}

	//implement Drink에 해당하는 항목
	@Override
	public void addDrink() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDrink(String drinkNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeDrink(String drinkName) {
		// TODO Auto-generated method stub
		
	}

}

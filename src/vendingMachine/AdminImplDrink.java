package vendingMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

//관리자-음료
public class AdminImplDrink implements Admin {
	Scanner sc = new Scanner(System.in);
	private Vending v;
	private String password = "admin";

	public AdminImplDrink(Vending v) {

		this.v = v;
	}

	@Override
	public void deposit(int coin1, int coin5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void withdraw(int money) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showMoney(int money) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showCoins(int coin5, int coin1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void salesInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isRightPassword(String password) {
		if (password.equals(this.password)) {
			return true;
		}
		return false;

	}

	@Override
	public void addDrink() {
		try {
			DrinkVO drink = new DrinkVO();
			System.out.println("음료이름을 입력하세요.");
			drink.setDrinkName(sc.next());
			System.out.println("음료가격을 입력하세요.");
			drink.setDrinkPrice(sc.nextInt());
			System.out.println("음료 개수를 입력하세요.");
			drink.setCount(sc.nextInt());
			v.addDrink(drink);

		} catch (InputMismatchException e) {
			System.out.println("입력 형식이 틀립니다.");
		}

	}

	@Override
	public void deleteDrink(String drinkName) {
		DrinkVO vo = loadDrinkName(drinkName);
		if (vo == null) {
			System.out.println("등록된 음료가 없습니다");
			return;
		}
		int index=0;
		DrinkVO[] list=v.getDrinkList();
		
		for(int i=0;i<v.getTotalDrink();i++) {
			if(v.getDrinkList()[i].getDrinkName().equals(drinkName)) {
				index=i;
				break;
			}
		}
		for(int i=index;i<v.getTotalDrink()-1;i++) {
			list[i]=list[i+1];
		}
		list[v.getTotalDrink()-1]=null;
		v.setTotalDrink(v.getTotalDrink()-1);
		System.out.println("삭제가 완료되었습니다");

	}

	@Override
	public void changeDrink(String drinkName) {
		DrinkVO drink;
		drink = loadDrinkName(drinkName);
		if (drink == null) {
			System.out.println("등록된 음료가 없습니다");
			return;
		} else {
			System.out.print("음료 이름을 입력하세요.");
			drink.setDrinkName(sc.next());
			System.out.print("음료 가격을 입력하세요");
			drink.setDrinkPrice(sc.nextInt());
			System.out.println("음료 개수를 입력하세요");
			drink.setCount(sc.nextInt());

			System.out.println(drink.getDrinkName() + "로 성공적으로 수정되었습니다.");
		}

	}

	public DrinkVO loadDrinkName(String drinkName) {
		DrinkVO vo = null;
		for (int i = 0; i < v.getTotalDrink(); i++) {
			DrinkVO vv = v.getDrinkList()[i];
			if (vv.getDrinkName().equals(drinkName)) {
				vo = vv;
				break;
			}
		}

		return vo;

	}

}

package vendingMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

//�����ڰ� �ϴ��� -��
//�����Ա�, �������, �������, �������, �Ǹ���Ȳ
public class AdminImplMoney implements Admin {
	Scanner sc = new Scanner(System.in);

	private TransactionVO[] transactionList;// �ŷ�����
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

	//�ŷ�����
	public TransactionVO[] getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(TransactionVO[] transactionList) {
		this.transactionList = transactionList;
	}

	public boolean addTransaction(TransactionVO vo) {
		// �ŷ� ���� ���
		if (totalTransaction >= transactionList.length) {
			allocation(transactionList.length + 50);
		}

		transactionList[totalTransaction++] = vo;

		return true;
	}

	@Override // �����Ա�
	public void deposit(int coin1, int coin5) {
		try {
			System.out.println("100��¥�� ������ ������ �Է��ϼ���.");
			int n = sc.nextInt();
			coin1 += n;
			System.out.println("500��¥�� ������ ������ �Է��ϼ���.");
			int m = sc.nextInt();
			coin5 += m;

			v.setCoin1(coin1);
			v.setCoin5(coin5);
			System.out.println("�Ա� �Ϸ�");
		} catch (InputMismatchException e) {
			System.out.println("���ڸ� �Է� �����մϴ�.");
		}

	}

	@Override // �������
	public void withdraw(int money) {
		if (money > v.getMoney()) {
			System.out.println("�Է� ���� �ʰ��� ����� �� �����ϴ�");
			return;
		}
		money = v.getMoney() - money;
		v.setMoney(money);
		System.out.println("��� �Ϸ�");
	}

	@Override // �����ܾ���ȸ
	public void showMoney(int money) {
		System.out.printf("%d���Դϴ�.\n", money * 1000);
	}

	@Override // �Ž����� ����Ȯ��
	public void showCoins( int coin1,int coin5) {

		System.out.println("500��: " + coin5 + "��, 100��: " + coin1 + "��");
	}

	@Override // ���� ���� �Լ�
	public void salesInfo() {
		int totalSoldCount = 0;
		int totalMoney = 0;
		if (totalTransaction == 0) {
			System.out.println("�ŷ� ������ �����ϴ�");
			return;
		}
		for (int i = 0; i < totalTransaction; i++) {
			System.out.println(transactionList[i]);
			totalSoldCount += transactionList[i].getDrinkCount();
			totalMoney += transactionList[i].getTotalMoney();
		}
		System.out.println("�� �ȸ� ���� ����: " + totalSoldCount);
		System.out.println("�� �����: " + totalMoney);

	}

	@Override // ��й�ȣ�� admin�� �´��� üũ�ϴ°�
	public boolean isRightPassword(String password) {
		if(password.equals(this.password)) {
			return true;
		}
		return false;
	}

	//implement Drink�� �ش��ϴ� �׸�
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

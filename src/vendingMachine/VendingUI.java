package vendingMachine;

import java.util.Scanner;

public class VendingUI {

	Vending v = new Vending();// ���Ǳ�
	VendingVO v1=v.getVendingVO();
	Admin ad = new AdminImplMoney(v1);// ������
	Admin ad2=new AdminImplDrink(v);
	User user = new User();
	private Scanner sc = new Scanner(System.in);

	public void menu() {
		int ch;
		String password;
		while (true) {
			do {
				System.out.println("1. �����ڸ��  2.����ڸ�� 3.����");
			ch = sc.nextInt();
			}while(ch<1||ch>3);
			
			if(ch==3)
				break;
			if (ch == 1) {
				System.out.println("��й�ȣ �Է��ϼ���");
				password = sc.next();
				boolean check = ad2.isRightPassword(password);
				if (check == false) {
					System.out.println("��й�ȣ�� Ʋ���ϴ�");
					continue;
				}
				while (true) {
					do {
						System.out.println("-----------------------------------------------------------------");
						System.out.println("1.�����Ա�  2.�������  3.�����ܾ���ȸ  4.��������Ȯ��  5.�������  6.������� 7.����");
						System.out.println("------------------------------------------------------------------");
						System.out.print("����=> ");
						ch = sc.nextInt();
					} while (ch < 1 || ch > 7);

					if (ch == 7) {
						break;
					}

					switch (ch) {
					case 1:
						deposit();
						break;
					case 2:
						withdraw();
						break;
					case 3:
						showMoney();
						break;
					case 4:
						showCoins();
						break;
					case 5:
						drinkInfo();
						break;
					case 6:
						salesInfo();
						break;

					}
				}

			}

			else if (ch == 2) {
				while (true) {
					do {
						System.out.println("-----------------------------------------------------");
						System.out.println("1.�������� 2.����");
						System.out.println("-----------------------------------------------------");
						System.out.print("����=> ");
						ch = sc.nextInt();
					} while (ch < 1 || ch > 2);

					if (ch == 2) {
						break;
					}

					int money;
					do {
						System.out.println("���� ���� õ�������� �Է��ϼ���(�ִ� ����)");
						money = sc.nextInt();
					} while (money % 1000 != 0 || money>10000 ||money<1000);

					user.deposit(v1, money);// ���Ǳ⿡ ���ֱ�
					DrinkVO[] list = user.selectDrink(v, v1,(AdminImplMoney) ad, money);// ���ἱ��. �ֹ�����Ʈ��ȯ
					if (list[0].getDrinkName().equals("�ֹ��Ұ�")) {
						System.out.println("�ֹ��� �Ұ��մϴ� �����Ͻ� ���� �ٽ� ��ȯ�մϴ�");
						v1.setMoney(v1.getMoney() - money / 1000);
						break;
					}

					v.drinkOut(list, money, user ,v1);

				}
			}
		}

	}

	public void deposit() {
		// �����Ա�-> ���� ������ ���� ���ǱⰡ ���� ������ ������ ������Ű��
		int coin1=v1.getCoin1();
		int coin5=v1.getCoin5();
		ad.deposit(coin1, coin5);

	}

	public void withdraw() {
		// �������-> ���ǱⰡ ���� ���� money�� ���ҽ�Ű��
		int money;
		do {
			System.out.println("����� �ݾ��� õ�������� �Է��ϼ��� ex)4000, 100000");
			money = sc.nextInt();

		} while (money % 1000 != 0);

		ad.withdraw(money / 1000);
	}

	public void showMoney() {
		// �����ܾ���ȸ-> getter�� ���Ǳ��� money�� �ҷ�����
		
		ad.showMoney(v1.getMoney());
	}

	public void showCoins() {
		// ��������Ȯ��-> getter�� ���Ǳ��� coin1, coin5�� �ҷ�����
		ad.showCoins(v1.getCoin1(), v1.getCoin5());
	}

	public void drinkInfo() {
		// �������-> getter�� ���Ǳ��� ���Ḯ��Ʈ�� �ҷ�����
		String input;
		System.out.println("���� �߰�:add, ���� ����:delete, ���� ���� update ,���� ��� Ȯ���Ϸ��� �ƹ��ų� �Է��ϼ���");
		input = sc.next();
		if (input.equals("add")) {
			// ������ ����� ������� �Լ��� �θ���.
			ad2.addDrink();
		}
		else if(input.equals("delete")) {
			System.out.println("������ ���� �̸��� �Է��ϼ���");
			ad2.deleteDrink(sc.next());
		}
		else if(input.equals("update")) {
			System.out.println("������ ������ �̸��� �Է����ּ���");
			ad2.changeDrink(sc.next());

		}
		
		if (v.getTotalDrink()>0) {
			for (int i = 0; i < v.getTotalDrink(); i++) {
				
				System.out.print("�̸�" + v.getDrinkList()[i].getDrinkName()+"\t");
				System.out.print("����" + v.getDrinkList()[i].getDrinkPrice()+"\t");
				System.out.print("���" + v.getDrinkList()[i].getCount()+"\t");
				System.out.print("�ȸ�����" + v.getDrinkList()[i].getSoldCount()+"\t");
				System.out.println();
			}

		} 
		else {
			System.out.println("�ҷ��� �׸��� �����ϴ�");
		}

	}

	public void salesInfo() {
		// �������-> Transaction ����Ʈ�� ��� �� �ŷ��� �� �����̶� �ȸ������� ���� ���ؼ� ���
		ad.salesInfo();

	}




}

# VendingMachine-Java
The project with JAVA

## The First Team Project
간단한 것 같다고 생각했지만, 간단하지 않은 소스였다.   
여러 메소드가 어떻게 구현되어야 할 지 추상화 작업을 보다 구체적으로 작성해야 한다는 것을 확실하게 느꼈다.   
무엇을 만들려고 하는지 모르면 만들어지는 것도 무엇인지 알아볼 수 없다.   

## Teammates
이현지님은 조장으로서 추상화 작업부터 프로젝트 마무리까지 전반을 맡아주셨고,   
서주연님은 나와 함께 admin의 Implements 들을 작성하였고, 
윤정식님은 자판기가 수행하는 일을 작성하였다.   

## 요구사항 분석
```
주제 : 자판기 

/*
-App(main)
-VO
-관리자-상품관리(재고파악, 재고추가)
-관리자-판매현황(상품별 판매현황)
-관리자-매출현황
-클라이언트 : 자판기 구매
-UI
*/

<요구사항>
*관리자
- 관리자 비밀번호 (초기값 admin)
- 판매량 확인
- 매출확인 
- 음료재고 확인
- 음료 가격 관리
- 잘나가는 음료 순서 
- 얼마내야하는지 알려주기
- 현금권종 천원권만 먹는걸로
- 재고 없을시 X표시 
- 잔돈없을시  없다고 표시(사용불가)
- 기계에 돈 채워넣기(500원, 100원)
- 기계에서 돈 빼기

사용자
- 원하는 음료 선택
- 음료 개수입력
- 결제수단은 현금으로
- 요금 입력(천원단위로)
- 원하는 음료 배출
- 요금 차액(거스름돈)배출 


<문제분석>
-메뉴
1.관리자모드
	1.동전입금. 2출금. 3.지폐잔액조회. 4거스름돈수량확인 5.음료관리 6.매출관리 
2.사용자모드
	1.현금입금 2.음료선택 3.잔돈반환 

-저장정보
입금(deposit) 출금(withdraw) 
1.음료정보(DrinkVO):
   음료번호(DrinkNO)   *음료이름(DrinkName)*  음료 가격(DrinkPrice) 음료 개수(Count)   팔린개수(soldCount)

2.관리자(AdminVO)
 비밀번호(password)   돈(money)   500동전(coin5) 100동전(coin1) 
 거래내역스트링배열(Transaction  ex)1번 유저가 코카콜라 2개)

동전 입금 void deposit(int count, int coin5)
동전 입금 void deposit(int count, int coin1)
출금 void withdraw(int money)
지폐 잔액 조회 void showMoney()
거스름돈수량확인 void showCoins()
매출관리함수:void salesInfo()

 3.사용자(UserVO)
사용자번호(UserNum)   가지고있는돈(money)

현금입금 void deposit()   음료선택 void selectDrink()   음료배출void drinkOut() 


4.자판기(MachineVO)
  현재 있는 지폐(money) 500원동전(coin5) 100원동전(coin1) 
음료 리스트 List<DrinkVO> drinkList

음료리스트 보여주기 void showDrinkList()
잔돈반환 int returnCharge()
```
이후 프로그램을 작성하며 음료 삭제와 음료 수정 기능의 필요성을 느껴 해당 메소드를 추가하였다.

## 마무리
자바 콘솔 내에서 작동하는 것을 넘어 시각적으로도 잘 보여지는 어플리케이션으로 만들 수 있다면 더욱 좋은 경험이 되리라 생각한다.

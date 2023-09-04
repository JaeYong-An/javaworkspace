package day14;

import java.util.Scanner;

public class LottoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1. 로또 번호 생성(수동) - 사용자가 입력
		 -> createLotto(scan);
		2. 로또 번호 생성(자동) - 랜덤 6자리
		 -> createLottoAuto();
		3. 당첨 번호 생성(자동) - 랜덤 7자리
		 -> insertLottoAuto();
		4. 당첨 번호 내역 확인 - 현재회차 1개만 (등수 체크)
		(현재회차 번호가 가장 위에)
		 -> checkLotto();
		5. 당첨번호 리스트 확인 전부 (마지막 당첨 번호가 가장 위에 출력)
		 -> printLotto();
		6. 종료 */
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		LottoManager lm = new LottoManager();
		
		do {
			System.out.println("----menu----");
			System.out.println("1. 로또 번호 생성(수동)");
			System.out.println("2. 로또 번호 생성(자동)");
			System.out.println("3. 당첨 번호 생성");
			System.out.println("4. 당첨 번호 내역 확인");
			System.out.println("5. 당첨 번호 리스트");
			System.out.println("6. 종료");
			System.out.print("> 메뉴입력 : ");
			menu = scan.nextInt();
			
			switch(menu){
			case 1 :
				lm.createLotto(scan);
				break;
			case 2 :
				lm.createLottoAuto();
				break;
			case 3 :
				lm.insertLottoAuto();
				break;
			case 4 :
				lm.checkLotto();
				break;
			case 5 :
				lm.printLotto();
				break;
			case 6 :
				System.out.println("종료합니다.");
				break;
				default :
					System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
		System.out.println("프로그램 종료");
	}

}

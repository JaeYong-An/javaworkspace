package day14;

import java.util.Scanner;

public class LottoManager {
	//메뉴의 메소드 처리
	private Lotto l = new Lotto();
	private LottoE la[] = new LottoE[5];
	int cnt;
	int len = la.length;
	
	public void createLotto(Scanner scan) {
		int num[] = new int[6];
		int i = 0;
		while(i<l.getLottonum().length) {
			System.out.print(i+1+"번째 번호를 입력해주세요 : ");
			num[i] = scan.nextInt();
			if(num[i]>0&&num[i]<46) {
				if(i>=1) {
					for(int j = 0; j<i; j++) {
						if(num[j]==num[i]) {
							System.out.println("중복 숫자");
							i--;
							break;
						}
					}
				}
				i++;
			}else {
				System.out.println("범위(1~45)내의 숫자 입력");
			}
		}
		l = new Lotto(num);
		l.sortNum(num);
		System.out.print("수동 번호>>");
		l.printNum();
		System.out.println();
	}

	public void createLottoAuto() {
		l.auto();
		System.out.print("자동 번호>>");
		l.printNum();
		System.out.println();
	}
	
	public void insertLottoAuto() {
		LottoE newla[] = new LottoE[len+1];
		la[cnt] = new LottoE();
		la[cnt].bonus();
		for(int i = 0; i<len; i++) {
			newla[i] = la[i];
		}
		len++;
		la=newla;
		System.out.print("당첨 번호>>");
		la[cnt].print();
		System.out.println();
		cnt++;
	}
	
	public void checkLotto() {
		int cnt1 = 0;
		int scd = 0;
		for(int i = 0; i<l.getLottonum().length; i++) {
			for(int j = 0; j<la[cnt-1].getInum().length; j++) {
				if(l.getLottonum()[i]==la[cnt-1].getInum()[j]) {
					cnt1++;
					if(l.getLottonum()[i]==la[cnt-1].getInum()[6]) {
						cnt1--;
						scd++;
					}
				}
			}
		}
		if(cnt1 == 6) {
			System.out.println("1등");
		}else if(cnt1 == 5 && scd == 1) {
			System.out.println("2등");
		}else if(cnt1==5 && scd == 0) {
			System.out.println("3등");
		}else if(cnt1==4) {
			System.out.println("4등");
		}else if(cnt1==3) {
			System.out.println("5등");
		}else {
			System.out.println("꽝");
			for(int k = 0; k<l.getLottonum().length; k++) {
				System.out.print(l.getLottonum()[k]+" ");
			}
			System.out.println();
			for(int h = 0; h<la[cnt-1].getLottonum().length; h++) {
				System.out.print(la[cnt-1].getLottonum()[h]+" ");
			}
			System.out.println();
		}
	}
	
	public void printLotto() {
		for(int i = 0; i<cnt; i++) {
			System.out.print(i+1+"회차 : ");
			la[i].print();
			System.out.println();
		}
	}
}

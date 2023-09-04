package day14;

public class Lotto {
	//6개 배열 생성
	private int lottonum[] = new int[6];
	
	public Lotto() {}
	
	public Lotto(int[] lottonum) {
		this.lottonum = lottonum;
	}

	public void sortNum(int[] num) {
		for(int i = 0; i<lottonum.length-1; i++) {
			for(int j = i+1; j<lottonum.length; j++) {
				if(lottonum[i]>lottonum[j]) {
					int tmp = lottonum[i];
					lottonum[i] = lottonum[j];
					lottonum[j] = tmp;
				}
			}
		}
	}
	
	public static boolean check(int arr[]) {
		if(arr.length!=1) {
			for(int i = 0; i<arr.length-1; i++) {
				for(int j = i+1; j<arr.length; j++) {
					if(arr[i] == arr[j]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public int[] auto() {
		while(true) {
			for(int i = 0; i<lottonum.length; i++) {
				lottonum[i] = (int)(Math.random()*45)+1;
			}
			if(check(lottonum)==true) {
				sortNum(lottonum);
				return lottonum;
			}
		}
	}
	
	public void printNum() {
		for(int i = 0; i<lottonum.length; i++) {
			System.out.print(lottonum[i]+" ");
		}
	}

	public int[] getLottonum() {
		return lottonum;
	}

	public void setLottonum(int[] lottonum) {
		this.lottonum = lottonum;
	}

}

class LottoE extends Lotto {
	private int inum[] = new int[7];
	private int bonus;
	
	public LottoE() {
		
	}

	public LottoE(int[] inum, int bonus) {
		super();
		this.inum = inum;
		this.bonus = bonus;
	}
	
	public void print() {
		super.printNum();
		System.out.print("["+bonus+"]");
	}

	public void bonus() {
		System.arraycopy(super.auto(), 0, inum, 0, super.auto().length);
		while(true) {
			int c = 0;
			bonus = (int)(Math.random()*45)+1;
			for(int i = 0; i<6; i++) {
				if(inum[i]==bonus) {
					c++;
				}
			}
			if(c==0) {
				inum[6]=bonus;
				break;
			}
		}
	}

	public int[] getInum() {
		return inum;
	}

	public void setInum(int[] inum) {
		this.inum = inum;
	}
}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 동전 종류
		int K = sc.nextInt(); // 금액	 
		
		int[] money = new int [N];
		
		for (int i = 0; i < N; i++) {
			money[i] = sc.nextInt();
		}
		int cnt = 0;
		for (int j = N - 1; 0 <= j; j--) {
			while(0 < K) {
				cnt++;
				K -= money[j];
				if(K < 0) {
					cnt--;
					K += money[j];
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
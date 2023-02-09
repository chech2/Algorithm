import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//총 구매 개수
		int N = sc.nextInt();
		
		//브랜드 개수
		int M = sc.nextInt();
		
		//가격 저장
		int onemin = Integer.MAX_VALUE;
		int sixmin = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			 sixmin = Math.min(sc.nextInt(), sixmin);
			 onemin = Math.min(sc.nextInt(), onemin);
		}
		
		//3가지 경우를 고려 1. 단품만 골랐을 때, 2. 세트만 골랐을 때, 3 세트 + 단품
		int one = N * onemin;
		int six = (N <= 6? sixmin: (N / 6) * sixmin + sixmin);
		int mix = (N <= 6? onemin * N : (N / 6) * sixmin + onemin * (N % 6));
		
		System.out.println(Math.min((Math.min(one, six)), mix));
		
		
	}

}
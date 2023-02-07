import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] numbers;
	static int[] result;
	static boolean[] isSelected;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[N];
		result = new int[M + 1];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = i + 1;
		}
		perm(0);
		
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			result[cnt] = numbers[i];
			perm(cnt + 1);
			isSelected[i] = false;
		}
		
	}

}
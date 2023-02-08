import java.util.Scanner;

public class Main {
	
	static int N; 
	static int M;
	static int [] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [M];
		combi(0, 1);	
	}
	
	private static void combi(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
}
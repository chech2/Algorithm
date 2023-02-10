import java.util.Scanner;



public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int arr[][] = new int [N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			int max = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					 int tmp = mm(arr,M,i,j);
			            if(tmp >= max)
			                max = tmp;
				}
			}
			
		System.out.printf("#%d %d\n", t, max);	
		}
		
	
		
} 
	private static int mm(int arr[][], int M, int x, int y) {
		int sum = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sum += arr[x+i][y+j];
			}
		}
		return sum;
	} 
	
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		//바구니의 개수
		int N = Integer.parseInt(st.nextToken());
		arr = new int [N];
		Arrays.fill(arr, 0);
		// 정렬 횟수
		int M = Integer.parseInt(st.nextToken());
		

		//1번 값이 들어올 때마다 범위를 지정해놓고 값을 역순으로 정렬
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int num = Integer.parseInt(st.nextToken());
			for (int j = start; j <= end; j++) {
				arr[j] = num;
			}
		}
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

	}
}
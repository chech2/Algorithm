import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 4 0
-7 -3 -2 5 8
 */

public class Main {
	static int N;
	static int S;
	static int totalCnt;
	static int arr[];
	static int result[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		totalCnt = 0;
		arr = new int [N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		subset();
		System.out.println(totalCnt);
	}
	
	private static void subset() {
		for (int i = 1; i < (1 << N); i++) {
			int now = 0;
			for (int j = 0; j < N; j++) if((i & 1 << j) != 0) now += arr[j];
			if (S == now) totalCnt++;
		}
	}
}
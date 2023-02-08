import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N + 1][N + 1];
		int sumlist[][] = new int[N + 1][N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sumlist[i][j] = arr[i][j] + sumlist[i][j - 1] + sumlist[i - 1][j] - sumlist[i - 1][j - 1];
			}
		}
		
		
		int x1;
		int y1;
		int x2;
		int y2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			System.out.println(sumlist[x2][y2] - sumlist[x1 - 1][y2] - sumlist[x2][y1 - 1] + sumlist[x1 - 1][y1 - 1]);
		}
	}

}
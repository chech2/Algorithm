import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
		static int dx [] = {-1, 1, 0, 0}; // 상하좌우
		static int dy [] = {0, 0, -1, 1};
		static int chicken_len[][];
		static int chicken = 0; //치킨집 개수
		static int N;
		static int M;
		static int arr[][];
		static int [] numbers;
		static int [] input;
		static int total = Integer.MAX_VALUE;;
		public static void main(String[] args) throws Exception{
			ArrayDeque<int []> aq = new ArrayDeque<>(); 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) aq.offer(new int[]{i, j});
					if(arr[i][j] == 2) chicken++;
				}
			}
			chicken_len = new int [aq.size()][chicken];
			int i = 0;
			
			
			//각각의 집별 치킨거리 
			while(!aq.isEmpty()) {
				dfs(aq.poll(), i++);
			}
			
			//폐업할 치킨집 구하기
			
//			for (int j = 0; j < i; j++) {
//				System.out.println(Arrays.toString(chicken_len[j]));
//
//			}
			input = new int [chicken_len[0].length];
			for (int j = 0; j < input.length; j++) {
				input[j] = j;
			}
//			System.out.println("M: " + M); 
			numbers = new int[M];
			combi(0,0);
			System.out.println(total);
			
			
	}
		private static void dfs(int [] house, int housenum) {
			int x = house[0];
			int y = house[1];
			int k = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == 2) {
						chicken_len[housenum][k++] = Math.abs(x - i) + Math.abs(y - j);
					}
				}
			}		
		}
		
		private static void combi(int cnt, int start) {
			if(cnt == M) {
				int now;
				int tmp = 0;
				for (int i = 0; i < chicken_len.length; i++) {
					now = Integer.MAX_VALUE;
					for (int j : numbers) {
						if(chicken_len[i][j] < now)
							now = chicken_len[i][j];
					}
					tmp += now;
				}
				if(tmp < total)
					total = tmp;
				return;
			}
			for (int i = start; i < input.length; i++) {
				numbers[cnt] = input[i];
				combi(cnt + 1, i + 1);
			}
		}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int dx [] = {-1, 1, 0, 0}; // 상하좌우
	static int dy [] = {0, 0, -1, 1};
	static int level;
	public static void main(String[] args) throws Exception{
		ArrayDeque<int []> aq = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) aq.offer(new int[]{i, j, 0});
			}
		}
		
//====================================input end====================================================
		while(!aq.isEmpty()) {
			int now [] = aq.poll(); 
			int x = now[0];
			int y = now[1];
			level = now[2];
			for (int i = 0; i < 4; i++) {
				if(0 <= x + dx[i] && x + dx[i] < N && 0 <= y + dy[i] && y + dy[i] < M &&
				    arr[x + dx[i]][y + dy[i]] == 0) {
					aq.offer(new int[]{x + dx[i], y + dy[i], level + 1});
					arr[x + dx[i]][y + dy[i]] = 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					level = -1;
					break;
					}
				}
			}
			System.out.println(level);
		}
	}
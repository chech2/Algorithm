import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int dx[] = {-1,1,0,0}; //상하좌우
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ConfettiNum = Integer.parseInt(br.readLine());
		int Confetti[][] = new int [ConfettiNum][2];
		int map[][] = new int [101][101];
		for (int i = 0; i < ConfettiNum; i++) {
			st = new StringTokenizer(br.readLine());
			Confetti[i][0] = Integer.parseInt(st.nextToken());
			Confetti[i][1] = Integer.parseInt(st.nextToken());
		} 

		for (int i = 0; i < ConfettiNum; i++) {
			int n = Confetti[i][0]; 
			int m = Confetti[i][1]; 
			for (int p = n; p < n + 10; p++) {
				for (int q = m; q < m + 10; q++) {
					map[p][q] = 1;
				}
			}
		}
		
		int total = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j] == 0) continue;
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					if(i + dx[k] < 0 || i + dx[k] >= 101 || j + dy[k] < 0 || j + dy[k] >= 101) cnt++;
					if(map[i + dx[k]][j + dy[k]] == 0) cnt++;
				}
				total += cnt;
			}
		}
		System.out.println(total);
		
		
		
		
	}

}
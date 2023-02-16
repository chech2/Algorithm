import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int city[][];
	static int result[];
	static int N;
	static int sum = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		city = new int[N][N];
		result = new int [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) city[i][j] = Integer.parseInt(st.nextToken());
		}
		perm(0, 0);
		System.out.println(sum);
		
	}
	
	private static void perm(int cnt, int flag) {
		if(cnt == N) {
			int now = 0;
			int gotocity = 0;
			for (int i = 0; i < N; i++) {
					if(i < N - 1) {
						if(city[result[i]][result[i + 1]] != 0) now += city[result[i]][result[i + 1]];
						else break;
					}else {
						if(city[result[i]][result[0]] != 0)now += city[result[i]][result[0]];
						else break;
					}
					gotocity++;
			}
			if(gotocity == N) if(now < sum) sum = now;
		}
		for(int i = 0; i < N ; i++) {
			if((flag & 1 << i) != 0) continue;
			result[cnt] = i;
			perm(cnt + 1, flag | 1 << i);
		}
	}
}
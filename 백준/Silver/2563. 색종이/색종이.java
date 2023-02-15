import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int [][] base = new int [100][100];
		int paperlen = 10;
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < paperlen + x; i++) {
				for (int j = y; j < paperlen + y; j++) {
					base[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < base.length; i++) {
			for (int j = 0; j < base.length; j++) {
				if(base[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
		
	
	
	}

}
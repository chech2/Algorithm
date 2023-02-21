import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char video[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		video = new char[N][N];
		
		for (int i = 0; i < N; i++) 
			video[i] = br.readLine().toCharArray();
		//=============input end===============================
		cutting(0,0,N);
		System.out.println(sb);
	}
	
	private static void cutting(int r, int c, int size) {
		int tmp = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if(video[i][j] == '1') tmp++;
			}
		}  
		if(tmp == size * size || tmp == 0) {
			if(tmp == 0) sb.append(0);
			else sb.append(1);
			return ;
		}
		int half = size / 2;
		sb.append('(');
			cutting(r, c, half); //1사분면 
			cutting(r, c + half, half);//2사분면 
			cutting(r + half, c, half);//3사분면 
			cutting(r + half, c + half, half);	//4사분면 
		sb.append(')');
	}
}
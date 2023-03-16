import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	//우,하, 오른쪽 대각선

	static int visited[][];
	static int N, M, AllNum, Case4Num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int meX = Integer.parseInt(st.nextToken());
		int meY = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - meX;
		int Y = Integer.parseInt(st.nextToken()) - meY;

		
		int result = Integer.MAX_VALUE;
		result = Math.min(result, meX);
		result = Math.min(result, meY);
		result = Math.min(result, X);
		result = Math.min(result, Y);

		System.out.println(result);
	}
}
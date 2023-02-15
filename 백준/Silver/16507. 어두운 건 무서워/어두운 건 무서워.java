import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//세로 R, 가로 C, 결과 몇개 Q
		int [] setting = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		//누적합 계산을 위해 1칸씩 큰 배열로 만듬
		int [][] pixel = new int [setting[0] + 1][setting[1] + 1];
		
		//누적합 계산을 위한 배열 만들기
		for (int i = 1; i < setting[0] + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < setting[1] + 1; j++) {
				int now = Integer.parseInt(st.nextToken());
				//System.out.println(i+" " + j);

				pixel[i][j] = pixel[i][j - 1] +  pixel[i - 1][j] - pixel[i - 1][j - 1]  + now;
				//System.out.printf("%d %d %d %d\n", pixel[i][j - 1], pixel[i - 1][j], pixel[i - 1][j - 1], now);
			}
		}
//		for (int i = 0; i < pixel.length; i++) {
//			for (int j = 0; j < pixel.length; j++) {
//				System.out.print(pixel[i][j] + "  ");
//			}
//			System.out.println();
//		}
	
		
		
		
//		//누적합 이용하여 밝기 계산
		for (int i = 0; i < setting[2]; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int num = pixel[x2][y2] - (pixel[x1 - 1][y2] + pixel[x2][y1 - 1]) + pixel[x1 - 1][y1 - 1];
			int cnt = (x2 - x1 + 1) * (y2 - y1 +1);
			
			sb.append(num / cnt).append("\n");
		}
		System.out.println(sb);

		
		
		
		
	}
}
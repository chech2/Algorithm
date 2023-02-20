import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//x,y의 값이 1차이 날때까지 분할 => 2차원 배열 분할진행
//x,y가 1차이 나면 분할 종료, 배열 방문 -> r,c와 같은 곳 찍으면, break

public class Main {
	static int N; 
	static int R; 
	static int C; 
	static int SIZE;
	static int total = 0;
	
	public static void cut(int x, int y, int arrsize) {
		if(arrsize == 1) {
			for (int i = x; i < x + 1; i++) {
				for (int j = y; j < y + 1; j++) {
					//System.out.println(x + "  "+y);
					if(i == R && j == C) return;
					total++;
				} 
			}
		}
		
		else{
			int half = arrsize / 2;
			SIZE /= 4;
			if(R < x + half) { //1, 2사분면 
				if(C < y + half) {
					cut(x, y, half);//(0,0) => 2사분면
				}
				else{
					total += SIZE;
					cut(x, y + half, half); // (0, 2) => 2사분면
				}
			}
			else {
				total += SIZE * 2;
				if(C < y + half) cut(x + half, y, half); //(2, 0) => 3사분면
				else {
					total += SIZE;
					cut(x + half, y + half, half); //(2,2) => 4사분면
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N); //4
		SIZE = size * size;
		cut(0,0, size);
		
		System.out.println(total);
		
	}

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int []dx = {-1, 1, 0, 0}; //상하좌우
	static int []dy = {0, 0, -1, 1}; //상하좌우
	static int HighArea; //가장 높은 지역의 높이
	static int cnt = 1; //안전영역의 개수, 초기값 = 어떤 지역도 잠기지 않음
	static int check[][], map[][];
	static int N;
	static boolean visi[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visi = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				HighArea = Math.max(map[i][j], HighArea);
			}
		}
		//==========================input end=============================
		
		int[][] saftArea;
		
		for (int i = 1; i < HighArea; i++) { // 침수 높이가 0이면 걍 1이고, HighArea와 같다면 다 잠기므로 의미 x
			saftArea = makesaftArea(i);
//			for (int j = 0; j < saftArea.length; j++) {
//				for (int j2 = 0; j2 < saftArea.length; j2++) {
//					System.out.print(saftArea[j][j2] + " ");
//
//				}  
//				System.out.println();
//			}
			
			//침수 높이 당 안전 지대 개수 세기 
			int nowcheck = 0;
			for (int j = 0; j < saftArea.length; j++) {
				for (int j2 = 0; j2 < saftArea.length; j2++) {
					if(saftArea[j][j2] == 1) 
						{
							countsaftArea(saftArea, j, j2, 0);
							nowcheck++;
//							System.out.println("한번 종료");
						}
						}
			}
			cnt = Math.max(cnt, nowcheck);
//			System.out.println(cnt);

		}
		System.out.println(cnt);
	}
	
	//dfs로 구현
	private static void countsaftArea(int[][] saftArea, int x, int y, int tmp) {
		saftArea[x][y] = 2;
//		int next = x + dx[i]
//		int next = y + dy[i]
		//for (int n = 0; n < saftArea.length; n++) {
			//for (int m = 0; m < saftArea.length; m++) {
				for (int i = 0; i < 4; i++) {
					//배열 범위 벗어나는 경우
					//System.out.println(x + y); 
					if(x + dx[i] < 0 || x + dx[i] >=N || y + dy[i] < 0 || y + dy[i] >= N) continue;
					//재방문
					if(/*visi[x + dx[i]][y + dy[i]] || */saftArea[x + dx[i]][y + dy[i]] != 1) continue;
					
					//System.out.println("현재위치: " + x + " " + y + "      다음 위치: "+(x + dx[i])+" " + (y +dy[i]));
					
					countsaftArea(saftArea, x + dx[i], y + dy[i], tmp + 1);
//					System.out.println(tmp);
				}
			//}
			
		//}
		
//		visi[x][y] = false;
//		cnt++;
		//System.out.println("cnt보자: " + cnt);
//		return tmp;
	}

	//침수 높이에 따른 침수 지역 생성, 1이면 침수 0이면 안전 => 안전 지대의 좌표값을 리턴
	private static int[][] makesaftArea(int FloodingHigh) {
		check = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
				if(map[i][j] > FloodingHigh) check[i][j] = 1;
		}
		return check;
	}
	

}
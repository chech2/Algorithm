import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[][] painting;
	static char[][] NopeRed;
	static int dx[] = {-1,1,0,0}; //상하좌우
	static int dy[] = {0,0,-1,1}; //상하좌우
	//static boolean [][] check;
	static int N; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		painting = new char[N][N];
		NopeRed = new char[N][N];
		for (int i = 0; i < N; i++) {
			painting[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(painting[i][j] == 'R') NopeRed[i][j] = 'G';
				else NopeRed[i][j] = painting[i][j];
			} 
		}
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(NopeRed[i][j] + "\\ ");
//			}
//			System.out.println();
//		}
		
		
		//=========================inputsettting===============================
		
		int [] bluecnt = new int[2]; //0번: 일반, 1번: 적록색약
		int [] greencnt = new int[2]; //0번: 일반, 1번: 적록색약
		int  redcnt = 0; //적록색약의 빨간색은 보지 않을 것임
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(painting[i][j] == 'B') {
					countBlue(i,j,'B', painting);
					bluecnt[0]++;
//					System.out.println("궁금: " +"x: "+i+" y : "+j +painting[i][j]);
				}
				if(NopeRed[i][j] == 'B') {
					countBlue(i,j,'B', NopeRed);
					bluecnt[1]++;
//					System.out.println("궁금: " +"x: "+i+" y : "+j +NopeRed[i][j]);
				}
				if(painting[i][j] == 'G') {
					countBlue(i,j,'G', painting);
					greencnt[0]++;
//					System.out.println("궁금: " +"x: "+i+" y : "+j +painting[i][j]);
				}
				if(NopeRed[i][j] == 'G') {
					countBlue(i,j,'G', NopeRed);
					greencnt[1]++;
//					System.out.println("궁금: " +"x: "+i+" y : "+j +NopeRed[i][j]);
				}
				if(painting[i][j] == 'R') {
					countBlue(i,j,'R', painting);
					redcnt++;
//					System.out.println("궁금: " +"x: "+i+" y : "+j +painting[i][j]);
				}
				
			}
		}
		System.out.println((redcnt + greencnt[0] + bluecnt[0]) + " "+(greencnt[1] +bluecnt[1]));
		
		
	}
	private static void countBlue(int x, int y, char color, char [][] tmppainting) {
		tmppainting[x][y] = '0';
		for (int i = 0; i < 4; i++) {
			//배열 범위 바깥
			if(x + dx[i] < 0 || x + dx[i] >= N || y + dy[i] < 0 || y + dy[i] >= N) continue;
			
			//그림 확인 작업
			if(tmppainting[x + dx[i]][y + dy[i]] != color) continue;
//			System.out.println("i: "+ (x + dx[i]) + " y: " + (y + dy[i]));
			countBlue(x + dx[i], y + dy[i], color,  tmppainting);
		}
	}
	
}
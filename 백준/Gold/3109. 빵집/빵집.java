import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char map[][]; // . 진행가능, * 건물
	static int []dx = new int[]{-1, 0, 1}; //위로 대각선, 오른쪽, 아래로 대각선
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C]; //0번열 인덱스    -> 빵집
								//마지막열 인덱스 -> 도둑놈 빵집
		
		for (int i = 0; i < R; i++)
			 map[i] = br.readLine().toCharArray();
		//==============input setting end==========================
		
		//모든 행에 대해 연결 시도
		for (int i = 0; i < R; i++) {
			connect(i, 0); //i는 행값, 0은 열값
		}
        System.out.println(count);
	}
	
	
	//(x,y)위치에서 시작해서 3방향으로 가 보는 메소드 갈 수 있으면 true, 못 가면 false
	private static boolean connect(int x, int y) {
		//기저조건(종료): 원웅이네 도착
		if(y == C - 1) {
			count++;
			return true;
		}
		//아니면 계속해서 3방향 조사 후 전진
		for (int i = 0; i < 3; i++) { //우상, 우, 우하 
			int nx = x + dx[i];
			int ny = y + 1;
			
			//이동할 좌표를 계산 했을때 배열 안에 있는지 체크
			if(isIn(nx, ny) && map[nx][ny] == '.') {
				map[nx][ny] = '=';
				boolean result = connect(nx, ny);
				if(result) return true; //이거 결과가 true이면 더이상 볼 필요도 없음, 
										//도착한 것이므로!
			}
		} 
		//루프를 다 돌고도 함수를 못벗어났다면 3방향 모두 안된다는 뜻
		return false;
	}


	private static boolean isIn(int nx, int ny) {
		return nx >=0 && ny >= 0 && nx < R && ny < C;
	}
	
	
	
}
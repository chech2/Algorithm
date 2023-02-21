import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int result, R, C, check[][];
	static String map[][];
	static int []dx = new int[]{-1, 0, 1}; //위로 대각선, 오른쪽, 아래로 대각선
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken());
		check = new int [R][C];
		map = new String[R][C]; //0번열 인덱스    -> 빵집
								//마지막열 인덱스 -> 도둑놈 빵집
		
		for (int i = 0; i < R; i++)
			 map[i] = br.readLine().split("");
		//==============input setting end==========================
		
		for (int i = 0; i < R; i++) {
			dfs(i,0); //0,0 : 1,0 : 2,0 : 3,0 : 4,0 시작
		}
		 
		System.out.println(result);
	}
	
	public static boolean dfs(int row, int col) { //colNo: 인덱스로 사용될 열번호
		check[row][col] = 1; //일단 들어왔으면 가능한 것임
		
		//기저 조건, 도둑놈 가게 도착완료!!
		if(col == C - 1) {
			result++;
			return true;
		}
		
		int tmp = -500;
		for (int x : dx) {
			//다음 위치 후보가 map범위 벗어나는 경우
			if (row + x < 0 || R <= row + x || C <= col + 1) continue;
			//다음 위치 후보에 건물이 있는 경우
			if(map[row + x][col + 1].equals("x")) continue;
			//이미 한번 왔다간 곳인 경우
			if(check[row + x][col + 1] == 1) continue;
			
			//다음위치 선정완료
			tmp = x;
			if(dfs(row + x, col+1)) return true;
		}
		//다음 위치 없음 -> 되돌아 가야 됨
		//if(tmp == -500) {
		//	check[row][col] = 0;
			//return false;
		//}
		//현재 위치에서 갈 수 있는 길이 있다면?? -> 그 좌표 가지고 또 그다음을 확인하러 가야 됨
		return false;
	}
}
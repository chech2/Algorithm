import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static char arr[][];
	static int horse[] = new int [28];
	static int R, C;
	static int []dx = {-1, 1, 0, 0}; //상하좌우
	static int []dy = {0, 0, -1, 1};
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for (int i = 0; i < R; i++) arr[i] = br.readLine().toCharArray();
	
		//List<String> horse = new ArrayList<>();
		//horse.add(String.valueOf(arr[0][0]));
		horse[arr[0][0] - 'A'] = 1;
		counting(0, 0, 1);
		
		System.out.println(result);
		
	}
	
	private static void counting(int x, int y, int tmp) {
		for (int i = 0; i < 4; i++) {
				if((x + dx[i] < 0 || x + dx[i] >= R) || (y + dy[i] < 0 || y + dy[i] >= C)) continue;

				if(horse[arr[x + dx[i]][y + dy[i]] - 'A'] == 1)
					continue;
				else 
					horse[arr[x + dx[i]][y + dy[i]] - 'A'] = 1;
				
				counting(x + dx[i], y + dy[i], tmp + 1);
				horse[arr[x + dx[i]][y + dy[i]] - 'A'] = 0;
		}
		int cnt = 0;
		for (int i = 0; i < 28; i++) {
			if(horse[i] == 1) cnt++;
		}
		result = Math.max(result , cnt);
	}
}
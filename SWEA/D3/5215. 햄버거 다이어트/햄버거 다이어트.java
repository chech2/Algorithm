/*
 
1
5 1000
100 200
300 500
250 300
500 1000
400 400
 
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int [][] Ingredi;
	static int LimitCal;
	static int Score;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int Tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= Tc; t++) {
			Score = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			LimitCal = Integer.parseInt(st.nextToken());
			Ingredi = new int [N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					Ingredi[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Subset(0, 0, 0);
			System.out.printf("#%d %d\n",t,Score);
			
		}
	}
	
	private static void Subset(int cnt, int nowscore, int nowCal) {
		if(LimitCal < nowCal) return;
		if(cnt == N) {
			if(nowCal <= LimitCal && Score < nowscore) {
				Score = nowscore;
			}
			return;
		}
			Subset(cnt + 1, nowscore + Ingredi[cnt][0] , nowCal + Ingredi[cnt][1]);
			Subset(cnt + 1, nowscore , nowCal);	
	}

}
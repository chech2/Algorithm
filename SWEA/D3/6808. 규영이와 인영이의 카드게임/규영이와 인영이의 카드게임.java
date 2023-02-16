import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static Integer[] inyoung;
	static Integer[] inyoungPerm;
	static Integer[] kyu;
	static Integer[] numbers;
	static int totalCnt;
	static int win;
	static int lose;

	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			HashSet<Integer> numbers = new  HashSet<>(); 
			kyu = new Integer[9];
			inyoung  = new Integer[9];
			inyoungPerm  = new Integer[9];
			win = 0;
			lose = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 19; i++) numbers.add(i);
			for (int i = 0; i < 9; i++){ 
				kyu[i] = Integer.parseInt(st.nextToken());
				numbers.remove(kyu[i]);
			}
			inyoung = numbers.toArray(new Integer[9]);

//=========================input setting=========================================================			
			perm(0,0);
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
			
		}
		System.out.println(sb);
	}

	private static void perm(int cnt, int flag) {
		if(cnt == 9) {
			totalCnt++;
			int Knum = 0, Inum = 0;
			for (int i = 0; i < 9; i++) {
				if(kyu[i] < inyoungPerm[i]) Inum += kyu[i] + inyoungPerm[i];
				else Knum += kyu[i] + inyoungPerm[i];
			}
			if(Knum > Inum) win++;
			else if (Knum < Inum) lose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if((flag & (1 << i)) != 0) continue;
			inyoungPerm[cnt] = inyoung[i];
			perm(cnt + 1, (flag | 1 << i));
				
		}
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;



public class Solution {

	static int N;
	static int M;
	static int parent[]; //사람의 번호가 1번부터 시작하므로 0은 사용 x
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t < TC + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parent = new int [N + 1]; 
			for (int i = 0; i < N + 1; i++) {
				parent[i] = i;
			} 
			for (int i = 0; i < M; i++) {
				 st = new StringTokenizer(br.readLine());
				 int a = Integer.parseInt(st.nextToken());
				 int b = Integer.parseInt(st.nextToken());
				 union(a, b);			 
			}
			int cnt = 0;
			for (int i = 1; i < N +1; i++) {
				parent[i] = find(i);
				if(i == parent[i]) cnt++;
			}
			//System.out.println(Arrays.toString(parent));
			System.out.println("#"+t + " " + cnt);
		} 
	}

//	private static boolean findCycle(int a, int b) {
//		if(find(a) == find(b)) return false;
//		
//		return true;
//	}
	
	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		//같은 경우 union하지 않음
		if(aroot == broot) return;
		
		//다른 경우 union진행
		if(aroot < broot)
			parent[broot] = aroot;
		
		else 
			parent[aroot] = broot;
	}

	private static int find(int i) {
		if(parent[i] == i) return i;
		return find(parent[i]);
	}

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	static int N;
	static int M;
	
	
	private static int getparent(int x) {
		if(parent[x] == x) return x;
		return getparent(parent[x]);
	}
	
	
	private static void unionparent(int a, int b) {
		a = getparent(a);
		b = getparent(b);
		if(a < b) parent[b] = a;
		else parent[b] = getparent(a);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int [N + 1];
		for (int i = 0; i < N + 1; i++) parent[i] = i;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int calculation = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			 //부모 합치기 
			if(calculation == 0) {
				unionparent(a, b);
				
			}else {
				if(getparent(a) == getparent(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
		
	
	}

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	private static void dfs(ArrayList<Integer> grap, int idx) {
		visidfs[idx] = true;
		nagali++;
		//sb.append(idx).append(" ");
		for (int i = 0 ; i < grap.size(); i++) {
			if(visidfs[grap.get(i)]) continue;
			dfs((ArrayList<Integer>) Nodes[grap.get(i)], grap.get(i)); 
		}   
	}
	
	static void make_grap() throws Exception {
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			Nodes[from].add(to);
			Nodes[to].add(from);
		} 
	}
	
	static boolean visidfs[];
	static ArrayList<Integer>[] Nodes;
	static StringTokenizer st;
	static int N; //정점의 개수
	static int M;
	static int nagali; //바이러스 걸린 컴퓨터 개수
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		Nodes = new ArrayList[N + 1];
		visidfs = new boolean[N + 2];
		
		for (int i = 0; i < N + 1; i++)	Nodes[i] = new ArrayList<>();
		make_grap(); //그래프 만들기
		
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(Nodes[i]);
		}
		
		dfs((ArrayList<Integer>)Nodes[1], 1);
		//sb.append("\n");
		System.out.println(nagali - 1); 	
	}
}
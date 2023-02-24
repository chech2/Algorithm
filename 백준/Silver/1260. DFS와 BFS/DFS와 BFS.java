import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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
	
	private static void dfs(ArrayList<Integer> grap, int idx) {
		visidfs[idx] = true;
		
		sb.append(idx).append(" ");
		for (int i = 0 ; i < grap.size(); i++) {
			if(visidfs[grap.get(i)]) continue;
			dfs((ArrayList<Integer>) Nodes[grap.get(i)].clone(), grap.get(i)); 
			//sb.append(grap.get(i)).append("=");
		}   
		//
	}
	
	
	private static void bfs(ArrayList<Integer>[] grap, int start) {
		Queue<ArrayList> q = new ArrayDeque<>();
		boolean[] visi = new boolean[N + 1];
		
		q.offer(grap[start]);
		sb.append(start).append(" ");
		visi[start] = true;
		while(!q.isEmpty()) {
			ArrayList<Integer> now = q.poll();
			for (int i = 0; i < now.size(); i++) {
				int tmp = now.get(i);
				
				//재방문인지 체크
				if(visi[tmp]) continue;
				visi[tmp] = true; //방문체크
				q.offer(grap[tmp]);//큐에 넣기
				sb.append(tmp).append(" ");
			}
		}
		sb.append("\n");
	}
	
	
	
	static boolean visidfs[];
	static ArrayList<Integer>[] Nodes;
	static StringTokenizer st;
	static int N; //정점의 개수
	static int M; //간선의 개수
	static int V; //방문 시작 노드
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		Nodes = new ArrayList[N + 1];
		visidfs = new boolean[N + 2];
		
		for (int i = 0; i < N + 1; i++)	Nodes[i] = new ArrayList<>();
		make_grap(); //그래프 만들기
		
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(Nodes[i]);
		}
//		for (ArrayList<Integer> is : Nodes) {
//			System.out.println(is.toString());
//		}
		
		dfs((ArrayList<Integer>)Nodes[V].clone(), V);
		sb.append("\n");
		bfs(Nodes.clone(), V);
		System.out.println(sb); 
		
	}

	
	

}
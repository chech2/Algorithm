import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine()) - 1;
		ArrayList<ArrayList<int[]>> adjMatrix = new ArrayList<>();
		
		for (int i = 0; i < V; i++) {
			adjMatrix.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int W = Integer.parseInt(st.nextToken());
			
			adjMatrix.get(from).add(new int[] {to, W});
		} 
		
		int distance[] = new int [V];
		boolean visited[] = new boolean[V];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		for (int i = 0; i < V; i++) {
			int current = -1;
			int min = Integer.MAX_VALUE;
			
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			if(current == -1) continue;
			visited[current] = true;
						
			for (int [] now : adjMatrix.get(current)) {
//				for (int k = 0; k < nowList.size(); k++) {
					if(!visited[now[0]] && now[1] != 0
							&& distance[now[0]] > min + now[1]) {
						distance[now[0]] = min + now[1];
//					}	
				}
								
			}
			
		}
		for (int i = 0; i < V; i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		}
		System.out.println(sb);
	}
}
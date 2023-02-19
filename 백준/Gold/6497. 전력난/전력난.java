import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int homeNum;
	static int roadNum;
	static int parent[];
	public static class home{
		int home1;
		int home2;
		int roadlen;
		public home(int home1, int home2, int roadlen) {
			this.home1 = home1;
			this.home2 = home2;
			this.roadlen = roadlen;
		}
	}
	
	public static int getparent(int x) {
		if(parent[x] == x) return x;
		return getparent(parent[x]);
	}
	
	public static void unionparent(int x, int y) {
		x = getparent(x);
		y = getparent(y);
		if(x < y) parent[y] = x;
		else parent[x] = getparent(y);
		
		
	}
	
	public static void main(String[] args) throws Exception {
		PriorityQueue<home> Info = new PriorityQueue<>((o1, o2) -> o1.roadlen - o2.roadlen);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			homeNum = Integer.parseInt(st.nextToken());
			roadNum = Integer.parseInt(st.nextToken());
			if(homeNum == 0 && roadNum == 0) break;
			int total = 0;
			parent = new int [homeNum];
			for (int i = 0; i < homeNum; i++) {
				parent[i] = i;
			}
		
			for (int i = 0; i < roadNum; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				Info.add(new home(a, b, c));
				
			}
			int result = 0;
			while(!Info.isEmpty()) {
				home now = Info.poll();
				total += now.roadlen;
				if(getparent(parent[now.home1]) == getparent(parent[now.home2])) continue;
				else {
					result += now.roadlen;
					unionparent(parent[now.home1], parent[now.home2]);
				}
			}
			sb.append(total - result).append("\n");
		}
		System.out.println(sb);
	}

}
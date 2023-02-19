import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	static int nodeNum;
	static int LineNum;
	
	
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
	
	public static class NodeInfo {
		int a;
		int b;
		int c;
		public NodeInfo(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//StringBuilder sb = new StringBuilder();
		PriorityQueue<NodeInfo> Info = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
		
		nodeNum = Integer.parseInt(st.nextToken());
		LineNum = Integer.parseInt(st.nextToken());
		parent = new int[nodeNum + 1];

		for (int i = 0; i <= nodeNum; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < LineNum; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			Info.add(new NodeInfo(a, b, c));
		}
		
		long tmp = 0;
		while(!Info.isEmpty()) {
			NodeInfo now = Info.poll();
			if(getparent(now.a) == getparent(now.b)) continue;
			else {
				tmp += now.c;
				unionparent(now.a, now.b);
			}
		}
		System.out.println(tmp);
		
	}

}
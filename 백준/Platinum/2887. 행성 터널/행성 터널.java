import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	
	public static class planet{
		int idx1;
		int idx2;
		int len;
		public planet(int[] p1, int[] p2) {
			this.idx1 = p1[0];
			this.idx2 = p2[0];
			this.len = Math.abs(p1[1] - p2[1]);
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
	
	public static void makeEdge (PriorityQueue<int []> tmp) {
		int [] chk1 = tmp.poll();
		for (int i = 0; i <  planetNum - 1; i++) {
			int [] chk2 = tmp.poll();
			planelen.add(new planet(chk1, chk2));
			chk1 = chk2;
		}
	}

	static int planetNum;
	static PriorityQueue<planet> planelen = new PriorityQueue<>((o1, o2) -> o1.len - o2.len);
	public static void main(String[] args) throws Exception{
		PriorityQueue<int []> x = new PriorityQueue<>((x1, x2) -> x1[1] - x2[1]); //인덱스, 
		PriorityQueue<int []> y = new PriorityQueue<>((y1, y2) -> y1[1] - y2[1]);
		PriorityQueue<int []> z = new PriorityQueue<>((z1, z2) -> z1[1] - z2[1]);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		planetNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		parent = new int [planetNum + 1];
		for (int i = 0; i < planetNum; i++) {
			st = new StringTokenizer(br.readLine());
			x.add(new int[]{i, Integer.parseInt(st.nextToken())});
			y.add(new int[]{i, Integer.parseInt(st.nextToken())});
			z.add(new int[]{i, Integer.parseInt(st.nextToken())});
			parent[i + 1] = i + 1;
		}
		makeEdge (x);
		makeEdge (y);
		makeEdge (z);

		
		int result = 0;
		while(!planelen.isEmpty()) {
			planet now = planelen.poll();
			//result += now.len;
			if(getparent(parent[now.idx1]) == getparent(parent[now.idx2])) continue;
			else {
				result += now.len;
				unionparent(parent[now.idx1], parent[now.idx2]);
			}
		}
		System.out.println(result);
	}
}
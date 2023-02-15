import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<int []> pq = new PriorityQueue<>((x1, x2) -> x1[0] == x2[0] ? x1[1] - x2[1] : x1[0] - x2[0]);
		

		
		StringBuilder sb = new StringBuilder();
		int cnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cnt; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if(pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()[1]).append("\n");
			}else {
				pq.offer(new int[] {Math.abs(tmp),tmp});
			}
		}
		System.out.println(sb);
		
	}

}
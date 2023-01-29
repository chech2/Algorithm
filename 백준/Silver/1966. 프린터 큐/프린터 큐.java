import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
	
		for (int tc = 0; tc < TC; tc++) {
			LinkedList<int []> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int cur_posi = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				q.offer(new  int[] {i, Integer.parseInt(st.nextToken())});
			}
			while(!q.isEmpty()) {
				boolean flag = true;
				int [] chk = q.poll();
				for (int i = 0; i < q.size(); i++) {
					if(chk[1] < q.get(i)[1]) {
						flag = false;
						q.offer(chk);
						break;
					}
				}
				if(flag){
					cnt++;
					if(chk[0] == cur_posi) {
						sb.append(cnt + "\n");
						break;
					}
				}			
			}
		
	}
	System.out.println(sb); 
	}
}

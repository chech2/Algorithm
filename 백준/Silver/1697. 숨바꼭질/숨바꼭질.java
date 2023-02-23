import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int move[] = {-1, 1, 2}; //앞, 뒤, 순간 이동
	static int Subin;
	static int bro;
	static int Time = 0;
	static boolean[] visi = new boolean[200001];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Subin = Integer.parseInt(st.nextToken());
		bro = Integer.parseInt(st.nextToken());
		Queue<int []> q = new LinkedList<int []>();
		q.offer(new int[] {Subin, 0}); //수빈이 위치, 시간
		int []now = new int[2];
		
		while(!q.isEmpty()) {
			now = q.poll();
			//System.out.println(now[0] + "  " + now[1]);
			if(now[0] == bro) {
				System.out.println(now[1]);
				break;
			}
			for (int i = 0; i < move.length; i++) {
				if(now[0] + move[i] < 0 || 200000 < now[0] + move[i]) continue;
				if(i == 2) {
					if(now[0] * move[2] < 200000 && !visi[now[0] * move[2]]) {
						visi[now[0] * move[2]] = true; //이제 큐에 넣을것이고 확실히 방문할 것이므로 체크
						q.offer(new int[] {now[0] * move[2], now[1] + 1});
					}
				}else {
					if(visi[now[0] + move[i]]) continue;
					visi[now[0] + move[i]] = true;
					q.offer(new int[] {now[0] + move[i], now[1] + 1});
				}
			}
		}
	}
}
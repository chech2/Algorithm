import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			//입력값 세팅
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			//큰값부터 내림차순 정렬을 위해 사용
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			//과자무게 세팅 큐
			ArrayDeque<Integer> q = new ArrayDeque<>();
			
			
			st = new StringTokenizer(br.readLine());
			
			//큰 값순으로 정렬 
			for (int i = 0; i < N; i++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			
			//과자 무게 순 세팅 완료
			for (int i = 0; i < N; i++) {
				q.offer(pq.poll());
			}
			
			//while문 벗어나기 위한 flag
			boolean flag = true;
			
			//들고 갈 수 없을 때 -1 return리턴
			pq.offer(-1);
			
			while (!q.isEmpty()) {
				//현 시점 제일 큰 무게
				int max = q.poll();
				
				//제일 큰 과자 무게 + 큐 안에 있는 과자 1봉지의 무게가 
				//들고 갈 수 있는 최대 무게 벗어나는지 확인
				for (int i = 0; i < q.size(); i++) {
					int tmp = q.poll();
					if(tmp + max <= M) {
						pq.offer(tmp + max);
					}
					q.offer(tmp);
				}
			}
			System.out.println("#"+t+" "+pq.poll());
		}
	}

}
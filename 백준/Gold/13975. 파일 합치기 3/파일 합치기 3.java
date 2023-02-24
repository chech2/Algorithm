import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < TC; t++) {
			int FileNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> q = new PriorityQueue<>();
			for (int i = 0; i < FileNum; i++) {
				q.offer(Long.parseLong(st.nextToken()));
			} 
			//======== 테스트 케이스 별 input 세팅 완료
			long tmp1;// = q.poll();
			long tmp3 = 0;
			while(q.size() > 1) {
				tmp1 = q.poll() + q.poll();
				q.offer(tmp1);
				tmp3 += tmp1;
				//System.out.println(tmp1 + " " + tmp2 + " " + tmp3);
			}
			System.out.println(tmp3);
			
		} 

//아하! ok!		
//		30 30 40 50
//	60
//		60 90
//	150
//		150 => 150
//		150 
		
	}

}
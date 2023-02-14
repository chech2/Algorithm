import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		LinkedList<Integer> origin = new LinkedList<>();

		int min = Integer.MAX_VALUE;
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
			
		st = new StringTokenizer(br.readLine());
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			origin.offerLast(Integer.parseInt(st.nextToken()));			
			cnt++;
			sum += origin.peekLast();
					
			if(S <= sum) {
				while(S <= sum) {
					sum -= origin.pollFirst();
					cnt--;
				}
				if(cnt < min) {
					if(cnt == 0) cnt++;
					min = cnt;
				}
			}
		}

		if(min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}
}
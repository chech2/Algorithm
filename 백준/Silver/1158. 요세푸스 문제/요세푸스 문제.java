import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		LinkedList<Integer> arr = new LinkedList<>();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
			
		//순열의 베이스 완성!
		for (int i = 1; i < N+1; i++) {
			arr.add(i);
		}
		
		sb.append("<");
		while(arr.size() > 1) {
			for (int k = 1; k < K + 1; k++) {
				if(k == K)
					sb.append(arr.poll() + ", ");
				else {
					arr.offer(arr.poll());
				}
			}
		}
		sb.append(arr.poll() + ">");
		System.out.println(sb);
	}
}
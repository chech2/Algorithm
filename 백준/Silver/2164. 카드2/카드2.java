import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while (1 < q.size()) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}

}
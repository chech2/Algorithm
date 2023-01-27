import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = Integer.parseInt(st.nextToken());
		int min = max;
		int now;
		
		for (int i = 0; i < N - 1; i++) {
			now = Integer.parseInt(st.nextToken());
			if(max < now)
				max = now;
			if(now < min)
				min = now;
		}
		System.out.println(min + " " + max);
		
	}
}	
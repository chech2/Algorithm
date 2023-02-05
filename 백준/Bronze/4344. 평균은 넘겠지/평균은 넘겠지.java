import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
		    int cnt = Integer.parseInt(st.nextToken());
		    int sum = 0;
		    int [] score = new int[cnt];
		    for (int i = 0; i < cnt; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}
		    double avg = (double)sum / cnt;
		    int	nope =0;
		    for (int i = 0; i < cnt; i++) {
		    	if((double)score[i] > avg) {
		    		nope++;
		    	}
		    }
		    sb.append(String.format("%.3f", (double)nope/cnt * 100) +"%\n");
		}
		System.out.println(sb);
	}
}

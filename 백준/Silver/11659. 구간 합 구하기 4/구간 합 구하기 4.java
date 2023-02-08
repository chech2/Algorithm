import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//n개의 누적합을 모두 구해보자
public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] sumlist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sumlist = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 0)
				sumlist[0] = arr[i];
			else
				sumlist[i] = sumlist[i - 1] + arr[i];
		}
		int j;
		int k;		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			j = Integer.parseInt(st.nextToken()) - 1;
			k = Integer.parseInt(st.nextToken()) - 1;
			sb.append(sumlist[k] - sumlist[j] + arr[j] + "\n");
		}
		System.out.println(sb);

	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int arr[] = new int [20000001];
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int tmp;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if(tmp < 0) arr[20000001 + tmp]++;
			else arr[tmp]++;
			
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			tmp =  Integer.parseInt(st.nextToken());
			if(tmp < 0)sb.append(arr[20000001 + tmp]).append(" ");
			else sb.append(arr[tmp]).append(" ");
		}
		System.out.println(sb);
		
		
		
	}

}
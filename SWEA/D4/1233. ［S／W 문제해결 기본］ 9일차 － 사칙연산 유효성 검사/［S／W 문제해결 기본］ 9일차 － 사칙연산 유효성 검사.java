import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t < 11; t++) {
			int N = Integer.parseInt(br.readLine());
//			System.out.println(N);
			int print = 1;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int NodeNum = Integer.parseInt(st.nextToken());
//				System.out.println(NodeNum);
				boolean flag = false;
				if(NodeNum <= N/2) {//내부 노드
					switch (st.nextToken()) {
						case "+":
							break;
						case "-":
							break;
						case "*":
							break;
						case "/":
							break;
						default:
							flag = true;
							break;
					}
				}else {//단말 노드
					try {
						Integer.parseInt(st.nextToken());
					}catch (Exception e) {
						flag = true;
						//break;
					}
				}
				if(flag) {
					print = 0;
					//break;
				}
			}
			System.out.printf("#%d %d\n", t, print);					
		}
		
	}

}
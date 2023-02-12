import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<int []> tower = new ArrayDeque<>();

				
		st = new StringTokenizer(br.readLine());
		tower.offer(new int[] {1, Integer.parseInt(st.nextToken())}); //첫번째 값 ->냅다 넣어버려!
		sb.append(0 + " "); //나보다 큰 수 앞에 없으면 0임
		for (int i = 2; i < N+1; i++) {
			int [] tmp = new int[] {i, Integer.parseInt(st.nextToken())};
			if(tmp[1] < tower.peek()[1]) {  //입력값이 tower에 저장된 값보다 작은 경우
				sb.append(tower.peek()[0] + " "); 
				tower.offerFirst(tmp);
			}else {
				//입력값이 tower에 저장된 값보다 큰 경우
				while(!tower.isEmpty()) {
					if(tower.peek()[1] < tmp[1]) { //입력값이 tower에 저장된 값보다 큰 경우 
						tower.poll();
					}else {
						sb.append(tower.peek()[0] + " "); //입력값이 tower에 저장된 값보다 작은 경우 
						tower.offerFirst(tmp);         
						break;
					}																																							
				}
				if(tower.isEmpty()) {
					tower.offerFirst(tmp);
					sb.append(0 + " ");
				}
				
			}	
	}
	System.out.println(sb);
	}
}
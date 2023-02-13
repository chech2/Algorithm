import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayDeque<int []> building = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long result = 0;
		
		//제일 처음 빌딩 넣어주기
		building.offer(new int[] {1, Integer.parseInt(br.readLine())});
		
		for (int i = 2; i < N + 1; i++) {
			int tmp = Integer.parseInt(br.readLine());
			//입력 높이보다 큰 건물이 앞에 있다면 => 그냥 입력하고 볼 수 있는 건물의 개수 증가

			if(tmp < building.peekLast()[1]) {
				result += building.size();
				building.offer(new int[] {i,tmp});
			}
	
			//앞의 건물이 더 작거나 같다면 
			else {
				//작은 건물 없어질 때까지 빼주기 
				while (!building.isEmpty()) {
					if(building.peekLast()[1] <= tmp)
						building.pollLast();
					//else if(building.peekLast()[1] == tmp) {
						//빼버리기 전에 볼수 있는 건물의 개수 1개 늘려줘야 됨
						//result++;
						//building.pollLast();
					//}
					else{
						result += building.size();
						break;
					}
				}
				building.offer(new int[] {i, tmp});
			}		
		}
		System.out.println(result);
	}
}
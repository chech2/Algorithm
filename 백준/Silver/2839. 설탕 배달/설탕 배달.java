import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean flag = true;
		//5kg 사용한 경우
		for (int i = N / 5; 0 < i; i--) {
			int kg3 =  (N - 5 * i) / 3;
			if(N == i*5 + kg3*3) {
				System.out.println((i + kg3));
				flag = false;
				break;
			}
		}
		
		if(flag){
			if(N % 3 ==0) System.out.println(N / 3); 
			else System.out.println(-1);	
		}
	}
}
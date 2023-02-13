import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int t = 1; t < 11; t++) {
			LinkedList<String> nums = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//원본데이터
			for (int i = 0; i < N ; i++) {
				nums.add(st.nextToken());
			}
			
			//중간 데이터 삽입
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {			
				if("I".equals(st.nextToken())){
					int start = Integer.parseInt(st.nextToken());
					int end = Integer.parseInt(st.nextToken());
				
					for (int j = start; j < start + end; j++) {
						nums.add(j, st.nextToken());
					}
				}
			}
			System.out.printf("#%d ", t);
			for (int i = 0; i < 10; i++) {
				System.out.printf("%s ",nums.get(i));
			}
			System.out.println();
	}
	}
}
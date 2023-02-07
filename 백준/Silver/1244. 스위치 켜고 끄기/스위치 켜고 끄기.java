import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int []switcharr;

	static void man(int now) {
		for (int i = 1; i < switcharr.length + 1; i++) {
			if (i % now == 0) {
				if (switcharr[i - 1] == 1) switcharr[i - 1] = 0;
				else switcharr[i - 1] = 1;
			}
		}
	}
	
	static void woman(int now) {
		int start = now, end =now;
		for(int i = now + 1, j = now - 1; i < switcharr.length && -1 < j; i++, j--) {
			if(switcharr[i] == switcharr[j]) {
				start = j;
				end = i;
			}else break;		
		}
		for (int i = start; i < end + 1; i++) {
				if (switcharr[i] == 1) switcharr[i] = 0;
				else switcharr[i] = 1;
			}
		}


//0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//스위치 개수
		int switchcnt = Integer.parseInt(br.readLine());

		//스위치 상태
		switcharr = new int[switchcnt];

		//스위치 상태 세팅
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < switchcnt; i++) {
			switcharr[i] = Integer.parseInt(st.nextToken());
		}
		
		//학생수
		int studentcnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < studentcnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			//남학생
			if(Integer.parseInt(st.nextToken()) == 1){
				man(Integer.parseInt(st.nextToken()));
			}else {
				woman(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		for (int i = 0; i < switchcnt; i++) {
			if(i != 0 && i % 20 == 0) System.out.println();
			System.out.print(switcharr[i] + " ");
		}
		System.out.println();
		
	}

}
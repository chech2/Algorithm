import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//주어진 문자열의 총 길이
		int givenstrCnt = Integer.parseInt(st.nextToken());
		
		//만들어야 하는 비밀번호의 길이
		int PWcnt = Integer.parseInt(st.nextToken());
		
		//주어진 문자열
		String givenstr = br.readLine();
		int result = 0;
		int[] chk = new int[4];
		
		//비밀 번호에 포함되야 하는 글자의 최소 개수
		st = new StringTokenizer(br.readLine());
		int [] essential = new int [4];
		for (int i = 0; i < 4; i++) {
			essential[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = PWcnt;
		
		for (int j = 0; j < PWcnt; j++) {
			if(givenstr.charAt(j) == 'A') chk[0] += 1;
			else if (givenstr.charAt(j) == 'C') chk[1] += 1;
			else if (givenstr.charAt(j) == 'G') chk[2] += 1;					
			else chk[3] += 1;				
			}
		for (int k = 0; k < 4; k++) {
			if (chk[k] < essential[k]) break;
			else if(k == 3) result += 1;
		}
		
		while(end < givenstrCnt) {
			if(givenstr.charAt(start) == 'A') chk[0] -= 1;
			else if (givenstr.charAt(start) == 'C') chk[1] -= 1;
			else if (givenstr.charAt(start) == 'G') chk[2] -= 1;					
			else if (givenstr.charAt(start) == 'T') chk[3] -= 1;
			
			if(givenstr.charAt(end) == 'A') chk[0] += 1;
			else if (givenstr.charAt(end) == 'C') chk[1] += 1;
			else if (givenstr.charAt(end) == 'G') chk[2] += 1;					
			else if (givenstr.charAt(end) == 'T') chk[3] += 1;
			

			for (int k = 0; k < 4; k++) {
				if (chk[k] < essential[k]) break;
				else if(k == 3) result += 1;
			}
			start++;
			end++;

		}
		System.out.println(result);

	}
}
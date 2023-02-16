import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		while(true){
			st = new StringTokenizer(br.readLine());
			char[] tmp = st.nextToken().toCharArray();
			if(tmp[0] == '#') break;
			boolean flag1 = false;
			while(true) {
				st = new StringTokenizer(br.readLine());
				char[] chk = st.nextToken().toCharArray();
				boolean flag = false;
				if(chk[0] == '#') break;
				int cnt = 0;
				
				for (int i = 0; i < tmp.length; i++) {
					cnt++;
					if(tmp[i] != chk[i] && flag) {
						flag1 = true;
						break;
					}else if(tmp[i] != chk[i] && !flag){
						flag = true;
					}
					if(tmp.length != chk.length) {
						flag1 = true;
						flag = false;
						break;
					}
				}
				//들어오는 문자열 2개가 동일한 경우를 고려하지 않
				if(cnt == tmp.length && !flag) {
					flag1 = true;
					flag = false;
				}//else if(cnt == tmp.length)
					//flag = false;
				tmp = chk;
			}
			if(!flag1){
				sb.append("Correct\n");
			}else {
				sb.append("Incorrect\n");
			}
		}
		System.out.println(sb);
	}

}
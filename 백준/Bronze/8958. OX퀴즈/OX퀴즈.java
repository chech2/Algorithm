import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			char [] list = br.readLine().toCharArray();
			Boolean flag = false;
			int	score =0, cnt = 0;
			for (int j = 0; j < list.length; j++) {
				if(list[j] == 'O'){
					cnt++;
					flag = false;
				}else {
					flag = true;
				}
				if(cnt != 0 && (flag || j == list.length -1)) {
					for (int num = 1; num <= cnt; num++) {
						score += num;
					}
					cnt = 0;
					flag = false;
				}
			}
			sb.append(score + "\n");
		}
		System.out.println(sb);
	}
}

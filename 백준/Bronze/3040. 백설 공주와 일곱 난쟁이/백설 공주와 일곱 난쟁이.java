import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int result [] = new int [9];
	static int dwarf [] = new int [9];
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		combi(0, 0);
		System.out.println(sb);
	
	}
	
	
	private static void combi(int cnt, int start) {
		if (cnt == 7) {
			int tmp = 0;
			for (int i = 0; i < 7; i++) tmp += result[i];
			if(tmp == 100) for (int i = 0; i < 7; i++) sb.append(result[i]).append("\n");
			return;
			
		}
		for (int i = start; i < 9; i++) {
			result[cnt] = dwarf[i];
			combi(cnt + 1, i + 1);
		}
	}

}
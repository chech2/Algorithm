import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(bs.readLine());
		int num1;
		int num2;
		StringTokenizer st;
		for (int i = 1; i < T + 1; i++) {
			st = new StringTokenizer(bs.readLine(), " ");
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			bw.write("Case #" + i + ": "+ num1 + " + " + num2 + " = " + (num1 + num2) + "\n");
		}
		bw.close();
	}
}

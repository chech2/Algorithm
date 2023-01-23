import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bs.readLine());
		for (int i = 1; i <= 2 * N; i++) {
			if(i <= N) {
				bw.write("*".repeat(i) + " ".repeat(N - i));
				bw.write(" ".repeat(N - i) + "*".repeat(i) + "\n");
			}
			else {
				bw.write("*".repeat(2 * N - i) + " ".repeat(i - N));
				bw.write(" ".repeat(i - N) + "*".repeat(2 * N - i) + "\n");
			}
		}
		bw.close();
	}
}
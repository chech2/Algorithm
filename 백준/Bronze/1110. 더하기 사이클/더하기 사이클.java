import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public int cal(int a) {
		int tens = a / 10;
		int units = a % 10;
		return units * 10 + (tens + units) % 10;
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N  = Integer.parseInt(bs.readLine());
		Main my = new Main();
		int cnt = 1;
		int NN = my.cal(N);
		while(N != NN) {
			NN = my.cal(NN);
			cnt++;
		}
		bw.write(Integer.toString(cnt));
		bw.close();
		}
	
}

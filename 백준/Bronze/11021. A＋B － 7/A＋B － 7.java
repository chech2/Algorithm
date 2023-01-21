import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		//int T = bw.write(br.read(System.in)); //버퍼에 넣을 필요도 없음 그냥 변수에 넣어서 사용하면 됨
												//System.in할 필요도 없음 이미 br은 그런아이로 new되었기 때문!
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");//일단 br.readLine를 이용하여 값을 입력받음
				 //그런 다음 토큰을 이용하여 값을 원하는 모양으로 변경함 (라인이 아니라 " "으로 구분되게)
			bw.write("Case #" + i + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n"); //st가 가지고 있는 값을 하나씩 꺼냄
		}
		bw.close();
	
	}
}

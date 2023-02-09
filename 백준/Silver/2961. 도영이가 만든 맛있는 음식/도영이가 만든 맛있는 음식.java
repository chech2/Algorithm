import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] flavor;
	static boolean [] boolflavor; //신맛
	static int min = 1000000000; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		//신맛 [][0], 쓴맛 [][1]에 저장
		flavor = new int[N][2];
		boolflavor = new boolean [N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}
		
		sum (0);
		System.out.println(min);
	}

	//공집합은 포함하지 않으므로 cnt는 1이상
	//재로 1개가 어차피 2개의 맛을 가지므로 구분 x
	private static void sum (int cnt) { // 0은 신맛, 1은 쓴맛
		if(cnt == N) {
			int sumsour = 1, sumbitter = 0, selectcnt = 0;
			for (int i = 0; i <N; i++) {
				if(boolflavor[i]) {
					selectcnt++;
					sumsour *= flavor[i][0];
					sumbitter += flavor[i][1];
				}
			}
			if(0 < selectcnt) 
				min = Math.min(Math.abs(sumsour - sumbitter), min);
			return;
		}
		boolflavor[cnt] = true;
		sum(cnt + 1);
		boolflavor[cnt] = false;
		sum(cnt + 1);
	}
}
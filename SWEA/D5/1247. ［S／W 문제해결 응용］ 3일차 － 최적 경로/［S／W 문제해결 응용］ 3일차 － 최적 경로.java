import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static node [] customer;
	static node [] permresult;
	static node end;
	static int result;
	
	static class node{
		int x;
		int y;
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T + 1; t++) {
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());  
			customer = new node[N];
			permresult = new node[N + 2]; //고객 + 회사 + 집
			st = new StringTokenizer(br.readLine());
			permresult[0] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));  //회사 주소 (x,y)
			end = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //집 주소 (x,y)

			for (int i = 0; i < N; i++) {
				customer[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //고객 주소 정보 저장 (x,y)
			}
			
			perm(0, 0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void perm(int cnt, int flag){
		
		//고객집 순회 순서 선택 완료
		if(cnt == N) {
			int len = 0;
			permresult[N + 1] = end;
			node cus1 = permresult[0];
			node cus2;
			for (int i = 1; i < N + 2; i++) {
				cus2 = permresult[i];
				len += Math.abs(cus1.x - cus2.x) + Math.abs(cus1.y - cus2.y);
				//System.out.println(cus1.x + " " + cus1.y + " " + cus2.x + " " + cus2.y + "                  " + (Math.abs(cus1.x - cus2.x) + Math.abs(cus1.y - cus2.y)));
				cus1 = cus2;
			}
			//System.out.println("===========================================================" + len);
			if(len < result) result = len;
			return;
		}
		
		for (int i = 0; i < N ; i++) {
			if((flag & (1 << i)) != 0) continue;
			permresult[cnt + 1] = customer[i];
			perm(cnt + 1, flag | (1 << i));
			
		}
	}
}
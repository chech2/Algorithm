import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Solution {

	static int Time; //이동 시간
	static int TotalCharge; // 입력 받을 총 충전기의 개수
	static int[] Person1; //사람1의 이동 정보 => 시작 위치 0,0
	static int[] Person2; //사람2의 이동 정보 => 시작 위치 9,9
	static int [][] chargerInfo; //충전기의 x,y 충전 범위, 충전량
	static int []dx = {0, -1, 0, 1, 0}; //놉상우하좌 
	static int []dy = {0, 0, 1, 0, -1}; //놉상우하좌 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		for (int t = 1; t < TC + 1; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			Time = Integer.parseInt(st.nextToken());
			TotalCharge = Integer.parseInt(st.nextToken());
			
			
			Person1 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 사람의 이동 정보를 int배열에 한번에 저장 
			Person2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int [] P1posi = {1,1}; //사람1의 초기 좌표
			int [] P2posi = {10,10}; //사람2의 초기 좌표 
			
			chargerInfo = new int [TotalCharge][4]; //충전기 정보 입력, 0번 충전기는 0번행에 저장
			for (int i = 0; i < TotalCharge; i++) {
				chargerInfo[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();  //충전기 정보 저장
			}
			int result = 0;
			for (int i = 0; i < Time + 1; i++) {
				//각 충전기마다 충전 범위 내부에 있는지 계산해서 집어넣을 것
				
				//사람1을 위한 충전 범위 
				PriorityQueue<int []> p1 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
				
				//사람2를 위한 충전범위 
				PriorityQueue<int []> p2 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

				//충전기와 사람의 거리 구하기
				for (int j = 0; j < TotalCharge; j++) {
					int tmp = Manhattan(chargerInfo[j], P1posi);
					int tmp2 = Manhattan(chargerInfo[j], P2posi);
//					System.out.println("확인 사항: "+"시간: "+i+ " 사용자 1 거리 : "  +tmp +" 사용자 2 거리 : " + tmp2);
//					System.out.println();
//					System.out.println("사람 1의 좌표: " + P1posi[0] + " " + P1posi[1]);
//					System.out.println("사람 2의 좌표: " + P2posi[0] + " " + P2posi[1]);

					
					
					if(tmp != -1) p1.offer(new int[] {tmp, j});
					if(tmp2 != -1) p2.offer(new int[] {tmp2, j});
				}
				
				//둘다 값이 있는 경우
				if(!p1.isEmpty() && !p2.isEmpty()){
					int []tmp = p1.poll();
					int []tmp2 = p2.poll();
					
					//같은 충전기를 공유
					if(tmp[1] == tmp2[1]) {
						if(!p1.isEmpty() && !p2.isEmpty()){
							int []tmp_2 = p1.poll();
							int []tmp2_2 = p2.poll();
							//System.out.println(i+ " " + tmp[0] + " " +  Math.max(tmp_2[0], tmp2_2[0]));
//							System.out.println("1: " + i + " " + tmp[0] + "   " + Math.max(tmp_2[0], tmp2_2[0]));
							
							result += tmp[0] + Math.max(tmp_2[0], tmp2_2[0]);
							
						}
						else if(!p1.isEmpty()) {
							int ttmp = p1.poll()[0];
//							System.out.println(i+ " " + tmp[0] + " " + ttmp);
//							System.out.println("2: " + i + " " + tmp[0] + "   " + ttmp);

							result += tmp[0] + ttmp;
						}else if(!p2.isEmpty()) {
							int ttmp = p2.poll()[0];
//							System.out.println("3: " + i + " " + tmp[0] + "   " + ttmp);

							result += tmp[0] + ttmp;
						}else {
//							System.out.println("4: " + i + " " + tmp[0]);

							result += tmp[0];
						}
					}
					//값은 둘다 있지만 다른 충전기를 사용하는 경우 같지 않은 경
					else {
						result += tmp[0] + tmp2[0];
					}
				}
				//둘중에 하나만 값이 있는 경우
				else if(!p1.isEmpty() || !p2.isEmpty()){
					if(!p1.isEmpty()) {
						int ttmp = p1.poll()[0];
//						System.out.println("p1 " +  + i+ " " + ttmp);
						
						result += ttmp;
					}
					else {
						int ttmp = p2.poll()[0];
						result += ttmp;
//						System.out.println("p2 " +  + i+ " " + ttmp);

					}
				}
				if(i < Time) {
				P1posi[0] += dx[Person1[i]]; //사람1의 x좌표 이동 
				P1posi[1] += dy[Person1[i]]; //사람1의 y좌표 이동 
				P2posi[0] += dx[Person2[i]]; //사람2의 x좌표 이동 
				P2posi[1] += dy[Person2[i]]; //사람2의 y좌표 이동 
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);			
	}
	public static int Manhattan (int [] charger, int []person) {
		int distance = Math.abs(person[0] - charger[1]) + Math.abs(person[1] - charger[0]);
		//System.out.println(distance);
		if(distance <= charger[2]) return charger[3];
		return -1;
	}	
}
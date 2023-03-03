import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.ForkJoinPool;

public class Solution {
	private static class Point{
		//cnt = 방문 처리를 위해서 벽돌의 파급효과를 나타내는 범위를 삭제할 것이기 때문에
		//어디까지 파급효과가 이어질지를 큐에 입력해주어야 해서 생성
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		
	}
	private static int [] dr = {-1,1,0,0};
	private static int [] dc = {0,0,-1,1};
	private static int N,W,H,min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int [][]map = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#"+t+" "+min);
		}
	}
	
	//구슬이 던져진 횟수, 벽돌 맵
	private static boolean go(int count, int [][]map) {
		//벽돌 개수 파악
		int result = getRemain(map);
		//냅다 던지기 전에 벽돌 남았는지 확인하기, 없으면 return
		//없는데 뭘 던짐, 걍 끝내야징
		if(result == 0) {
			min = 0;
			return true;
		}
		
		//기저 조건에 도달은 하였으나 벽돌을 다 뿌수지는 못함
		if(count == N) {
			min = Math.min(min, result);
			return false;
		}
		
		//벽돌 없앤 다음엔 되돌릴 수 없음 <- 되돌릴려면 필요
		int [][] newMap = new int[H][W];
	
		//모든 열에 구슬 던져보기
		for (int c = 0; c < W; c++) { //c:구슬 던지는 열
			
			//구슬에 처음 맞는 벽돌 찾기 (위쪽에서)
			int r = 0;
			//행을 벗어나지 않는 범위내에서 해당 열의 첫 벽돌 찾을 때까지 내려가기
			while(r < H && map[r][c] == 0) ++r;
			
			//해당 열에는 벽돌 없으니깐 다음 열 뿌시러 가자
			if(r == H) continue;
			
			//배열 원본의 상태로 초기화, 초기화하지 않으면 dfs or bfs로 들어가면서 나온 결과에 영향을 받음
			copy(map, newMap);
			
			//BFS벽돌 뿌수기
			//boom(newMap, r, c);
			
			//DFS벽돌 뿌수기
			boom(newMap, r, c, map[r][c]);
			
			//벽돌 내리기
			down(newMap);
			
			// 다음 구슬 던지러 가기
			if(go(count + 1, newMap)) return true;
			
			
		}
		return false;
	}

	//stack을 사용하면 쉬움(list든 뭐든 상관 없음 ), 0이면 버리고 stack에 집어넣는 방식, 3이면 남김
	private static Stack<Integer> stack = new Stack<>();
	private static void down(int [][]map) {
		//맨 위쪽부터 아래로 내려가면서 벽돌만 스택에 넣고, 아래행부터 채우기
		for (int c = 0; c < W; c++) { //열 고정 (행 돌아볼 동안)
			for (int r = 0; r < H; r++) {
				if(map[r][c] > 0) {
					stack.push(map[r][c]);
					map[r][c] = 0;
				}
			}
			int r = H - 1;
			while(!stack.isEmpty()) {
				map[r--][c] = stack.pop();
			}
		}		
	}

//	//BFS 벽돌 부수기 
//	private static void boom(int [][]map, int r, int c) {
//		Queue<Point> queue = new ArrayDeque<>();
//		if(map[r][c] > 1) {
//			queue.offer(new Point(r, c, map[r][c]));
//		}
//		//방문체크
//		map[r][c] = 0;
//		
//		Point current;
//		while(!queue.isEmpty()) {
//			current = queue.poll();
//			
//			//현 벽돌의 cnt - 1만큼 4방 체크,
//			//가다가 중간에 빈칸을 만나도 상관 ㄴㄴ, 계속 진행
//			//방향 1개 잡고 쭉 밀어버림
//			for (int d = 0; d < 4; d++) {
//				int nr = current.r;
//				int nc = current.c;				
//				for(int k = 1; k <= current.cnt - 1; k++) {
//					nr += dr[d];
//					nc += dc[d];
//					
//					//배열 내부 && 벽돌이 없다면 굳이 큐에 넣을 필요는 없음(방문 체크조차 필요 없음)
//					if(nr >= 0 && nr < H && nc >= 0 && nc < W 
//							&& map[nr][nc] > 0) {
//						
//						//처음 큐에 집어넣었을 때와 동일한 작업을 반복함
//						if(map[nr][nc] > 1) {
//							queue.offer(new Point(nr, nc, map[nr][nc]));
//						}
//						//방문체크
//						map[nr][nc] = 0;
//					}
//				}
//			}
//		}
//	}
	
	
	//DFS 벽돌 부수기 
	private static void boom(int [][]map, int r, int c, int cnt) {
	//첫 호출도 같은 로직으로 생각한다면 방문 체크와 재귀 호출의 여부 체크해야 됨
		map[r][c] = 0;
		if(cnt == 1) return;
		
		
		//현 벽돌의 cnt - 1만큼 4방 체크,
		//가다가 중간에 빈칸을 만나도 상관 ㄴㄴ, 계속 진행
		//방향 1개 잡고 쭉 밀어버림
		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;				
			for(int k = 1; k <= cnt - 1; k++) {
				nr += dr[d];
				nc += dc[d];
				
				//배열 내부 && 벽돌이 없다면 굳이 큐에 넣을 필요는 없음(방문 체크조차 필요 없음)
				if(nr >= 0 && nr < H && nc >= 0 && nc < W 
						&& map[nr][nc] > 0) {
					
				//처음 큐에 집어넣었을 때와 동일한 작업을 반복함
				boom(map,nr, nc, map[nr][nc]);
				}
			}
		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if(map[r][c] > 0) count++;
			} 
		}
		return count;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			} 
		}
	}

}
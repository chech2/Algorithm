import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //상,하,좌,우
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, M, ans, Lump;
    static int [][] map;
    static ArrayList<iceberg> icebergs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) icebergs.add(new iceberg(i, j, map[i][j]));
            }
        }
        while(true) {
            Lump = CntIceBerg();

            //빙하가 1덩어리인 경우
            if (Lump == 1) melt();
            //빙하가 2덩어리 이상인 경우
            if(Lump >= 2) break;
            //빙하가 다 녹은 경우
            if(Lump == 0) {
                ans = 0;
                break;
            }
            ans++;
        }
        System.out.println(ans);

    }
    static class iceberg {
        int x, y, size;

        iceberg(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
    static int CntIceBerg(){
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > 0 && !visited[i][j]){
                    DFS(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void DFS(int r, int c, boolean[][] visited){
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int x = dx[i] + r;
            int y = dy[i] + c;
            if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || map[x][y] <= 0) continue;
            DFS(x, y, visited);
        }
    }

    static void melt(){
        Queue<iceberg> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > 0) {
                    q.add(new iceberg(i, j, map[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            iceberg now = q.poll();

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x < 0 || x >= N || y < 0 || y >= M) continue;
                if(map[x][y] == 0 && !visited[x][y]) cnt++;
            }
            if(map[now.x][now.y] - cnt < 0) map[now.x][now.y] = 0;
            else map[now.x][now.y] -= cnt;

        }


    }
}
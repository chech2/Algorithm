import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int [][] map;
    static boolean [][] visited;

    //8방 탐색 필요: 상하좌우, 왼쪽 대각선: 위아, 오른쪽 대각선 위아
    static int[] dx={-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy={0, 0, -1, 1, -1, -1, 1, 1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;
        while (true){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            map = new int[N][M];
            visited = new boolean[N][M];
            ans = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
            t++;
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if(visited[nx][ny]) continue;

            if(map[nx][ny] != 1) continue;

            dfs(nx, ny);

        }
    }
}
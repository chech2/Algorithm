import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int map[][];
    static boolean visited[][];

    //상하좌우
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;
            }
        }
        System.out.println(ans);

    }

    static void dfs(int r, int c, int tmp, int cnt){
        if(cnt == 4){
            ans = Math.max(tmp, ans);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y]) continue;

            visited[x][y] = true;

            if(cnt == 2) dfs(r, c, tmp + map[x][y], cnt + 1);

            dfs(x, y, tmp + map[x][y] , cnt + 1);
            visited[x][y] = false;
        }
    }
}
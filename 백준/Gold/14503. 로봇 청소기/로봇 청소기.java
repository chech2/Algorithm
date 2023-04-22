import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //상, 오, 하, 왼
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int ans, N, M, d;
    static int[] robot = new int[2];
    static int[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ans++;

        st = new StringTokenizer(br.readLine());
        robot[0] = Integer.parseInt(st.nextToken());
        robot[1] = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(robot[0], robot[1], d);
        System.out.println(ans);
    }

    static  void dfs(int r, int c, int dir){
        map[r][c] = 2;

        int origin = dir;
        for (int i = 0; i < 4; i++) {
            int ndir = (dir + 3) % 4;

            int x = dx[ndir] + r;
            int y = dy[ndir] + c;

            //맵 벗어나는 경우
            if(x < 0 || x >= N || y < 0 || y >= M) continue;
            //벽 or 이미 청소완
            if(map[x][y] != 1 && map[x][y] != 2) {
                ans++;
                dfs(x, y, ndir);
                return;
            }
            dir = ndir;
        }
        int ndir = (origin + 2) % 4;

        //후진해야 하는 때
        int backX = r + dx[ndir];
        int backY = c + dy[ndir];
        //후진 불가
        if(0 <= backX && backX < N && 0 <= backY && backY < M && map[backX][backY] != 1){
            dfs(backX, backY, origin);
        }
    }
}
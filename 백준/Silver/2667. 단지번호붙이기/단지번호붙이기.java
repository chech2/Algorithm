import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
//map바껴도 상관 없음
public class Main {
    static int[][] map;

    //상, 하, 좌, 우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, group;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        group = 2;

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    dfs(i, j);
                    group++;
                }
            }
        }

        int []ans = new int[group];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) ans[map[i][j]]++;
            }
        }

        System.out.println(group - 2);
        Arrays.sort(ans);
        for (int i = 2; i < group; i++) {
            System.out.println(ans[i]);
        }
    }
    static void dfs(int x, int y){
        map[x][y] = group;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] != 1) continue;
            dfs(nx, ny);
        }
        visited[x][y] = false;
    }
}
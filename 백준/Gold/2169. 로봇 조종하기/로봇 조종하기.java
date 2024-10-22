import java.io.*;
import java.util.*;

public class Main {
    static final int MIN = -1000000;
    static int n, m, ans;
    static int[][] map;
    static int[][][] dp;
    static int[] dx = {1, 0, 0};
    static int[] dy = {0, -1, 1};
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur(0, 0,  0) + map[0][0]);
    }

    static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], MIN);
            }
        }
    }

    static int recur(int d, int r, int c){
        if(r == n - 1 && c == m - 1) return 0;

        if(dp[r][c][d] != MIN) return dp[r][c][d];
        int nx, ny;
        int rot = MIN;
        for(int i = 0; i < 3; i++){
            nx = r + dx[i];
            ny = c + dy[i];

            if(nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
            if((d == 1 && i == 2) || (d == 2 && i == 1)) continue;

            rot = Math.max(rot, recur(i, nx, ny) + map[nx][ny]);
        }

        return dp[r][c][d] = rot;
    }
}
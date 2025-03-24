import java.io.*;
import java.util.*;

public class Main {
    final static int MIN = -100000000;
    static int[] dx = {0, 1, 0};
    static int[] dy = {1, 0, -1};
    static int n, m;
    static int[][] map;
    static int[][][] dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        preSetting();    
        System.out.println(recur(0, 0, 0) + map[0][0]);
    }

    static int recur(int d, int x, int y){
        if(x == n - 1 && y == m - 1) return 0;
        if(dp[d][x][y] != -1) return dp[d][x][y];

        int nx, ny;
        int rot = MIN;
        for(int i = 0; i < 3; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(isImpossible(d, i, nx, ny)) continue;
            rot = Math.max(rot, recur(i, nx, ny) + map[nx][ny]);
        }
        return dp[d][x][y] = rot;
    }

    static boolean isImpossible(int d, int nd, int nx, int ny){
        if(nx < 0 || ny < 0 || n <= nx || m <= ny) return true;
        if(d == 0 && nd == 2 || d == 2 && nd == 0) return true;
        return false;
    }

    static void preSetting() throws Exception{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[3][n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < n; j++) Arrays.fill(dp[i][j], -1);
        }
    }
}

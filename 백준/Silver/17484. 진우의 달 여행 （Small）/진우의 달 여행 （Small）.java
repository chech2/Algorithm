import java.io.*;
import java.util.*;

public class Main {
    static int[][] d = {{0, 0}, {1, -1}, {1, 0}, {1, 1}};
    static int[][] map;
    static int[][][] dp;
    static int m, n, ans;
    public static void main(String[] args) throws Exception{
        preSetting();

        for(int i = 0; i < m; i++ ){
            ans = Math.min(ans, recur(0, 0, i) + map[0][i]);
        }
        System.out.println(ans);
    }

    private static int recur(int preD, int x, int y){
        if(x == n - 1) return 0;
        if(dp[x][y][preD] != -1) return dp[x][y][preD];
        int nX, nY;
        int rot = Integer.MAX_VALUE;
        for(int i = 1; i < 4; i++){
            if(i == preD) continue;

            nX = d[i][0] + x;
            nY = d[i][1] + y;

            if(n < nX || m <= nY || nY < 0) continue;

            rot = Math.min(rot, recur(i, nX, nY) + map[nX][nY]);
        }
        return dp[x][y][preD] = rot;
    }

    private static void preSetting() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n][m][4];

        map = new int[n][m];
        ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
}

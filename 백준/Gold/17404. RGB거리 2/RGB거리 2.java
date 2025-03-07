import java.io.*;
import java.util.*;

public class Main {
//    static final int MIN = -5000000;
    static final int MAX = 5000000;
    static int n, ans;
    static int[][][] dp;
    static int[][] map;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        preSetting();
        for(int i = 0; i < 3; i++) ans = Math.min(dfs(1, i, i) + map[0][i], ans);
        
        System.out.println(ans);
    }

    static int dfs(int cnt, int s, int preColor){
        if(cnt == n){
            if(preColor == s) return MAX;
            return 0;
        }
        if(dp[cnt][s][preColor] != -1) return dp[cnt][s][preColor];

        int rot = MAX;
        for(int i = 0; i < 3; i++){
            if(i == preColor) continue;
            rot = Math.min(dfs(cnt + 1, s, i) + map[cnt][i], rot);
        }
        return dp[cnt][s][preColor] = rot;
    }

    static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        dp = new int[n][3][3];
        ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], -1);
            }
        }
    }

}
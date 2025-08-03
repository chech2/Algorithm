import java.io.*;
import java.util.*;

public class Main {
    static int[][] house, dp;
    static int n, ans;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();

        System.out.println(subSet(0, 0));
    }

    static int subSet(int cnt, int pre){
        if(cnt == n) return 0;
        if(dp[cnt][pre] != Integer.MAX_VALUE) return dp[cnt][pre];

        int rot = Integer.MAX_VALUE;
        for(int i = 1; i < 4; i++){
            if(pre == i) continue;

            dp[cnt][pre] = Math.min(subSet(cnt + 1, i) + house[cnt][i], dp[cnt][pre]);
        }
        return dp[cnt][pre];
    }

    static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        house = new int[n][4];
        dp = new int[n + 1][4];
        ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < 4; j++) house[i][j] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Arrays.fill(dp[n], Integer.MAX_VALUE);
    }
}
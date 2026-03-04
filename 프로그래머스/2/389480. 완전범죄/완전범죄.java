import java.util.*;

class Solution {
    int[][][] dp;
    int[][] info;
    int n, m, CNT;
    public int solution(int[][] info, int n, int m) {
        CNT = info.length;
        this.info = info;
        this.n = n;
        this.m = m;
        dp = new int[CNT][n][m];
        
        for(int i = 0; i < CNT; i++){
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        
        int answer = recur(0, 0, 0);
        if(answer == 1000) answer = -1;
        
        return answer;
    }
    
    private int recur(int cnt, int a, int b){
        if(cnt == CNT) return 0;
        if(dp[cnt][a][b] != -1) return dp[cnt][a][b];
        
        dp[cnt][a][b] = 1000;
        if(a + info[cnt][0] < n) dp[cnt][a][b] = Math.min(dp[cnt][a][b], recur(cnt + 1, a + info[cnt][0], b) + info[cnt][0]);
        if(b + info[cnt][1] < m) dp[cnt][a][b] = Math.min(dp[cnt][a][b], recur(cnt + 1, a, b + info[cnt][1]));
        
        return dp[cnt][a][b];
    }
}
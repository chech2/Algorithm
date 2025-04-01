import java.util.*;

class Solution {
    int n, m, size;
    int[][] info;
    int[][][] dp;
    
    public int solution(int[][] info, int n, int m) {
        preSetting(info, n, m);
        int answer = recur(0, 0, 0);
        
        if(500 <= answer) answer = -1;
        return answer;
    }
    
    int recur(int cnt, int a, int b){
        if(n <= a || m <= b) return 500;
        if(cnt == size) return 0;
        if(dp[cnt][a][b] != -1) return dp[cnt][a][b];
        
        dp[cnt][a][b] = recur(cnt + 1, a + info[cnt][0], b) + info[cnt][0];
        return dp[cnt][a][b] = Math.min(dp[cnt][a][b], recur(cnt + 1, a, b + info[cnt][1]));
    }
        
    void preSetting(int[][] info, int n, int m){
        this.info = info;
        this.n = n;
        this.m = m;
        this.size = info.length;
        dp = new int[size][n][m];
            
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < n; j++) Arrays.fill(dp[i][j], -1);
        }
    }
}
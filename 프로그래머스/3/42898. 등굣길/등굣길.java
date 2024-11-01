import java.util.*;

class Solution {
    final int mod = 1000000007;    
    int m, n, ans;
    int[][] memo, map;
    int[] dx = {1, 0};
    int[] dy = {0, 1};
    
    public int solution(int m, int n, int[][] puddles) {
        pre_setting(m, n, puddles);
        
        int answer = recur(0, 0);
        return answer;
    }
    
    int recur(int x, int y){
        if(x == m - 1 && y == n - 1) return 1;
        if(memo[x][y] != 0) return memo[x][y];
        
        int nx, ny;
        int rot = 0;
        for(int i = 0; i < 2; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            
            if(m <= nx || n <= ny || map[nx][ny] == 1) continue;
            
            rot += recur(nx, ny);
        }
        return memo[x][y] = rot % mod;
    }
    
    
    void pre_setting(int m, int n, int[][] puddles){
        this.m = m;
        this.n = n;
        this.map = new int[m][n];
        this.memo = new int[m][n];
        
        int x, y;
        for(int i = 0; i < puddles.length; i++){
            x = puddles[i][0] - 1;
            y = puddles[i][1] - 1;
            
            map[x][y] = 1;
        }
    }
}
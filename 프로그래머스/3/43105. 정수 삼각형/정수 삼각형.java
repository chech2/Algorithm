import java.util.*;

class Solution {
    int depth;
    int[][] tree, dp;
    int[] dx = {1, 1};
    int[] dy = {0, 1};
    public int solution(int[][] triangle) {
        pre_setting(triangle);

        int answer = recur(0, 0) + tree[0][0];
        return answer;
    }
    
    
    int recur(int x, int y){
        if(x == depth) return 0;
        if(dp[x][y] != 0) return dp[x][y];
        int nx, ny, rot;
        rot = 0;
        for(int i = 0; i < 2; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            
            if(depth <= nx || ny < 0) continue;
            rot = Math.max(rot, recur(nx, ny) + tree[nx][ny]);
        }
        return dp[x][y] = rot;
    }
    
    void pre_setting(int[][] triangle){
        tree = triangle;
        depth = triangle.length;
        dp = new int[depth][tree[depth - 1].length + 1];
    }
}
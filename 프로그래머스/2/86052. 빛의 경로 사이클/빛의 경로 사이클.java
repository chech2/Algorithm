import java.util.*;
 
class Solution {
    int m, n, idx;
    
    //상우좌하
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    boolean[][][] visited;
    int[] answer;
 
    public int[] solution(String[] grid) {
        m = grid.length;
        n = grid[0].length();
        answer = new int[n * m * 4];
 
        visited = new boolean[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[i][j][d]) answer[idx++] = go(grid, i, j, d );
                }
            }
        }
        answer = Arrays.copyOfRange(answer, 0, idx);
        Arrays.sort(answer);
        return answer;
    }
 
    int go(String[] grid, int r, int c, int d) {
        int cnt = 0;
 
        while (true) {
            if (visited[r][c][d]) break;
 
            cnt++;
            visited[r][c][d] = true;
 
            if (grid[r].charAt(c) == 'L'){
                if(d == 0) d = 3;
                else d -= 1;
                
            }else if (grid[r].charAt(c) == 'R'){
                if(d == 3) d = 0;
                else d += 1;
            }
            
            r = (r + dx[d] + m) % m;
            c = (c + dy[d] + n) % n;
        }
 
        return cnt;
    }
}
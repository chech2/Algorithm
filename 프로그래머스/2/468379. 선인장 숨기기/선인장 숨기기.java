import java.util.*;

class Solution {
    int time = 0;
    int h, w, max, result;
    int[][] map, row, col;
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = new int[2];
        preSetting(m, n, h, w, drops);        

        int num = max;
        for(int i = 0; i < m; i++) silde(map[i], n, w, col[i]);
        int[] tmp = new int[m];
        int[] out = new int[m - h + 1];
        for(int i = 0; i < n - w + 1; i++) {
            for(int j = 0; j < m; j++) tmp[j] = col[j][i];
            silde(tmp, m, h, out);
            for(int j = 0; j < m - h + 1; j++) row[j][i] = out[j];
        }
        for(int i = 0; i < m - h + 1; i++){
            for(int j = 0; j < n - w + 1; j++){
                if(result < row[i][j]){
                    result = row[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
    
    private void silde(int[] src, int size, int len, int[] d){
        Deque <Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < size; i++){
            while(!q.isEmpty() && src[i] <= src[q.peekLast()]) q.pollLast();
            q.add(i);
            if(q.peek() <= i - len) q.poll();
            if(len - 1 <= i) d[i - len + 1] = src[q.peek()];
        }
    }

    
    private void preSetting(int m, int n, int h, int w, int[][] drops){
        this.h = h;
        this.w = w;
        map = new int[m][n];
        col = new int[m][n - w + 1];
        row = new int[m - h + 1][n - w + 1];

        max = drops.length + 2;  
        
        for(int i = 0; i < m; i++) {
            Arrays.fill(map[i], max);
            Arrays.fill(col[i], max);
        }
        
        for(int i = 0; i < m - h + 1; i++) Arrays.fill(row[i], max);
        for(int i = 0; i < drops.length; i++) map[drops[i][0]][drops[i][1]] = i + 1;
    }
}
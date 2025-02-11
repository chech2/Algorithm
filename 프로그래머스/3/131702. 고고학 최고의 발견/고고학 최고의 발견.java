import java.util.*;

class Solution {
    int[] dx = {0, -1, 0, 1, 0};
    int[] dy = {0, 0, 1, 0, -1};
    
    int n, ans;
    int[][] origin;
    public int solution(int[][] clockHands) {
        int answer = 0;
        preSetting(clockHands);
        dfs(new int[n], 0);        
        
        return ans;
    }
    
    int[][] clonePuzzle(int[] rotation){
        int[][] clonetest = new int[n + 1][n];
        Arrays.setAll(clonetest[0], (col) -> rotation[col]);
         
        for(int i = 0; i < n; i++){
            int row = i;
            Arrays.setAll(clonetest[i + 1], (col) -> origin[row][col]);
        }
    
        return clonetest;
    }
    
  
    // rotation: 첫번째 행의 회전관련 데이터 저장 배열: 
    // 만약 2라면 2 -> 0으로 바꿀 수 있도록 rotationPuzzle함수에서 처리할 예정
    void dfs(int[] rotation, int depth){
        
        if(depth == n){ // 회전 진행
            int[][] clone = clonePuzzle(rotation);
            ans = Math.min(rotationPuzzle(clone), ans);
            return;
        }
        
        for(int d = 0; d < 4; d++) {
            rotation[depth] = d;
            dfs(rotation, depth + 1);
        }
    }
    
   
    
    int rotationPuzzle(int[][] puzzle){
        int move = 0;
        int nx, ny, degree;
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < n; j++){                
                degree = (4 - puzzle[i - 1][j]) % 4;
                move += degree;
                
                if(degree == 0) continue;
                for(int d = 0; d < 5; d++){
                    nx = i + dx[d];
                    ny = j + dy[d];
                    
                    if(nx < 0 || n < nx || ny < 0 || n <= ny) continue;
                    puzzle[nx][ny] = (puzzle[nx][ny] + degree) % 4;
                }
            }
        }
        if(!isZero(puzzle)) return Integer.MAX_VALUE;
        return move;
    }
    
    boolean isZero(int[][] puzzle){
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < n; j++){
                if(puzzle[i][j] != 0) return false;
            }
        }
        
        return true;
    }
    
    void preSetting(int[][] clockHands){
        origin = clockHands;
        n = clockHands.length;
        ans = Integer.MAX_VALUE;
    }
}
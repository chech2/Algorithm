import java.util.*;

/*
    전략
        1. bfs로 맵의 석유를 체크
            -> 각 덩어리별 석유 크기 저장 (리스트)
            -> Land에 덩어리 번호로 체크
        2. 500^2으로 돌면서 열 마다 개수 세기(완탐)
*/

class Solution {
    List<Integer> oil;
    int[][] land;
    boolean[][] visited;
    int n, m;
    
    public int solution(int[][] land) {
        pre_setting(land);
        return search_oil();
    }
    
    int search_oil(){
        boolean[] oil_check = new boolean[oil.size() + 1];
        int sum, cnt, answer;
        
        answer = 0;
        for(int j = 0; j < m; j++){
            sum = 0;
            Arrays.fill(oil_check, false);
            
            for(int i = 0; i < n; i++){
                cnt = land[i][j];
                if(cnt == 0 || oil_check[cnt]) continue;
                oil_check[cnt] = true;
                sum += oil.get(cnt - 1);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    
    void pre_setting(int[][] land){
        n = land.length;
        m = land[0].length;
        oil = new ArrayList<>();
        this.land = land;
        
        int oilCnt = 1;
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || this.land[i][j] == 0) continue;
                oil.add(bfs(i, j, oilCnt++));
            }
        }
    }
    
    int bfs(int x, int y, int num){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 1;
        Queue<node> q = new ArrayDeque<>();
        q.add(new node(x, y, num));
        visited[x][y] = true;
        land[x][y] = num;
        
        node now;
        int nx, ny;
        while(!q.isEmpty()){
            now = q.poll();
            
            for(int i = 0; i < 4; i++){
                nx = now.x + dx[i];
                ny = now.y + dy[i];
                
                if(nx < 0 || n <= nx || ny < 0 || m <= ny || visited[nx][ny] || land[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                land[nx][ny] = num;
                q.add(new node(nx, ny, num));
                cnt++;
            }  
        }
        return cnt;
    }
    
}

class node{
    int x, y, oilCnt;
    node(int x, int y, int oilCnt){
        this.x = x;
        this.y = y;
        this.oilCnt = oilCnt;
    }
}
import java.util.*;

class Solution {
    final char WALL = 'X';
    char[][] maps;
    char[] targets = {'L', 'E'};
    boolean[][] visited;
    int[][] start_point;
    int r_size, l_size;
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        pre_setting(maps);
        
        int answer = 0;
        for(int i = 0; i < 2; i++){
            answer += bfs(start_point[i][0], start_point[i][1], targets[i]);
            if(answer < 0) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
    
    int bfs(int sx, int sy, char target){
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        visited = new boolean[r_size][l_size];
        visited[sx][sy] = true; 

        q.add(new node(sx, sy, 0));
        
        node now;
        int nx, ny;
        while(!q.isEmpty()){
            now = q.poll();
            
            if(maps[now.x][now.y] == target) return now.time;
            for(int i = 0; i < 4; i++){
                nx = now.x + dx[i];
                ny = now.y + dy[i];
                
                if(nx < 0 || r_size <= nx || ny < 0 || l_size <= ny 
                   || visited[nx][ny] || maps[nx][ny] == WALL) continue;
                visited[nx][ny] = true;
                q.add(new node(nx, ny, now.time + 1));
            }
        }
        return -50000;
    }
    
    void pre_setting(String[] string_maps){
        r_size = string_maps.length;
        l_size = string_maps[0].length();
        
        maps = new char[r_size][l_size];
        start_point = new int[3][2];
        
        char[] tmp;
        char now;
        for(int i = 0; i < r_size; i++){
            tmp = string_maps[i].toCharArray();
            for(int j = 0; j < l_size; j++){
                now = tmp[j];
                
                if(now == 'S') {
                    start_point[0][0] = i;
                    start_point[0][1] = j;
                }else if(now == 'L'){
                    start_point[1][0] = i;
                    start_point[1][1] = j;
                }
                maps[i][j] = now;
            }
        }
    }
    
    class node{
        int x, y, time;
        
        node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    
}
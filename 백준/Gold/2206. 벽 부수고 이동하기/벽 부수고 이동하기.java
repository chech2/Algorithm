import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        pre_setting();
        bw.append(String.valueOf(bfs()));
        bw.close();
    }

    static int bfs(){
        ArrayDeque<node> q = new ArrayDeque<>();
//        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);
        q.add(new node(0, 0, 1, 0));
        visited[0][0][0] = true;


        node now, next;
        int nx, ny;
        while(!q.isEmpty()){
            now = q.poll();

            if(now.x == n - 1 && now.y == m - 1) return now.t;
            for(int i = 0; i < 4; i++){
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if(nx < 0 || n <= nx || ny < 0 || m <= ny || visited[now.wall][nx][ny]) continue;
                if(map[nx][ny] == 1 && now.wall == 0) {
                    visited[1][nx][ny] = true;
                    q.add(new node(nx, ny, now.t + 1, 1));
                }
                else if(map[nx][ny] == 0) {
                    visited[now.wall][nx][ny] = true;
                    q.add(new node(nx, ny, now.t + 1, now.wall));
                }
            }
        }
        return -1;
    }



    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[2][n][m];

        String[] tmp;
        for(int i = 0; i < n; i++){
            tmp = br.readLine().split("");

            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
    }

    static class node{
        int x, y, t, wall;

        node(int x, int y, int t, int wall){
            this.x = x;
            this.y = y;
            this.t = t;
            this.wall = wall;
        }
    }
}
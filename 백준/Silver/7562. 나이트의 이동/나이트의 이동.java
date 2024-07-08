import java.io.*;
import java.util.*;

public class Main {

    static int t, n;
    static node[] p;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            input();
            if(!(p[0].x == p[1].x && p[0].y == p[1].y)) sb.append(bfs());
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int bfs(){
        Queue<node> q = new ArrayDeque<>();
        q.add(p[0]);
        visited[p[0].x][p[0].y] = true;
        int ans = 0;

        node now;
        int nx, ny, size;
        while (!q.isEmpty()){
            size = q.size();

            for (int rot = 0; rot < size; rot++) {
                now = q.poll();

                if(now.x == p[1].x && now.y == p[1].y) return ans;

                for (int i = 0; i < 8; i++) {
                    nx = now.x + dx[i];
                    ny = now.y + dy[i];

                    if(nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.add(new node(nx, ny));

                }
            }
            ans++;
        }
        return -1;
    }

    static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        p = new node[2];

        int x, y;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            p[i] = new node(x, y);
        }
    }

    static class node{
        int x, y;

        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
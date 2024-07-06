import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        game();
    }

    public static void game(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) continue;
                ans = Math.max(bfs(new node(i, j)), ans);
            }
        }
        System.out.println(ans);
    }

    public static int bfs(node start){
//        System.out.println();
//        System.out.println("start: " + start.x + " " + start.y);
        int size, nx, ny, ans;
        node now;
        ArrayDeque<node> q = new ArrayDeque<>();
        visited = new boolean[n][m];
        visited[start.x][start.y] = true;
        q.add(start);

        ans = 0;
        while (!q.isEmpty()){
            size = q.size();

            for (int i = 0; i < size; i++) {
                now = q.poll();

                for (int j = 0; j < 4; j++) {
                    nx = now.x + dx[j];
                    ny = now.y + dy[j];

                    if(nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
                    if(visited[nx][ny] || map[nx][ny] == 0) continue;

                    visited[nx][ny] = true;
                    q.add(new node(nx, ny));
                }
            }
            ans++;
        }
        return ans - 1;
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char now : br.readLine().toCharArray()) {
                if(now == 'L') map[i][j] = 1;
                else map[i][j] = 0;
                j++;
            }
        }
    }

    public static class node{
        int x, y;
        node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
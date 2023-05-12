import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int TC, N, ans;
    static int[][] posi;
    static boolean visited[][];
    static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int dy[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            posi = new int[2][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                posi[i][0] =  Integer.parseInt(st.nextToken());
                posi[i][1] =  Integer.parseInt(st.nextToken());
            }
            ans = Integer.MAX_VALUE;

            bfs();
        }
    }

    static void bfs(){ //posi[0][0], posi[0][1],
        Queue<node> q = new ArrayDeque<>();
        q.add(new node(posi[0][0], posi[0][1], 0));

        visited[posi[0][0]][posi[0][1]] = true;

        while(!q.isEmpty()){
            node now = q.poll();
            int x = now.x;
            int y = now.y;
            if(x == posi[1][0] && y == posi[1][1]) {
                System.out.println(now.time);
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new node(nx, ny, now.time + 1));
            }
        }
    }

    static class node{
        int x, y, time;
        node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}
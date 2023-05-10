import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int map[][];
    static boolean visited[][];
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        Queue<node> q = new ArrayDeque<>();
        q.add(new node(0, 0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()){
            node now = q.poll();
            if(now.x == N - 1 && now.y == M - 1){
                System.out.println(now.time + 1);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != 1) continue;
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
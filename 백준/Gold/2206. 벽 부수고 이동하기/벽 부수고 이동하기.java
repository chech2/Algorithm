import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M,ans;
    static boolean visited[][][];
    static int map[][];

    //상하좌우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<node> q = new ArrayDeque<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        ans = -1;

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        q.add(new node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()){
            node now = q.poll();
//            System.out.println(now.x + " " + now.y + " " + now.one_cnt);
            if(now.x == N - 1 && now.y == M - 1){
                ans = now.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if(x < 0 || x >= N || y < 0 || y >= M) continue;
                if(visited[x][y][now.one_cnt]) continue;
                if(map[x][y] == 1){
                    if(now.one_cnt == 1) continue;
                    else if(now.one_cnt == 0) {
                        visited[x][y][now.one_cnt] = true;
                        q.add(new node(x, y, now.time + 1, 1));
                    }
                }
                else{
                    visited[x][y][now.one_cnt] = true;
                    q.add(new node(x, y, now.time + 1, now.one_cnt));
                }
            }
        }
//        if(ans == -1) System.out.println(0);
         System.out.println(ans);
    }

    static class node{
        int x, y, time, one_cnt;
        node(int x, int y, int time, int one_cnt) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.one_cnt = one_cnt;
        }
    }
}
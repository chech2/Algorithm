import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    //상하좌우
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int map[][], money[][];
    static boolean[][] check;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int cnt = 1;
        while(N != 0) {
            map = new int[N][N];
            money = new int[N][N];
            check = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            check[0][0] = true;
            bfs();
            sb.append("Problem ").append(cnt).append(": ").append(money[N - 1][N - 1]).append("\n");
            cnt++;
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }

    static void bfs(){
        PriorityQueue <node> q = new PriorityQueue<>((n1, n2) -> n1.coin - n2.coin);
        q.add(new node(0,0, map[0][0]));

        while(!q.isEmpty()){
            node now = q.poll();
            int x = now.x;
            int y = now.y;
            int coin = now.coin;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if(!check[nx][ny]){
                        money[nx][ny] = map[nx][ny]  + coin;
                        q.add(new node(nx, ny, money[nx][ny]));
                        check[nx][ny] = true;

                    }else if(coin + map[nx][ny] < money[nx][ny]) {
                        money[nx][ny] = map[nx][ny] + coin;
                        q.add(new node(nx, ny, money[nx][ny]));
                    }
                }
            }

        }
    }

    static class node{
        int x;
        int y;
        int coin;

        public node(int x, int y, int coin){
            this.x = x;
            this.y = y;
            this.coin = coin;
        }
    }
}
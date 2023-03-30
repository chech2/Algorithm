import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int result = Integer.MIN_VALUE;
    static int [][] OriginMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        OriginMap = new int [N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                OriginMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int cnt) {
        if(cnt == 3){
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (OriginMap[i][j] == 0){
                    OriginMap[i][j] = 1;
                    dfs(cnt + 1);
                    OriginMap[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int []> q = new ArrayDeque<>();
        boolean check[][] = new boolean[N][M];
        int [][] CopyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            CopyMap[i] = OriginMap[i].clone();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(CopyMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                    check[i][j] = true;
                }
            }
        }

        //상,하,좌,우
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        while(!q.isEmpty()){
            int []now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M && !check[nx][ny]){
                    if(CopyMap[nx][ny] == 0) {
                        CopyMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                        check[nx][ny] = true;
                    }
                }
            }
        }
        Counting(CopyMap);
    }

    private static void Counting(int[][] copyMap) {
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0)
                    tmp++;
            }
        }
        result = Math.max(tmp, result);
    }
}
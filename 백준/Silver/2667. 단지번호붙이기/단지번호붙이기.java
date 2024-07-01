import java.io.*;
import java.util.*;
public class Main {
    static int n, ans;
    static int[][] map;
    //상, 우, 하, 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        input();

        int cnt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    cnt = 0;
                    map[i][j] = ans;
                    dfs(i, j, cnt);
                    ans++;
                }
            }
        }
        count();
        System.out.println(sb);
    }

    public static void count(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0) result[map[i][j]]++;
            }
        }

        for (int i = 0; i < result.length; i++) if(result[i] != 0) q.add(result[i]);

        sb.append(q.size()).append("\n");
        while(!q.isEmpty()){
            sb.append(q.poll()).append("\n");
        }
    }
    public static void dfs(int x, int y, int cnt){
        int r, c;

        for (int i = 0; i < 4; i++) {
            r = x + dx[i];
            c = y + dy[i];

            if(r < 0 || n <= r || c < 0 || n <= c) continue;
            if(map[r][c] != 1) continue;

            map[r][c] = ans;
            dfs(r, c, cnt + 1);
        }
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new int[n * (n + 1) / 2];
        ans = 2;

        String[] str;
        for (int i = 0; i < n; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
    }

}
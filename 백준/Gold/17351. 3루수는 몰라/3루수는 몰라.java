import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Integer> MOLA;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int[][][] dp;
    static int n, ans;
    static char[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();

        System.out.println(recur(0, 0, MOLA.getOrDefault(map[0][0], 0)));
    }

    static int recur(int x, int y, int pre){
        if(x == n - 1 && y == n - 1) return 0;
        if(dp[pre][x][y] != -1) return dp[pre][x][y];
        int nx, ny, now, rot;

        rot = 0;
        for(int i = 0; i < 2; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue;

            now = MOLA.getOrDefault(map[nx][ny], 0);

            if (now == 4 && pre == 3) rot = Math.max(rot, recur(nx, ny, 0) + 1);
            else if (pre + 1 == now || now == 1) rot = Math.max(rot,recur(nx, ny, now));
            else rot = Math.max(rot,recur(nx, ny,0));

        }
        return dp[pre][x][y] = rot;
    }

    static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        MOLA = new HashMap<>();
        dp = new int[5][n][n];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < n; j++) Arrays.fill(dp[i][j], -1);
        }

        for(int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();
        MOLA.put('M', 1);
        MOLA.put('O', 2);
        MOLA.put('L', 3);
        MOLA.put('A', 4);
    }
}
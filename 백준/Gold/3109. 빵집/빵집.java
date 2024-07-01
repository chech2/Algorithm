import java.io.*;
import java.util.*;

public class Main {

    static int R, C, ans;
    static char[][] map;
    static boolean[][] visited;
    static int[] d = {-1, 0, 1};   //우, 대우위, 대우좌 => y좌표는 항상 +1
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        input();

        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }
        System.out.println(ans);
    }

    public static boolean dfs(int x, int y){
        if(y == C - 1){
            ans++;
            return true;
        }

        int nx, ny;
        ny = y + 1;
        for (int i = 0; i < 3; i++) {
            nx = x + d[i];
            if(nx < 0 || R <= nx || C <= ny || visited[nx][ny] || map[nx][ny] == 1) continue;

            visited[nx][ny] = true;
            if(dfs(nx, ny)) return true;
        }
        return false;
    }

    public static void input() throws Exception{
        String[] tmp = br.readLine().split(" ");
        R = Integer.parseInt(tmp[0]);
        C = Integer.parseInt(tmp[1]);

        map = new char[R][C];
        visited = new boolean[R][C];

        char[] chartmp;
        for (int i = 0; i < R; i++) {
            chartmp = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if(chartmp[j] == '.') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int [][] d = {{1, -1}, {1, 0}, {1, 1}};
    static int [][] map;
    static int m, n, ans;
    public static void main(String[] args) throws Exception{
        preSetting();
        for(int i = 0; i < m; i++ ){
            recur(-1, 0, i, map[0][i]);
        }
        System.out.println(ans);
    }

    private static void recur(int preD, int x, int y, int oil){
        if(x == n - 1){
            ans = Math.min(ans, oil);
            return;
        }

        int nX, nY;
        for(int i = 0; i < 3; i++){
            if(i == preD) continue;

            nX = d[i][0] + x;
            nY = d[i][1] + y;

            if(n < nX || m <= nY || nY < 0) continue;

            recur(i, nX, nY, oil + map[nX][nY]);
        }
    }

    private static void preSetting() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

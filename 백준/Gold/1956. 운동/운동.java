import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int v, e, ans;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        ans = 5000000;
        map = new int[v + 1][v + 1];
        for (int i = 1; i < v + 1; i++) {
            Arrays.fill(map[i], 5000000);
        }

        int start, end, distance;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            map[start][end] = distance;
        }

        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if(i == k || j == k) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            ans = Math.min(map[i][i], ans);
        }
        if(ans == 5000000) System.out.println(-1);
        else System.out.println(ans);
    }
}
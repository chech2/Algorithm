import java.io.*;
import java.util.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int[][] map, memo;
    public static void main(String[] args) throws Exception{
        input();
        for (int i = 0; i < 3; i++) {
            recur(0, i);
//            System.out.println(recur(0, i));
        }
        System.out.println(Math.min(memo[0][0], Math.min(memo[0][1], memo[0][2])));


    }

    public static int recur(int cnt, int color){
        if(cnt == n) return 0;
        if(memo[cnt][color] != 1000000) return memo[cnt][color];

        for (int i = 0; i < 3; i++) {
            if(color == i) continue;

            memo[cnt][color] = Math.min(memo[cnt][color], recur(cnt + 1, i) + map[cnt][i]);
        }
        return memo[cnt][color];
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());

        map = new int[n][3];
        memo = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(memo[i], 1000000);

            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
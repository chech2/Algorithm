import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][][] memo;
    static int[][] map;

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        memo = new int[N + 1][N + 1][3];
        map = new int[N + 1][N + 1];

        memo[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) continue;
                //대각선에서 오는 경우는 가로도 되고, 세로도 되므로 값을 가로/세로에 더해줘야 됨
                memo[i][j][0] += (memo[i][j - 1][0] + memo[i][j - 1][2]);
                memo[i][j][1] += (memo[i - 1][j][1] + memo[i - 1][j][2]);

                if(map[i - 1][j] != 1 && map[i][j - 1] != 1)
                    memo[i][j][2] += (memo[i - 1][j - 1][2] + memo[i - 1][j - 1][1] + memo[i - 1][j - 1][0]);
            }
        }

        System.out.println(memo[N][N][0] + memo[N][N][1] + memo[N][N][2]);
    }
}
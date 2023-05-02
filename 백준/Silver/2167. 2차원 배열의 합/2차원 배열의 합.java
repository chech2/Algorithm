import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, ans, sX, sY, eX, ey;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            sX = Integer.parseInt(st.nextToken());
            sY = Integer.parseInt(st.nextToken());
            eX = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            for (int i = sX; i <= eX; i++) {
                for (int j = sY; j <= ey; j++) {
                    ans += arr[i][j];
                }
            }
            System.out.println(ans);
        }

    }
}
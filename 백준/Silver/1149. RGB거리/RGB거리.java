import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] house, memo;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        //빨,초,파
        house = new int[N + 1][3];
        memo = new int[N + 1][3];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());

            dp(i);
        }
        System.out.println(Math.min(Math.min(memo[N][0], memo[N][1]), memo[N][2]));

    }

    /*
        현재 색상을 선택하고, 해당 색상 선택했을 것 별로 이전 최솟값이랑 해서 더하기
    */

    public static void dp(int now){
        memo[now][0] = Math.min(memo[now - 1][1], memo[now - 1][2]) + house[now][0];
        memo[now][1] = Math.min(memo[now - 1][0], memo[now - 1][2]) + house[now][1];
        memo[now][2] = Math.min(memo[now - 1][0], memo[now - 1][1]) + house[now][2];
    }

}
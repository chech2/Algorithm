import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
        하나의 스티커를 제거하면 4방으로 스티커를 사용할 수 없다.
        각 스티커에 점수를 매긴 후, 스티커를 선택했을 때 합이 최대가 되도록 해야한다.
        대각선으로 이동이 가능하다 => 오 -> 왼의 이동만 보기 (반대의 경로는 일단 생각하지 않음)
    */
    static int N, TC;
    static int[][] origin, memo;

    //왼쪽 대각선 위, 왼쪽 대각선 위에서 한칸 왼쪽으로 이동
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            N = Integer.parseInt(br.readLine());
            origin = new int[2][N + 1];
            memo = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Arrays.fill(memo[i], -1);
                for (int j = 1; j < N + 1; j++) {
                    origin[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            /////////input값 저장 완료

            memo[0][0] = 0;
            memo[1][0] = 0;
            memo[0][1] = origin[0][1];
            memo[1][1] = origin[1][1];

            for (int i = 2; i < N + 1; i++) {
                memo[0][i] = Math.max(memo[1][i - 1], memo[1][i - 2]) + origin[0][i];
                memo[1][i] = Math.max(memo[0][i - 1], memo[0][i - 2]) + origin[1][i];
            }
            System.out.println(Math.max(memo[1][N], memo[0][N]));
        }
    }

}
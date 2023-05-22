import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    static int TC, N, M, C, ans;
    static int[][] map, reven;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            ans = 0;

            map = new int[N][N];
            reven = new int[N][N - M + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    reven[i][j] = setting(i, j, 0, 0, 0);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = reven[i][j] + nextBig(i, j);
                    ans = Math.max(sum, ans);
                }
            }
            System.out.println("#"+t +" " + ans);
        }
    }

    static int nextBig(int r, int c){
        int max = 0;
        for (int i = c + M; i <= N - M; i++) {
            max = Math.max(max, reven[r][i]);
        }
        for (int i = r + 1; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                max = Math.max(max, reven[i][j]);
            }
        }
        return max;
    }

    //sum: c와 비교할 합계 금액
    //p: reven에 저장될 수익
    static int setting(int r, int c, int sum, int p, int cnt){
        if(cnt >= M) return p;
        int max = 0;
        int nextSum;

        for (int i = cnt; i < M; i++) {
            //현재 위치의 꿀을 선택한 경우
            if(sum + map[r][i + c] <= C){
                nextSum = setting(r, c, sum + map[r][i + c], p + (map[r][i + c] * map[r][i + c]), i + 1);
                max = Math.max(nextSum, max);
            }
            nextSum = setting(r, c, sum, p, i + 1);
            max = Math.max(nextSum, max);
        }
        return max;
    }
}
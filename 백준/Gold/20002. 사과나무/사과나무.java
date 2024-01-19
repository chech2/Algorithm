import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static int[][] sum;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        sum = new int[n + 1][n + 1];
        result = -400000;

        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                result = Math.max(result, arr[i][j]);
            }
        }

        //sum 배열에 저장
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sum[i][j] = arr[i - 1][j - 1] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }

        for (int i = 2; i <= n; i++) {
            result = Math.max(result, findMaxValue(i));
        }
        System.out.println(result);
    }

    public static int findMaxValue(int size){
        int ans = -400000;
        for (int i = size; i < n + 1; i++) {
            for (int j = size; j < n + 1; j++) {
                ans = Math.max(ans, sum[i][j] - (sum[i - size][j] + sum[i][j - size]) + sum[i - size][j - size]);
            }
        }
        return ans;
    }

}
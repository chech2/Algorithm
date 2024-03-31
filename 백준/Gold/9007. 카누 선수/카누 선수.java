import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k, T;
    static long ans, result;
    static int[][] student;
    static long[] habban12, habban34;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input();

            int idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    habban12[idx] = student[0][i] + student[1][j];
                    habban34[idx] = student[2][i] + student[3][j];
                    idx++;
                }
            }

            Arrays.sort(habban12);
            Arrays.sort(habban34);

            int start, end, mid;
            long habban1234, absWithK;
            for (int i = 0; i < n * n; i++) {
                start = 0;
                end = n * n - 1;

                while(start <= end){
                    mid = (start + end) / 2;

                    habban1234 = habban12[i] + habban34[mid];
                    absWithK = Math.abs(k - habban1234);

                    // 답 구하기
                    if(absWithK < ans || (absWithK == ans && habban1234 < result)) {
                        result = habban1234;
                        ans = absWithK;
                    }
                    // 다음 mid 설정
                    if(habban1234 < k) start = mid + 1;
                    else if(k < habban1234) end = mid - 1;
                    else break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
    public static void input() throws Exception{
        strToken();
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        student = new int[4][n];
        habban12 = new long[n * n];
        habban34 = new long[n * n];
        ans = 500000000;
        result = 500000000;

        for (int i = 0; i < 4; i++) {
            strToken();
            for (int j = 0; j < n; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
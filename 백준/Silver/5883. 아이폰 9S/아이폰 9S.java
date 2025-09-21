import java.util.*;
import java.io.*;

public class Main {

    static int n, mV;
    static int[] B;
    static int[][] memo;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        B = new int[n];
        memo = new int[n][n];

        for(int i = 0; i < n; i++){
            B[i] = Integer.parseInt(br.readLine());
        }

        int now, pre;
        for(int i = 0; i < n; i++){
            now = B[i];
            pre = 0;
            for(int j = 1; j < n; j++){
                if(now == B[j]) continue;
                if(B[j] != B[pre]) {
                    memo[i][j] = 0;
                }else {
                    memo[i][j] = memo[i][pre] + 1;
                }
                mV = Math.max(mV, memo[i][j]);
                pre = j;
            }
        }
        System.out.println(mV + 1);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M,TC;
    static long [][] memo = new long[30][30];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < 30; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            System.out.println(combi(M,N));
        }
    }

    private static long combi(int r, int n) {
        if(memo[n][r] != -1)
            return memo[n][r];
        if(n == r || r == 0) {
            memo[n][r] = 1;
            return memo[n][r];
        }
        if(r == 1){
            memo[n][r] = n;
            return memo[n][r];
        }
        memo[n][r] = combi(r-1, n-1) + combi(r, n -1);
        return memo[n][r];
    }

}
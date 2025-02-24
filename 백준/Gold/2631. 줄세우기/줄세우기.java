import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] kids, dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        preSetting();

        System.out.println(sort());
    }

    static int sort(){
        int max = 0;

        for(int i = 0; i < n; i++){

            dp[i] = 1;
            for(int j = 0; j < i; j++){

                if(kids[j] < kids[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        
        for(int i = 0; i < n; i++) max = Math.max(dp[i], max);
        return n - max;
    }

    static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());

        kids = new int[n];
        dp = new int[n];
        for(int i = 0; i < n; i++) kids[i] = Integer.parseInt(br.readLine());
    }
}
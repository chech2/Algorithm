import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] burger;
    static int[][] dp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(recur(0, 0, 0, 0));
    }

    public static int recur(int cnt, int Agram, int Bgram, int Cgram){
        if(cnt == n){
            if(Agram < Bgram || Agram < Cgram || Bgram < Cgram) return 0;
            return Cgram;
        }
        if(dp[Agram][Bgram] != -1) return dp[Agram][Bgram];

        return dp[Agram][Bgram] = Math.max(recur(cnt + 1, Agram + burger[cnt], Bgram, Cgram), Math.max(recur(cnt + 1, Agram, Bgram + burger[cnt], Cgram), recur(cnt + 1, Agram,  Bgram, Cgram + burger[cnt])));
    }
    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        burger = new int[n];
        dp = new int[2500][2500];

        strToken();
        for (int i = 0; i < n; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 2500; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}
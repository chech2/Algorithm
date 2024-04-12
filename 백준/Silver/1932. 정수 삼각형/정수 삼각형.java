import java.util.*;
import java.io.*;
public class Main {
    static int n, ans;
    static int[][] s, arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        s[0][0] = recur(1, 0) + arr[0][0];
        System.out.println(s[0][0]);
    }

    public static int recur(int r, int c){
        if(r == n) return 0;
        if(s[r][c] != 0) return s[r][c];

        s[r][c] = recur(r + 1, c) + arr[r][c];
        if(c + 1 < n) s[r][c] = Math.max(recur(r + 1, c + 1) + arr[r][c + 1], s[r][c]);
        return s[r][c];
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());

        s = new int[n][n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            strToken();

            for (int j = 0; j < i + 1; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}
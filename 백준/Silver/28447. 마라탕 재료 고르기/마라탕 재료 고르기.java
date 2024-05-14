import java.util.*;
import java.io.*;
public class Main {

    static int n, k, ans;
    static int[][] ingredents;
    static int[] tmp;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        combi(0, 0);
        System.out.println(ans);
    }

    public static void combi(int start, int cnt){
        if(cnt == k){
            ans = Math.max(ans, compatibility());
            return;
        }
        for (int i = start; i < n; i++) {
            tmp[cnt] = i;
            combi(i + 1, cnt + 1);
        }
    }

    public static int compatibility(){
        int result = 0;
        int n1, n2;
        for (int i = 0; i < k; i++) {
            n1 = tmp[i];
            for (int j = i + 1; j < k; j++) {
                n2 = tmp[j];
                result += ingredents[n1][n2];
            }
        }
        return result;
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ans = Integer.MIN_VALUE;
        ingredents = new int[n][n];
        tmp = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ingredents[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
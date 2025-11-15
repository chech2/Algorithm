import java.io.*;
import java.util.*;

public class Main {
    static int n, k, seq;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        recur(0,  "");
        if(sb.length() == 0) sb.append("-1");
        System.out.println(sb);
    }

    public static void recur(int cnt, String ans){
        if(cnt == n){
            if(seq == k){
                sb.append(ans.substring(1, ans.length()));
            }
            return;
        }

        for(int i = 1; i < 4; i++){
            if(cnt + i == n) seq++;
            if(n < cnt + i) break;
            recur(cnt + i, ans + "+" + i);
        }
    }
}

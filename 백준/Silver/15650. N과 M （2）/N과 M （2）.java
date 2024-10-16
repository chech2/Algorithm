import java.io.*;
import java.util.*;


public class Main {

    static int n, m;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        input();
        recur(0, 1, 0);
        bw.append(sb);
        bw.flush();
        bw.close();
    }

    static void recur(int cnt, int start, int target){
        if(cnt == m){
            String[] results = String.valueOf(target).split("");
            for (String result : results) {
                sb.append(result).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            recur(cnt + 1, i + 1, target * 10 + i);
        }
    }
    static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }
}
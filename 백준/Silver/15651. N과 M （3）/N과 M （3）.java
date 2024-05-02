import java.util.*;
import java.io.*;
public class Main {

    static int n, m;
    static char[] selected;
    static char[] number = {'1', '2', '3', '4', '5', '6', '7'};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected  = new char[m];

        perm(0);
        System.out.println(sb);
    }

    public static void perm(int cnt) throws Exception{
        if(cnt == m){
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            selected[cnt] = number[i - 1];
            perm(cnt + 1);
        }
    }
}
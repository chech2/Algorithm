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

        selected  = new char[2 * m - 1];
        for (int i = 1; i < 2 * m - 1; i += 2) {
            selected[i] = ' ';
        }

        perm(0);
        System.out.println(sb);
    }

    public static void perm(int cnt) throws Exception{
        if(cnt == m){
            sb.append(selected);
            sb.append('\n');
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            selected[2 * cnt] = number[i - 1];
            perm(cnt + 1);
        }
    }
}
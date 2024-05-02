import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[] selected;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        combi(1, 0);
        System.out.println(sb);
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new char[2 * m];
        selected[2 * m - 1] = '\n';
        for (int i = 1; i < 2 * m - 1; i += 2) {
            selected[i] = ' ';
        }
    }

    public static void combi(int start, int cnt){
        if(cnt == m){
            sb.append(selected);
            return;
        }
        for (int i = start; i < n + 1; i++) {
            selected[2 * cnt] = (char)(i + '0');
            combi(i, cnt + 1);
        }
    }

}
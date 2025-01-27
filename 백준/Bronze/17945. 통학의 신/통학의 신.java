import java.io.*;
import java.util.*;

public class Main {
    static int a, b;
    static StringBuilder sb;
    static StringTokenizer st;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception{
        pre_setting();
        find_answer();
        bw.append(sb);
        bw.close();
    }

    static void find_answer(){
        int now;

        for(int i = -1000; i < 1001; i++){
            now = i * i + a * i + b;

            if (now == 0) sb.append(i).append(" ");
        }
    }

    static void pre_setting() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        a = Integer.parseInt(st.nextToken()) * 2;
        b = Integer.parseInt(st.nextToken());
    }
}
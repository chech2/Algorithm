import java.util.*;
import java.io.*;
public class Main {
    static int a, b, n, w, sheep, goat, cnt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        strToken();
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            if(a * i + b * (n - i) == w) {
                if(sheep != 0){
                    sheep = 0;
                    break;
                }else{
                    sheep = i;
                    goat = n - i;
                }
            }
        }
        if(sheep == 0) bw.append("-1");
        else bw.append(String.valueOf(sheep)).append(" ").append(String.valueOf(goat));
        bw.flush();
        bw.close();

    }
}
import java.util.*;
import java.io.*;
public class Main {

    static int a, b, c, d, e, f;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if(a * i + b * j == c && d * i + e * j == f) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

}
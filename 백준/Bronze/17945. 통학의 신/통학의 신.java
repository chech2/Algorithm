import java.util.*;
import java.io.*;
public class Main {

    static int a, b;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for (int i = -1000; i < 10001; i++) {
            if(findAns(i)) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static boolean findAns(int x){
        if(x * x + 2 * a * x + b == 0) return true;
        return false;
    }
}
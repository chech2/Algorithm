import java.util.*;
import java.io.*;
public class Main {

    static int T, n;
    static long[] arr = new long[103];
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        preset();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
        System.out.println(sb);

    }

    public static void preset() {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i < 103; i++) arr[i] = arr[i - 3] + arr[i - 2];
    }
}
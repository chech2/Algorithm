import java.io.*;
import java.util.*;
public class Main {
    static int h, w;
    static int[] map;
    static StringTokenizer st;
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        bw.append(sb.append(rain_check()));
        bw.close();
    }

    private static int rain_check() {
        int ans, left, right;

        ans = 0;
        for(int now = 1; now < w - 1; now++){
            left = 0;
            right = 0;
            for (int l = 0; l < now; l++) left = Math.max(map[l], left);
            for (int r = now + 1; r < w; r++) right = Math.max(map[r], right);

            ans += Math.max(Math.min(left, right) - map[now], 0);
        }
        return ans;
    }

    private static void pre_setting() throws Exception{
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) map[i] = Integer.parseInt(st.nextToken());
    }
}
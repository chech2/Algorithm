import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static int[] p;
    static int[][] dp;
    static int n;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        System.out.println(recur(0, 0, 0));
    }

    static int recur(int now, int pre, int preflag){
        if(dp[now][preflag] != -1) return dp[now][preflag];

        int next, rot;
        dp[now][preflag] = 0;
        for(int i = 0; i < map[now].size(); i++){
            next = map[now].get(i);
            rot = 0;

            if(next == pre) continue;
            if(preflag == 0) rot = recur(next, now, 1) + p[next];
            rot = Math.max(rot, recur(next, now, 0));

            dp[now][preflag]+= rot;
        }
        return dp[now][preflag];
    }

    static void inputSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n + 1];
        p = new int[n + 1];
        dp = new int[n + 1][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n + 1; i++){
            map[i] = new ArrayList<>();
            if(i != 0) p[i] = Integer.parseInt(st.nextToken());

            Arrays.fill(dp[i], -1);
        }

        int a, b;
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        map[0].add(1);
        map[1].add(0);
    }
}
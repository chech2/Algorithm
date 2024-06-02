import java.util.*;
import java.io.*;
public class Main {
    static int n, m, d, ans;
    static int[] map;
    static int[][][] memo;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        binarySearch();
        System.out.println(ans);
//        System.out.println(recur(1, 1, 0));
    }

    public static int recur(int cnt, int selected, int pre){
        if(selected == m + 1) return d - map[pre];
        if(cnt == n + 1 || m + 2 < selected) return -1000000;
        if(memo[cnt][selected][pre] != 0) return memo[cnt][selected][pre];

        return memo[cnt][selected][pre] = Math.max(Math.min(recur(cnt + 1, selected + 1, cnt), map[cnt] - map[pre]), recur(cnt + 1, selected, pre));
    }

    public static void binarySearch(){
        int s, e, mid, cnt, pre;
        s = 0;
        e = d;

        while(s <= e){
            mid = (s + e) / 2;
            cnt = 0;
            pre = 0;
            for (int now = 1; now < n + 1; now++) {
                if(map[now] - map[pre] < mid) cnt++;
                else pre = now;
            }
            if(map[n + 1] - map[pre] < mid || m < cnt) e = mid - 1;
            else {
                ans = Math.max(ans, mid);
                s = mid + 1;
            }
        }
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 2];
        map[n + 1] = d;
        for (int i = 1; i < n + 1; i++) map[i] = Integer.parseInt(br.readLine());
        Arrays.sort(map);
    }
}
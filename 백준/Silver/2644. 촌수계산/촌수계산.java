import java.io.*;
import java.util.*;
public class Main {
    static int n, s, e, m, ans;
    static ArrayList<Integer>[] grapth;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        dfs(s, -1, 0);
        System.out.println(ans);
    }

    public static void dfs(int now, int pre, int depth){
        if(now == e){
            ans = depth;
            return;
        }

        int next;
        for (int i = 0; i < grapth[now].size(); i++) {
            next = grapth[now].get(i);

            if(next == pre) continue;
            dfs(next, now, depth + 1);
        }
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        grapth = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) grapth[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        ans = -1;

        m = Integer.parseInt(br.readLine());
        int n1, n2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            grapth[n1].add(n2);
            grapth[n2].add(n1);
        }
    }
}
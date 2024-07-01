import java.io.*;
import java.util.*;
public class Main {
    static int n, r1, r2, ans;
    static ArrayList<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class node{
        int num, p;
        node(int num, int p){
            this.num = num;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        recur(r1, 0, 0,0);
        System.out.println(ans);
    }

    public static void recur(int now, int pre, int max, int sum) {
        if(now == r2){
            ans = Math.min(ans, (sum - max));
            return;
        }

        node next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);
            if(next.num == pre) continue;
            recur(next.num, now, Math.max(max, next.p),sum + next.p);
        }
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e, p;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            graph[s].add(new node(e, p));
            graph[e].add(new node(s, p));
        }
    }

}
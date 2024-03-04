import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t, ans, cnt;
    static int[] parent;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.p - o2.p);

    public static class node{
        int n1, n2, p;
        node(int n1, int n2, int p){
            this.n1 = n1;
            this.n2 = n2;
            this.p = p;
        }
    }
    public static void main(String[] args) throws Exception{
        input();

        node now;
        while(!q.isEmpty()){
            now = q.poll();

            if(union(now.n1, now.n2)){
                ans += now.p + cnt * t;
                cnt++;
            }
        }
        System.out.println(ans);
    }
    public static void input() throws Exception{
        strToken();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        Arrays.fill(parent, -1);

        int n1, n2, p;
        for (int i = 0; i < m; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            q.add(new node(n1, n2, p));
        }
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return false;
        parent[y] = x;
        return true;
    }

    public static int find(int x){
        if(parent[x] == -1) return parent[x] = x;
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

}
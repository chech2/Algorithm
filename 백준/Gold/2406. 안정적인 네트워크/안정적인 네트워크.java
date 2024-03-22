import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static PriorityQueue<node> q = new PriorityQueue<node>((o1, o2) -> o1.p - o2.p);
    static int[] parent;
    public static class node{
        int p, n1, n2;
        node (int n1, int n2, int p){
            this.n1 = n1;
            this.n2 = n2;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        mst();
    }

    public static void mst(){
        node now;
        int ans = 0;
        int cnt = 0;
        while (!q.isEmpty()){
            now = q.poll();
            if(union(now.n1, now.n2)){
                sb.append(now.n2).append(" ").append(now.n1).append("\n");
                ans += now.p;
                cnt++;
            }
        }
        System.out.println(ans + " " + cnt);
        System.out.println(sb);
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
        m = Integer.parseInt(st.nextToken()); // 사전 연결 수
        parent = new int[n + 1];

        Arrays.fill(parent, -1);

        int n1, n2;
        for (int i = 0; i < m; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            union(n1, n2);
        }

        int price;
        for (int i = 1; i < n + 1; i++) {
            strToken();
            for (int j = 1; j < n + 1; j++) {
                price = Integer.parseInt(st.nextToken());

                if(i == j || i == 1 || j == 1) continue;
                q.add(new node(i, j, price));
            }
        }
    }
    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static int find(int x){
        if(parent[x] == -1) return parent[x] = x;
        if(parent[x] == x) return parent[x];
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return false;
        parent[y] = x;
        return true;
    }
}
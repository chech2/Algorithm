import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[] parent;
    static PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.price - o2.price);
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        mst();

    }

    public static void mst(){
        node now;
        int ans = 0;

        while (!q.isEmpty()){
            now = q.poll();
            if(union(now.n1, now.n2)){
                ans += now.price;
            }
        }
        System.out.println(ans);
    }
    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return false;
        parent[x] = y;
        return true;
    }

    public static int find(int x){
        if(parent[x] == -1) return parent[x] = x;
        else if(parent[x] == x) return parent[x];
        return parent[x] = find(parent[x]);
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        parent[0] = 0;
        strToken();
        for (int i = 0; i < k; i++) parent[Integer.parseInt(st.nextToken())] = 0;

        int n1, n2, price;
        for (int i = 0; i < m; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(st.nextToken());

            q.add(new node(n1, n2, price));
        }
    }
    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
    public static class node{
        int n1, n2, price;
        node(int n1, int n2, int price){
            this.n1 = n1;
            this.n2 = n2;
            this.price = price;
        }
    }
}
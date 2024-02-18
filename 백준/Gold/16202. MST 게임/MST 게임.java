import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class node{
        int n1, n2, value;
        node(int n1, int n2, int value){
            this.n1 = n1;
            this.n2 = n2;
            this.value = value;
        }
    }
    static int n, m, k;
    static ArrayList<Integer>[] list;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<node>[] q;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        int ans = playGame(0);
        sb.append(ans).append(" ");

        for (int i = 1; i < k; i++) {
            if(ans != 0) ans = playGame(i);
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
    }
    public static int playGame(int cnt){
        boolean flag = false;
        int result = 0;
        int selectV = 0;
        node now;
        Arrays.fill(parent, -1);
//        System.out.println("cnt: " + cnt);

        while(!q[cnt].isEmpty()){
            now = q[cnt].poll();

            if(!union(now.n1, now.n2)){
                if(cnt + 1 < k && flag) q[cnt + 1].add(now);
                if(!flag) flag = true;
                result += now.value;
                selectV++;
            }else{
                if(cnt + 1 < k) q[cnt + 1].add(now);
            }
        }
        if(selectV != n - 1) return 0;
        return result;
    }
    public static void input() throws Exception{
        strToken();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        parent = new int[n + 1];
        q = new PriorityQueue[k];
        Arrays.fill(parent, -1);
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < k; i++) {
            q[i] = new PriorityQueue<node>((o1, o2) -> o1.value - o2.value);
        }

        int n1, n2;
        for (int i = 0; i < m; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
            q[0].add(new node(n1, n2, i + 1));
        }
    }

    public static int find(int x){
        if(parent[x] == -1) return x;
        return parent[x] = find(parent[x]);
    }
    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return true;
        parent[y] = x;
        return false;
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
}
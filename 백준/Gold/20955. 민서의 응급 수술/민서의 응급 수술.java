import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long m, ans;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        int n1, n2;
        ArrayDeque<node> q = new ArrayDeque<>();
        for (long i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            q.add(new node(n1, n2));
        }

        node now;
        while(!q.isEmpty()){
           now = q.poll();
           if(!union(find(now.n1), find(now.n2))) ans++; // 사이클 발생
        }

        for (int i = 1; i < n + 1; i++){
            if(parent[i] < 0) ans++;
        }
        System.out.println(ans - 1);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return false;
        else if(x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x){
        if(parent[x] < 0) return x;
        else return parent[x] = find(parent[x]);
    }

    public static class node{
        int n1, n2;
        node(int n1, int n2){
            this.n1 = n1;
            this.n2 = n2;
        }
    }
}
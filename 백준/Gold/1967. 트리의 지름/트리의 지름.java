import java.io.*;
import java.util.*;

public class Main {
    
    static int n, l, ans;
    static int[] d;
    static List<node>[] tree;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        preSetting();
        recur(1, 0 );
        
        Arrays.fill(d, 0);
        
        recur(l, 0);
        System.out.println(ans);
    }

    static void recur(int now, int pre){

        node next;
        for(int i = 0; i < tree[now].size(); i++){
            next = tree[now].get(i);

            if(next.n == pre) continue;

            d[next.n] += d[now] + next.c;
            if(ans < d[next.n]){
                ans = d[next.n];
                l = next.n;
            }
            recur(next.n, now);
        }
    }

    static void preSetting() throws Exception{
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        d = new int[n + 1];

        for(int i = 0; i < n + 1; i++) tree[i] = new ArrayList<>();

        int a, b, c;
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            tree[a].add(new node(b, c));
            tree[b].add(new node(a, c));
        }
    }

    static class node{
        int n, c;

        node(int n, int c){
            this.n = n;
            this.c = c;
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<node> q = new PriorityQueue<>(
            (o1, o2) -> {
                    if(o1.u == o2.u || o1.v == o2.v) return o1.reduce - o2.reduce;
                    else return o1.u - o2.u;
            });

    static int INF = 1200001;
    static int n, d;
    static int[] memo;
    static List<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        inputSetting();
        findMinLen();
        System.out.println(memo[d]);
    }

    static void findMinLen(){
        node now, next;
        while(!q.isEmpty()){
            now = q.poll();

            if(memo[now.v] < memo[now.u] + now.l) continue;
            memo[now.v] = memo[now.u] + now.l;

            if(d <= now.v || memo[now.v + 1] < memo[now.v] + 1) continue;
            q.add(new node(now.v, now.v + 1, 1));
        }
    }

    static void inputSetting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        memo = new int [d + 1];
        for(int i = 0; i < d + 1; i++) memo[i] = i;

        int u, v, l;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            if(d < u || d < v) continue;

            q.add(new node(u, v, l));
        }
    }
    static class node{
        int u, v, origin, reduce,l;
        node(int u, int v, int l){
            this.u = u;
            this.v = v;
            this.l = l;
            origin = v - u;
            reduce = l - this.origin;
        }
    }
}
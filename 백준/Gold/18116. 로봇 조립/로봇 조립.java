import java.io.*;
import java.util.*;
public class Main {
    static final int max_idx = 1000001;
    static int n;
    static ArrayList<Integer>[] graph;
    static ArrayDeque<node> deque;
    static int[] parent, sub;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        pre_setting();
        bw.close();
    }

    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();

        graph = new ArrayList[max_idx];
        parent = new int[max_idx];
        sub = new int[max_idx];

        for(int i = 0; i < max_idx; i ++) graph[i] = new ArrayList<>();
        Arrays.fill(parent, -1);
        Arrays.fill(sub, 1);

        int a, b, c;
        String q;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            q = st.nextToken();
            if(q.equals("I")){
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                deque.add(new node(a, b));

            }else{
                c = Integer.parseInt(st.nextToken());
                sb.append(union_robot(c)).append("\n");
            }
        }

        bw.append(sb);
        bw.close();
    }

    static int union_robot(int ans){
        node now;

        while(!deque.isEmpty()){
            now = deque.poll();

            union(now.a, now.b);
        }
        return sub[find(ans)];
    }

    static int find(int a){
        if(parent[a] == -1) return parent[a] = a;
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) {
            parent[a] = b;
            sub[b] += sub[a];
        }
        else if(b < a){
            parent[b] = a;
            sub[a] += sub[b];
        }
    }

    static class node{
        int a, b;

        node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}
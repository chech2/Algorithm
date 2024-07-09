import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[] people;
    static int[][] d;
    static ArrayList<node>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        dijkstraK();
        dijkstraWhite();
        print();
    }

    public static void print() throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int j = 2; j < n + 1; j++) {
            if(d[0][j] != -1 && d[0][j] < d[1][j]){
                sb.append(j).append(" ");
            }
        }

        if(sb.length() == 0) sb.append(0);
        bw.append(sb);
        bw.flush();
        bw.close();
    }

    public static void dijkstraWhite(){
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);
        q.add(new node(1, 0));

        d[0][1] = 0;
        node now, next;
        while(!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < graph[now.n].size(); i++) {
                next = graph[now.n].get(i);

                if(d[0][now.n] + next.t < d[0][next.n]){
                    d[0][next.n] = d[0][now.n] + next.t;
                    q.add(next);
                }
            }
        }
    }

    public static void dijkstraK(){
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);
        for (int i = 0; i < k; i++) {
            q.add(new node(people[i], 0));
            d[1][people[i]] = 0;
        }

        node now, next;
        while(!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < graph[now.n].size(); i++) {
                next = graph[now.n].get(i);

                if(d[1][now.n] + next.t < d[1][next.n]){
                    d[1][next.n] = d[1][now.n] + next.t;
                    q.add(next);
                }
            }
        }
    }

    public static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        people = new int[k];
        d = new int[2][n + 1]; // 추종자 + 백채원의 최단 경로 저장, d[k]는 백채원

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();

        int n1, n2, p;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            graph[n1].add(new node(n2, p));
            graph[n2].add(new node(n1, p));
        }

        Arrays.fill(d[0], 2100000000);
        Arrays.fill(d[1], 2100000000);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            d[0][people[i]] = -1;
        }
    }

    // 0: 추종자, 1: 백채원
    static class node{
        int n, t;
        node(int n, int t){
            this.n = n;
            this.t = t;
        }
    }
}
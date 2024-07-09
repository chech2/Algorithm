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
        for (int i = 0; i < k + 1; i++) dijkstra(people[i], i);
        print();
    }

    public static void print() throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt;
        for (int j = 2; j < n + 1; j++) {
            cnt = 0;
            for (int i = 0; i < k; i++) {
                if(d[k][j] != -1 && d[k][j] < d[i][j]){
                    cnt++;
                }
            }
            if(cnt == k) sb.append(j).append(" ");
        }
        if(sb.length() == 0) sb.append(0);
        bw.append(sb);
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int number, int idx){
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);
        q.add(new node(number, 0));

        d[idx][number] = 0;
        node now, next;
        while(!q.isEmpty()){
            now = q.poll();

            for (int i = 0; i < graph[now.n].size(); i++) {
                next = graph[now.n].get(i);

                if(d[idx][now.n] + next.t < d[idx][next.n]){
                    d[idx][next.n] = d[idx][now.n] + next.t;
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
        people = new int[k + 1];
        d = new int[k + 1][n + 1]; // 추종자 + 백채원의 최단 경로 저장, d[k]는 백채원

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

        Arrays.fill(d[k], 2100000000);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            people[i] = Integer.parseInt(st.nextToken());

            Arrays.fill(d[i], 2100000000);
            d[k][people[i]] = -1;
        }
        people[k] = 1;
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
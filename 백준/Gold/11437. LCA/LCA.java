import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] p, d;
    static int n, m;
    static int[][] question;
    static ArrayList<Integer>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        findParent(1, 0);
        for (int i = 0; i < m; i++) {
            findAns(question[i][0], question[i][1]);
        }
        System.out.println(sb);
    }

    public static void findAns(int n1, int n2){
        // 깊이가 다르면 깊이를 맞춥니다.
        while(d[n1] != d[n2]){
            if(d[n1] > d[n2]) n1 = p[n1];
            else n2 = p[n2];
        }
        // 같은 깊이에서 두 노드가 같아질 때까지 부모를 타고 올라갑니다.
        while(n1 != n2){
            n1 = p[n1];
            n2 = p[n2];
        }
        sb.append(n1).append("\n");
    }

//    public static void findAns(int n1, int n2){
//
//        // 공통 조상을 찾은 경우
//        if(p[n1] == p[n2] || n1 == p[n2] || n2 == p[n1]){
//            if(p[n1] == p[n2] || n2 == p[n1]) sb.append(p[n1]).append("\n");
//            else if (n1 == p[n2]) sb.append(n1).append("\n");
//            return;
//        }
//
//        // 공통 조상이 아닌 경우
//        if(d[n1] == d[n2]){ // 깊이가 같은 경우
//            findAns(p[n1], p[n2]);
//        }else { //깊이가 다른 경우
//            if (d[n1] < d[n2]) findAns(n1, p[n2]);
//            else if (d[n2] < d[n1]) findAns(p[n1], n2);
//        }
//    }

    public static void findParent(int now, int pre){

        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(next == pre) continue;
            p[next] = now;
            d[next] = d[now] + 1;
            findParent(next, now);
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        p = new int[n + 1];
        d = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int n1, n2;
        for (int i = 0; i < n - 1; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        strToken();
        m = Integer.parseInt(st.nextToken());

        question = new int[m][2];
        for (int i = 0; i < m; i++) {
            strToken();
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            question[i][0] = n1;
            question[i][1] = n2;
        }
    }

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, MAXVALUE, MAXIDX;
    static int[] d;
    static ArrayList<Integer>[] graph;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        recur(1, 0);
        Arrays.fill(d, 0);
        MAXVALUE = 0;
        recur(MAXIDX, 0);
        System.out.println((MAXVALUE + 1) / 2);
    }

    public static void recur(int now, int pre){

        int next;
        for (int i = 0; i < graph[now].size(); i++) {
            next = graph[now].get(i);

            if(next == pre) continue;
            d[next] = d[now] + 1;

            if(MAXVALUE < d[next]){
                MAXVALUE = d[next];
                MAXIDX = next;
            }
            recur(next, now);
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
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
    }

}
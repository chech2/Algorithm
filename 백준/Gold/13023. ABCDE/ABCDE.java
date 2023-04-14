import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] nodes;
    static int N, M;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            nodes[p1].add(p2);
            nodes[p2].add(p1);
        }
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            count(i, 0);
        }
        System.out.println(0);
    }

    static void count(int idx, int cnt){
        if(cnt >= 4){
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 0; i < nodes[idx].size(); i++) {
            int next = nodes[idx].get(i);
            if(!visited[next]){
//                System.out.println("now: " + idx + " next: " + next);
                visited[next] = true;
                count(nodes[idx].get(i), cnt + 1);
                visited[next] = false;
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class node {
        int n, s;
        node(int n, int s){
            this.n = n;
            this.s = s;
        }
    }
//    static Comparator comparator = new Comparator<node>() {
//        @Override
//        public int compare(node o1, node o2) {
//            return o1.n - o2.n;
//        }
//    };
    static int n, min;
    static int[] price, selected;
    static boolean[] visited;
    static ArrayList<node>[] sale;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        price = new int[n];
        selected = new int[n];
        sale = new ArrayList[n];
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int stop;
        for (int i = 0; i < n; i++) {
            stop = Integer.parseInt(br.readLine());
            sale[i] = new ArrayList<>();
            for (int j = 0; j < stop; j++) {
                st = new StringTokenizer(br.readLine());
                sale[i].add(new node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
            }
        }

        perm(0);
        System.out.println(min);
    }

    static void perm(int cnt){
        if(cnt == n){
            int[] tmpPrice = price.clone();
            int result = 0;
            node now;
            for (int i = 0; i < n; i++) {
                result += tmpPrice[selected[i]];
                for (int j = 0; j < sale[selected[i]].size(); j++) {
                    now = sale[selected[i]].get(j);
                    tmpPrice[now.n] -= now.s;
                    if(tmpPrice[now.n] < 0) tmpPrice[now.n] = 1;
                }
            }
            min = Math.min(result, min);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            selected[cnt] = i;
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }

    }
}
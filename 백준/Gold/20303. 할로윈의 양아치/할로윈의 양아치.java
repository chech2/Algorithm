import java.io.*;
import java.util.*;
public class Main {
    static int n, m, k, size;
    static int[] c, p;
    static int[][] memo;
    static List<target> targets;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        pre_setting();
        grouping();
        System.out.println(sevigi());
    }

    static int sevigi(){
        size = targets.size();
        memo = new int[size + 1][k];
        target group;

        // i: 그룹 번호
        for(int i = 1; i < targets.size() + 1; i++){

            group = targets.get(i - 1);
            for(int j = 0; j < k; j++) {

                if(j < group.k) memo[i][j] = memo[i - 1][j];
                else memo[i][j] = Math.max(memo[i - 1][j - group.k] + group.c, memo[i - 1][j]);
            }
       }
        return memo[size][k - 1];
    }

    static void grouping() {
        int[][] candies = new int[n + 1][2];
        targets = new ArrayList<>();

        int r;
        for(int i = 1; i < n + 1; i++) {
            r = find(i);

            candies[r][0]++;
            candies[r][1] += c[i];
        }

        for(int i = 1; i < n + 1; i++){
            if(candies[i][0] != 0) targets.add(new target(candies[i][0], candies[i][1]));
        }
    }

    static void pre_setting() throws Exception{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        c = new int[n + 1];
        p = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++){
            c[i] = Integer.parseInt(st.nextToken());
            p[i] = i;
        }

        int a, b;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) p[b] = a;
        else p[a] = b;
    }

    static int find(int a){
        if(p[a] == a) return p[a];

        return p[a] = find(p[a]);
    }

    static class target{
        int k, c;

        target(int k, int c){
            this.k = k;
            this.c = c;
        }
    }
}
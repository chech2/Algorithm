import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] visited;
    static PriorityQueue<node> result = new PriorityQueue<>((o1, o2) -> {
        if(o1.value == o2.value){
            return o1.num1 - o2.num2;
        }else {
            return o1.value - o2.value;
        }
    });

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new int[2];
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(map[i], 100);
            map[i][i] = 0;
            map[i][0] = 0;
        }

        int start, end;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = 2;
            map[end][start] = 2;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        combi(1, 0);
        node now = result.poll();

        System.out.println(now.num1 + " " + now.num2 + " " + now.value);
    }

    static void combi(int start, int cnt){
        if(cnt == 2){
            int sum = 0;
            int num1 = visited[0];
            int num2 = visited[1];
            for (int i = 1; i < N + 1; i++) {
                sum += Math.min(map[num1][i], map[num2][i]);
            }
            result.add(new node(Math.min(num1, num2), Math.max(num1, num2), sum));
            return;
        }
        for (int i = start; i < N + 1; i++) {
            visited[cnt] = i;
            combi(i + 1, cnt + 1);
        }
    }

    static class node{
        int num1, num2,  value;
        node(int num1, int num2, int value){
            this.num1 = num1;
            this.num2 = num2;
            this.value = value;
        }
    }

}
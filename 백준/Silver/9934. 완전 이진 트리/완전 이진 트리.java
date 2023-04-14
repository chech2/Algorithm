import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static boolean visited[];
    static Queue<Node> q = new ArrayDeque<>();
    static int d, N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        d = Integer.parseInt(br.readLine());
        N = (int)Math.pow(2, d) - 1;

        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        BinarySerch(0, N - 1, 0);
        int level = 0;
        int len = N / 2;
        while (!q.isEmpty()){
            Node now = q.poll();
            if(level != now.level) {
                System.out.println();
                level++;
                len /= 2;
            }
            BinarySerch(now.idx - len, now.idx - 1, now.level + 1);
            BinarySerch(now.idx + 1, now.idx + len, now.level + 1);
            System.out.print(now.num +  " ");
        }
    }

    private static void BinarySerch(int start, int end, int level) {
        int mid = start + (end - start) / 2;
        if(start == end) mid = start;
        if(start > end) return;
        if(!visited[mid]) {
            q.add(new Node(mid, arr[mid], level));
            visited[mid] = true;
        }
    }

    static class Node{
        int idx, num, level;

        Node(int idx, int num, int level){
            this.idx = idx;
            this.num = num;
            this.level = level;
        }
    }

}
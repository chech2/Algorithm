import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N, Zero;
    static PriorityQueue<Integer> q = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if(now == 0) {
                if(q.isEmpty()) sb.append("0\n");
                else sb.append(q.poll()).append("\n");
            }
            else q.add(now);
        }
        System.out.println(sb);
    }
}
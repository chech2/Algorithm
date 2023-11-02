import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Integer> maxHip = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    static PriorityQueue<Integer> minHip = new PriorityQueue<>(((o1, o2) -> o1 - o2));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (i == 0) {
                maxHip.add(now);
            }
            else {
                //사이즈가 같은 경우 maxHip에 값 넣기 (짝수이므로, 중간값 2개 중 더 작은 값으로 값이 들어가야 됨)
                if (maxHip.size() == minHip.size()) {
                    int tmp = minHip.poll();
                    if (tmp < now) {
                        minHip.add(now);
                        maxHip.add(tmp);
                    } else {
                        minHip.add(tmp);
                        maxHip.add(now);
                    }
                } else {
                    int tmp = maxHip.poll();
                    if (tmp < now) {
                        minHip.add(now);
                        maxHip.add(tmp);
                    } else {
                        minHip.add(tmp);
                        maxHip.add(now);
                    }

                }
            }
            sb.append(maxHip.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
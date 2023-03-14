import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static PriorityQueue<int []> arr = new PriorityQueue<>(
            new Comparator<int []>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] == o2[1]) return o1[0] - o2[0];
                    return o1[1] - o2[1];
                }
            });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int start;
        int end;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            arr.add(new int[] {start, end});
        }

        int result = 0;
        end = 0;
        int now [];
        for (int i = 0; i < N; i++) {
            now = arr.poll();

            //지금 회의시작 시간이 이전 회의종료시간보다 큰 경우 (더 이후인 경우)
            if(now[0] >= end) {
                result++;
                end = now[1];
                //System.out.println("dhkr" + Arrays.toString(now));
            }
            //System.out.println(Arrays.toString(now));
        }
        System.out.println(result);
    }
}
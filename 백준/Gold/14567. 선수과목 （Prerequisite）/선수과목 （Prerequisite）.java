import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] result, degrees;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[n + 1];
        degrees = new int[n + 1]; //진입차수
        list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int pre, sub;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pre = Integer.parseInt(st.nextToken());
            sub = Integer.parseInt(st.nextToken());

            list[sub].add(pre);
            degrees[sub]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if(degrees[i] == 0) {
                q.add(i);
                result[i] = 1;
            }
        }

        int now;
        while(!q.isEmpty()){
            now = q.poll(); // 진입차수가 0인 과목인 선수 과목

            // 다음 과목 찾기
            for (int next = 1; next < n + 1; next++) {

                //같은 과목이거나 이미 선수 과목이 없는 경우 제외
                if(next == now || degrees[next] == 0) continue;

                //now가 next의 선수 과목인 경우 -> 진입 차수 -1
                if(list[next].contains(now)) degrees[next]--;
                if(degrees[next] == 0){
                    result[next] = result[now] + 1;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            bw.append(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
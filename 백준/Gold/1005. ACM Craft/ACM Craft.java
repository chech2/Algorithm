import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

    static int building, sequence, target, ans;
    static int[] d, pre, maxTime;
    static ArrayList<Integer>[] list;

    static class node {
        int num, time;

        node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            building = Integer.parseInt(st.nextToken()); // 건물 개수
            sequence = Integer.parseInt(st.nextToken()); // 연결 순서
            d = new int[building + 1]; // 건설 비용 배열
            pre = new int[building + 1]; // 해당 건물 앞에 미리 지어져야 되는 건물의 개수
            maxTime = new int[building + 1]; // 각 건물별 완공까지 걸리는 시간 저장
            list = new ArrayList[building + 1]; // 연결 순서 정보 저장
            ans = -1;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < building + 1; i++) {
                d[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }

            int to, from;
            for (int i = 0; i < sequence; i++) {
                st = new StringTokenizer(br.readLine());
                to = Integer.parseInt(st.nextToken());
                from = Integer.parseInt(st.nextToken());
                pre[from]++;
                list[to].add(from);
            }

            target = Integer.parseInt(br.readLine());
            ArrayDeque<node> q = new ArrayDeque<>();

            for (int i = 1; i < building + 1; i++) {
                if (pre[i] == 0) {
                    q.add(new node(i, d[i]));
                    maxTime[i] = d[i];
                    pre[i]--;
                    if (i == target) {
                        ans = d[i];
                        break;
                    }
                }
            }

            if(ans == -1) {
                node now;
                int next;
                while (!q.isEmpty()) {
                    now = q.poll();
                    for (int i = 0; i < list[now.num].size(); i++) {
                        next = list[now.num].get(i);
                        pre[next]--;
                        maxTime[next] = Math.max(maxTime[next], now.time + d[next]);

                        if (next == target) { // 다음으로 이동할 수 있는 건물이 목표 건물인 경우
                            ans = Math.max(now.time + d[next], ans);
                            maxTime[now.num] = Math.max(maxTime[now.num], now.time + d[next]);
                        } else if (pre[next] == 0) { // 목표 건물은 아니지만 이동 가능한 경우
                            pre[next] = -1;
                            q.add(new node(next, maxTime[next]));
                        }
                    }
                }
            }
            bw.append(ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
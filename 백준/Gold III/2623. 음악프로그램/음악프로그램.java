import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cnt;
    static int[] p; // 진입차수
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[m];
        p = new int[n + 1];
        for (int i = 0; i < m; i++) {
            list[i] = new ArrayList<>();
        }

        int size, now, next;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                now = Integer.parseInt(st.nextToken());
                list[i].add(now);
                p[now] += j;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if(p[i] == 0) {
                p[i]--;
                q.add(i);
                sb.append(i + "\n");
            }
        }
        
        boolean flag;
        while(!q.isEmpty()){
            now = q.poll();
            cnt++;
            for (int i = 0; i < m; i++) {
                size = list[i].size();
                flag = false;
                for (int j = 0; j < size; j++) {
                    next = list[i].get(j);

                    if(next == now) flag = true;
                    else if(flag) {
                        p[next]--;
                        if (p[next] == 0) {
                            p[next] = -1;

                            q.add(next);
                            sb.append(next + "\n");
                        }
                    }
                }
            }
        }

        if(cnt == n) System.out.println(sb);
        else System.out.println(0);
    }
}
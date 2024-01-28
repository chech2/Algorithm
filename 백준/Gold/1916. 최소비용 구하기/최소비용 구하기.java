import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n, m, start, end;
    static ArrayList<node>[] list;
    static long[] d;
    static class node{
        int start, end, fee; // to: 도착지, fee: 요금
        node(int start, int end, int fee){
            this.start = start;
            this.end = end;
            this.fee = fee;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        d = new long[n + 1];
        Arrays.fill(d, 20000000000L);

        for (int i = 1; i < n + 1; i++) list[i] = new ArrayList<>();

        int to, from, fee;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            fee = Integer.parseInt(st.nextToken());
            list[from].add(new node(from, to, fee));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        d[start] = 0;

        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.fee - o2.fee);
        node now, next;

        for (int i = 0; i < list[start].size(); i++) {
            next = list[start].get(i);

            if(d[next.end] <= next.fee) continue;
            d[next.end] = next.fee;
            q.add(new node(start, next.end, next.fee));
        }

        while(!q.isEmpty()){
            now = q.poll();

            if(d[now.end] < now.fee) continue;

            // 다음으로 넘어갈 수 있는 경우의 노드 넣기
            for (int i = 0; i < list[now.end].size(); i++) {
                next = list[now.end].get(i);

                if(d[next.end] <= d[now.end] + next.fee) continue;
                d[next.end] = d[now.end] + next.fee;
                q.add(next);
            }
        }
        bw.append(d[end] + "\n");
        bw.flush();
        bw.close();
    }

}
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
    static int[] result;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[n + 1];
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
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if(list[i].size() == 0) {
                q.add(i);
                result[i] = 1;
            }
        }

        int now;
        while(!q.isEmpty()){
            now = q.poll();

            for (int i = 1; i < n + 1; i++) {
                if(i == now) continue;
                for (int j = 0; j < list[i].size(); j++) {
                    if(list[i].get(j) == now) {
                        list[i].remove(j);
                    }
                    if(list[i].size() == 0){
                        result[i] = result[now] + 1;
                        q.add(i);
                    }
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
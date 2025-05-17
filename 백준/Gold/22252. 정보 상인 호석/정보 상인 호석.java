import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long answer;
    static Map<String, PriorityQueue<Integer>>  gorilla;
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        gorilla = new HashMap<>();

        int query, cnt;
        PriorityQueue<Integer> now;
        String name;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            query = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            now = gorilla.getOrDefault(name, new PriorityQueue<>((o1, o2) -> o2 - o1));
            if(query == 1){
                cnt = Integer.parseInt(st.nextToken());

                for(int j = 0; j < cnt; j++) now.add(Integer.parseInt(st.nextToken()));

                gorilla.put(name, now);

            }else{
                cnt = Math.min(Integer.parseInt(st.nextToken()), now.size());

                for(int j = 0; j < cnt; j++) answer += now.poll();;
            }
            gorilla.put(name, now);
        }
        System.out.println(answer);
    }
}
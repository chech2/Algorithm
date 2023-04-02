import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] Matrix; // 처음 위치 + 중간 지점 + 마지막 위치 저장.
    static ArrayList<int []> Position; //
    static int TC, N;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            N = Integer.parseInt(br.readLine());

            Matrix = new ArrayList[N + 2];
            Position = new ArrayList<>();

            for (int i = 0; i < N + 2; i++) {
                Matrix[i] = new ArrayList<>();
            }

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Position.add(new int[] {x, y});

                if(Position.size() > 1){
                    ManhattanDistance(x, y);
                }
            }
            visited = new boolean[N + 2];

            if(Matrix[0].size() != 0 || Matrix[N + 1].size() != 0){
                bfs();
            }
            if(visited[N + 1]){
                sb.append("happy\n");
            }else{
                sb.append("sad\n");
            }
        }
        System.out.println(sb);
    }

    static void ManhattanDistance(int x, int y) {
        int size = Position.size() - 1;
        int distance = 0;
        for (int i = 0; i < size; i++) {
            int[] Other = Position.get(i);
            distance = Math.abs(x - Other[0]) + Math.abs(y - Other[1]);
            if(distance <= 1000){
                Matrix[i].add(size);
                Matrix[size].add(i);
            }
        }
    }

    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        int current = 0;

//        for (ArrayList<Integer> a : Matrix){
//            System.out.println(a);
//        }

        while(!q.isEmpty()){
            current = q.poll();
            for (int i = 0; i < Matrix[current].size(); i++) {
                int Next = Matrix[current].get(i);
                if(Next == N + 1){
                    visited[Next] = true;
                    return;
                }
                if(visited[Next]) continue;
                else{
                    visited[Next] = true;
                    q.offer(Next);
                }
            }
        }

    }
}
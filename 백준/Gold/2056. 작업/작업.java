import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, ans;
    static int memo[];
    static ArrayList<Integer>[] task;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            task = new ArrayList[N];
            memo = new int[N];
            ans = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                task[i] = new ArrayList<>();

                //처음 작업일수 task에 넣기
                int day = Integer.parseInt(st.nextToken());
                task[i].add(day);

                //미리 완료해야 하는 작업의 개수
                int taskN = Integer.parseInt(st.nextToken());
                task[i].add(taskN);
                for (int j = 0; j < taskN; j++) task[i].add(Integer.parseInt(st.nextToken()) - 1);

                ans = Math.max(dp(i, taskN), ans);
            }

//            입력값 세팅 완료////////////////////////////////////////////////////

            System.out.println(ans);

    }

    static int dp(int i, int taskN){
        //초기값으로 세팅되어 있는 경우
        if(memo[i] == 0){
//            System.out.println("taskN: " + taskN);
            memo[i] = task[i].get(0);
            int max = 0;
            for (int j = 2; j < taskN + 2; j++) {
                int preIdx = task[i].get(j);
                max = Math.max(memo[preIdx], max);
//                System.out.println("!!!" + task[i]);
            }
            memo[i] += max;
        }
        return memo[i];
    }

    //선행 조건이 먼저 수행 된 경우, 바로 시작해야 하는데 => 고려되지 않음

    static class Node {

        int idx, cnt;

        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

    }
}
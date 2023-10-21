import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] memo;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            dp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        if(memo[N + 1] == 0)  memo[N + 1] = memo[N];
        memo[N + 1] = Math.max(memo[N + 1], memo[N]);

        System.out.println(memo[N + 1]);
    }


    public static void dp(int reduiredDay, int momey, int today){
        int day = reduiredDay + today;

        //오늘의 상담수익이 0이면, 전날까지의 상담수익의 최댓값이 오늘의 최댓값
        memo[today] = Math.max(memo[today], memo[today - 1]);

        if(day < N + 2)
        memo[day] = Math.max(memo[day], momey + memo[today]);
    }
}
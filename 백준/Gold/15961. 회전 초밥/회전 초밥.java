import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, D, K, C, Result, cnt;
    static int type[], arr[];

    public static void main(String[] args) throws Exception{
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Result = Integer.MIN_VALUE;
        type = new int[D + 1];
        arr = new int[N];

        count();
        System.out.println(Result);
    }

    static void count() throws Exception{
        int now;

        //비교 개수가 그냥 k이면 안됨 => tmp.size의 사이즈가 k로 비교
        for (int i = 0; i < N; i++) {
            now = Integer.parseInt(br.readLine());
            arr[i] = now;

            if(type[now] == 0) cnt++;
            type[now]++;

            int sub = i - K;

            //개수가 충분한 경우 세팅
            if(sub >= 0){
                sub = arr[i - K];
                //한개 버리기
                type[sub]--;
                if(type[sub] == 0) cnt--;
            }

            //k개 선택된 경우 => 초밥 가지수 구하기
            if(sub >= -1){
                if(type[C] != 0) Result = Math.max(Result, cnt);
                else Result = Math.max(Result, cnt + 1);
            }
        }

        //초밥이 회전해서 앞쪽도 다시 봐야 됨
        for (int i = 0; i < K - 1; i++) {
            now = arr[i];
            int sub = arr[N - K + i];

            if(type[now] == 0) cnt++;
            type[now]++;

            type[sub]--;
            if(type[sub] == 0) cnt--;

            if(type[C] != 0) Result = Math.max(Result, cnt);
            else Result = Math.max(Result, cnt + 1);
        }
    }
}
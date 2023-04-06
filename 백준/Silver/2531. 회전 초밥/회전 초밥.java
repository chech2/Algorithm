import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Queue<Integer> tmp = new ArrayDeque<>();

    static int N, D, K, C, Result, cnt;
    static int type[], now[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Result = Integer.MIN_VALUE;
        type = new int[D + 1];
        now = new int[N];

        for (int i = 0; i < N; i++) now[i] = Integer.parseInt(br.readLine());

        count(now, N);
        count(now, K);
        System.out.println(Result);
    }

    static void count(int [] arr, int MAX){
        int num;
        int size;

        //비교 개수가 그냥 k이면 안됨 => tmp.size의 사이즈가 k로 비교
        for (int i = 0; i < MAX; i++) {
            size = tmp.size();
            num = arr[i];
            type[num]++;
            tmp.add(num);

            //개수가 충분한 경우 세팅
            if(size >= K){
                //한개 버리기
                int tmpnow = tmp.poll();
                type[tmpnow]--;
            }

            //k개 선택된 경우 => 초밥 가지수 구하기
            if(size >= K - 1){
                cnt = 0;
                for (int j = 1; j < D + 1; j++) {
                    if(type[j] == 0) continue;
                    cnt++;
                }
                if(type[C] != 0) Result = Math.max(Result, cnt);
                else Result = Math.max(Result, cnt + 1);
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, H, ans, cnt;
    //석순, 종유석
    static int[] top, bottom, result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;

        top = new int[H + 2];
        bottom = new int[H + 2];
        result = new int[H + 2];
        for (int i = 0; i < N; i++) {
            if(i % 2 == 0) bottomInput(Integer.parseInt(br.readLine()));
            else topInput(Integer.parseInt(br.readLine()));
        }

        //누적합 계산
        for (int i = 1; i <= H + 1; i++) bottom[i] += bottom[i - 1];
        for (int i = H + 1; 0 < i ; i--) top[i - 1] += top[i];
        for (int i = 0; i < H + 1; i++) result[i] = top[i] + bottom[i];

        cnt = 0;
        for (int i = 0; i < H; i++) {
            if(result[i] > ans){
                ans = result[i];
                cnt = 1;
            }else if(result[i] == ans) cnt++;
        }
        System.out.println((N - ans) + " " + cnt);
    }

    //종유석 입력, H - num 미만 시 파괴 x
    public static void topInput(int num){
        if(0 < H - num) top[H - num]++;
    }
    //석순, num 초과 시 파괴 x
    public static void bottomInput(int num){
        if(num + 1 < H) bottom[num + 1]++;
    }



}
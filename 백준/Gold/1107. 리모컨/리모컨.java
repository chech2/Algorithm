import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    일단, 중복 순열로 가장 목표값과 차이가 적은 값을 구해 => 버튼의 개수는 목푶값의 자릿수
        +, -해서 차이 구하기
        vs
        +,-만 해서 값 구하기
*/
public class Main {
    static int N, M, ans, Nsize;
    static int[] numbers = {1,1,1,1,1,1,1,1,1,1};
    static int[] result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ans = Math.abs(100 - N);

        //버튼 눌러볼 필요가 있는 경우
        if(ans != 0){
            if(M != 0) st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int delete = Integer.parseInt(st.nextToken());
                numbers[delete] = 0;
            }
            int check = 0;
            for (int i = 0; i < 10; i++) {
                if(numbers[i] != 0) check += i;
            }

            int copy = N;
            if(N == 0) Nsize++;
            while(copy > 0){
                Nsize++;
                copy /= 10;
            }
            result = new int[Nsize + 1];
            for (int i = 1; i <= Nsize + 1; i++) {
                perm(0, i);
            }
        }

        System.out.println(ans);
    }

    static void perm(int cnt, int size){
        if(cnt == size){
            int channel = 0, disit = 0, tmp = 0;

            //수 비교를 위해 배열을 int로 만들기
            for (int i = 0; i < cnt; i++)
                channel = channel * 10 + result[i];
            //버튼 눌러서 이동한 채널의 자릿수 구하기
            //0번으로 이동한 경우
            if (channel == 0) disit++;

            //0이 아닌 채널로 이동한 경우
            int copy = channel;
            while(copy > 0){
                disit++;
                copy /= 10;
            }
            tmp = Math.abs(channel - N) + disit;

            ans = Math.min(tmp, ans);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(numbers[i] == 0) continue;
            result[cnt] = i;
            perm(cnt + 1, size);
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, totalcnt;
    static int[] number, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         number = new int[N];
         result = new int[3];

        for (int i = 0; i < N; i++) {
            number[i] = i + 1;
        }

        permutation(0, 0);
        System.out.println(totalcnt);
    }

    public static void permutation(int cnt, int sum){
        if(cnt == 3){
            if(sum == N){
                if(result[0] % 2 == 0 && result[1] + 2 <= result[2]){ // 택희의 사탕 수는 짝수
                        totalcnt++;
                }
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            result[cnt] = number[i];
            permutation(cnt + 1, sum + number[i]);
        }
    }
}
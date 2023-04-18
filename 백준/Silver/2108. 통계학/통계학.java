import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, maxF, second, MAX;
    static long mid, range, cnt;

    static double sum;
    static int [] number, frequent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        frequent = new int[8001];

        int now;
        for (int i = 0; i < N; i++) {
            now = Integer.parseInt(br.readLine());
            sum += now;
            number[i] = now;
            frequent[now + 4000]++;
            if(MAX < frequent[now + 4000]) MAX = frequent[now + 4000];
        }
        Arrays.sort(number);
        mid = number[N / 2];
        range = number[N - 1] - number[0];

        for (int i = 0; i <= 8000; i++) {
            if(frequent[i] == 0) continue;
            if(MAX == frequent[i]){
                cnt++;
                second = i;
                if(cnt == 2){
                    break;
                }
            }
        }
        second -= 4000;
        System.out.println(Math.round(sum / N));
        System.out.println(mid);
        //if(cnt < 2) System.out.println((maxF - 4000));
        System.out.println(second);
        System.out.println(range);
    }
}
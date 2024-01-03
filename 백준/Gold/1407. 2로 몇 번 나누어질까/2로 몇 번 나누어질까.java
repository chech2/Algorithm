import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static long A, B;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken()) - 1;
        B = Long.parseLong(st.nextToken());

        System.out.println(countingPower(B) - countingPower(A));
    }

    // 2의 x승이 몇개인가??
    public static long countingPower(long number){
        long cnt;     // 2의 n승이 몇개인가?
        long sum = 0; // 2의 n승의 합
        long pow = 1; // 2의 n승에서 n 담당

        while(0 < number){
            if(number % 2 == 0) cnt = number / 2;
            else cnt = number / 2 + 1;
            sum += cnt * pow;
            number -= cnt;
            pow *= 2;
        }

        return sum;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    static int n;
    static boolean result;
    static long number;
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        eratosthenes();


        for (int i = 0; i < n; i++) {
            number = Long.parseLong(br.readLine());
            result = true;

            for (int j = 0; j < 1000000; j++) {
                if(!isPrime[j]) continue;
                if(number % j == 0) {
                    result = false;
                }
            }
            if(result) sb.append("YES\n");
            else  sb.append("NO\n");
        }
        System.out.println(sb);
    }

    public static void eratosthenes(){
        for (int i = 2; i <= 1000000 ; i++) {
            if(!isPrime[i]) continue;
            for (int j = i * 2; j <= 1000000 ; j += i) {
                isPrime[j] = false;
            }

        }

    }
}
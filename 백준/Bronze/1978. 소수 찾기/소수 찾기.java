import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int n, ans;
    static int[] numbers;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();

        findPrime();
        System.out.println(ans);
    }

    public static void findPrime(){

        for (int i = 0; i < numbers.length; i++) {
            if(isPrime(numbers[i])) ans++;
        }
    }

    public static boolean isPrime(int number){
        if(number == 1) return false;

        for (long i = 2; i * i <= number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
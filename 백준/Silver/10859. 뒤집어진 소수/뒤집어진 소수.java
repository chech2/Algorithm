import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[] numbers, reverseNumber;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numbers = br.readLine().toCharArray();

        if(reverse(numbers)){
            if (isPrime(numbers) && isPrime(reverseNumber)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }else {
            System.out.println("no");
        }

    }
    static boolean reverse(char[] number){
        reverseNumber = new char[number.length];


        for (int i = numbers.length - 1, j = 0; 0 <= i; i--, j++) {
            if(numbers[i] == '3' ||numbers[i] == '4' || numbers[i] == '7') {
                return false;
            } else if(numbers[i] == '0' || numbers[i] == '1' ||numbers[i] == '2' ||numbers[i] == '5' ||numbers[i] == '8') {
                reverseNumber[j] = numbers[i];
            }
            else {
                if(numbers[i] == '6') reverseNumber[j] = '9';
                else reverseNumber[j] = '6';
            }
        }

        return true;
    }

    static boolean isPrime(char[] number){
        long num = Long.parseLong(String.valueOf(number));
        if(num < 2) return false;

        for (long i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

}
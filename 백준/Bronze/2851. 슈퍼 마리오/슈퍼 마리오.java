import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] input = new int[11];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < 11; i++) {
            input[i] = input[i - 1] + Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < 11; i++) {
            if(input[i] == 100){
                System.out.println(input[i]);
                break;
            }else if(100 < input[i]){
                if(100 - input[i - 1] < input[i] - 100){
                    System.out.println(input[i - 1]);
                }else{
                    System.out.println(input[i]);
                }
                break;
            }else if(i == 10){
                System.out.println(input[i]);
            }
        }
    }
}
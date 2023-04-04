import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int ONE[], Zero[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC =  Integer.parseInt(br.readLine());
        int n;

        for (int t = 0; t < TC; t++) {
            n = Integer.parseInt(br.readLine());
            if(n != 0) {
                ONE = new int[n + 1];
                Zero = new int[n + 1];

                ONE[0] = 0;
                ONE[1] = 1;
                Zero[0] = 1;
                Zero[1] = 0;

                ONE[n] = fibonacciONE(n);
                Zero[n] = fibonacciZero(n);
                sb.append(Zero[n]).append(" ").append(ONE[n]).append("\n");

            }else sb.append("1 0\n");
        }
        System.out.println(sb);

    }

    static int fibonacciONE(int n){
        if(n > 1 && ONE[n] == 0)
            ONE[n] = fibonacciONE(n  - 1) + fibonacciONE(n - 2);
        return ONE[n];
    }
    static int fibonacciZero(int n){
        if(n > 1 && Zero[n] == 0)
            Zero[n] = fibonacciZero(n  - 1) + fibonacciZero(n - 2);
        return Zero[n];
    }
}
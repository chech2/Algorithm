import java.util.Scanner;

public class Main {

    static int N, result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // i = b, j = a
        for (int i = 1; i <= 499; i++) {
            for (int j = i; j <= 499 ; j++) {
                if(i * i + N == j * j) result++;
            }
        }
        System.out.println(result);
    }

}
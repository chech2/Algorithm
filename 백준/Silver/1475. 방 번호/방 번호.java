import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int num[] = new int[10];
    static int N, ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        while(N > 0){
            num[N % 10]++;
            N /= 10;
        }
        int tmp;
        if((num[6] + num[9]) % 2 == 0)
            tmp = (num[6] + num[9]) / 2;
        else {
            tmp = (num[6] + num[9]) / 2 + 1;
        }
        num[9] = tmp;
        num[6] = tmp;
        for (int i = 0; i < 10; i++) {
            ans = Math.max(num[i], ans);
        }
        System.out.println(ans);
    }
}
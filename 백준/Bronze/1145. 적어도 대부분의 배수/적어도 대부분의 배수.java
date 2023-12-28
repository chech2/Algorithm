import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] input = new int[5];
    static int maxNum, minNum, cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);
        maxNum = input[4] * input[3] * input[2];
        minNum = input[0];

        for (int i = minNum; i <= maxNum; i++) {

            cnt = 0;
            for (int j = 0; j < 5; j++) {
                if(i % input[j] == 0) cnt++;
            }
            if(3 <= cnt) {
                System.out.println(i);
                break;
            }
        }

    }
}
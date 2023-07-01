import java.util.Scanner;

public class Main {
    static int start, end;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        end = sc.nextInt();
        start = 1;

        int ans = 1;
        int cnt = 1;
        int tmp = start;
        if(end == 1) System.out.println(1);

        while (tmp < end){
            tmp += 6 * cnt;
            if(tmp >= end){
                System.out.println((cnt + 1));
            }
            ans++;
            cnt++;
        }
    }
}
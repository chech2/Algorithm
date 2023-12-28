import java.util.Scanner;

public class Main {
    static int n, m, k, team;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        team = 0;

        int girl, boy;
        for (int i = 0, j = k; i <= k; i++, j--) {
            girl = n - i;
            boy = m - j;
            if(girl < 0 || boy < 0) continue;

            team = Math.max(team, Math.min((girl / 2), boy));
        }
        System.out.println(team);
    }
}
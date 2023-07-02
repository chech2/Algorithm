import java.util.Scanner;

public class Main {
    static int N, M, W, H, high, width;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt() + 1;
        M = sc.nextInt() + 1;

        high = (int)Math.ceil(H / (double)N);
        width = (int)Math.ceil(W / (double)M);
        System.out.println((high * width));
    }
}
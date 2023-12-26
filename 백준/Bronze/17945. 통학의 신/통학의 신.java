import java.util.Scanner;

public class Main {

    static int A, B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt() * 2;
        B = sc.nextInt();
  
        double tmp1 = Math.pow(A, 2) - 4 * B;
        int tmp2 = (int)(-A + Math.sqrt(tmp1)) / 2;
        int tmp3 = (int)(-A - Math.sqrt(tmp1)) / 2;
        if (tmp2 == tmp3) {
            System.out.println(tmp2);
        } else {
            System.out.println(Math.min(tmp2, tmp3) + " " + Math.max(tmp2, tmp3));
        }

    }

}
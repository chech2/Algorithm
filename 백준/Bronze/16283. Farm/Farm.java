import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int a, b, n, w;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();   // 양 한마리가 먹는 사료
        b = sc.nextInt();   // 염소 한마리가 먹는 사료
        n = sc.nextInt();   // 총 마리수
        w = sc.nextInt();   // 소비된 총 사료

        // i = 양의 수, j = 염소의 수
        for (int i = 1, j = n - 1; i < n; i++, j--) {
            if (i * a + j * b == w) list.add(i + " " + j);
        }

        if(list.size() == 1) System.out.println(list.get(0));
        else System.out.println(-1);
    }
}
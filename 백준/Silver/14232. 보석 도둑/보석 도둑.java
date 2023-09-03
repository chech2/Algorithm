import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static long K, result;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextLong();

        for (int i = 2; i < K / i; i++) {
            while(K % i == 0){
                K /= i;
                list.add(i);
                result++;
            }
        }
        if(K != 1) result++;
        System.out.println(result);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        if(K != 1) System.out.println(K);
    }

}
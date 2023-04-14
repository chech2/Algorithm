import java.util.Scanner;

public class Main {
    static final String endWorld = "666";
    static int N;
    static String result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if(N == 1) {
            System.out.println(666);
            return;
        }
        result = "667";
        int endcnt = 2;
        while(true){
            if(result.contains(endWorld)){
                if(endcnt == N) {
                    System.out.println(result);
                    break;
                }
                else
                    endcnt++;
            }
            result = String.valueOf(Integer.parseInt(result) + 1);
        }

    }
}
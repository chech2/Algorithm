import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

    static int E, S, M, ans, inE, inS, inM;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inE = sc.nextInt();
        inS = sc.nextInt();
        inM = sc.nextInt();

        while(true){
            ans++;
            E++;
            S++;
            M++;
            if(E > 15) E = 1;
            if(S > 28) S = 1;
            if(M > 19) M = 1;
            if(inE == E && inS == S && inM == M) break;
//            System.out.println(E + " " + S + " " + M);
        }
//        System.out.println(E + " " + S + " " + M + " 결과: " + ans);
        System.out.println(ans);
    }
}
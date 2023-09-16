import java.util.*;
import java.io.*;

public class Main {

    static int[] dwarf = new int[9];
    static int[] sub = new int[2];
    static int start, end, cm, cnt, total;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            dwarf[i] = sc.nextInt();
            total += dwarf[i];
        }
        Arrays.sort(dwarf);
        combi(0, 0);
    }
    public static void combi(int cnt, int start){
        if(cnt == 2){
            int check = 0;
            for (int i = 0; i < 9; i++) {
                if(sub[0] == dwarf[i] || sub[1] == dwarf[i]) continue;
                check += dwarf[i];
            }
            if(check == 100){
                for (int j = 0; j < 9; j++) {
                    if(sub[0] == dwarf[j] || sub[1] == dwarf[j]) continue;
                    System.out.print(dwarf[j] + " ");
                }
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            sub[cnt] = dwarf[i];
            combi(cnt + 1, i + 1);
        }
    }

}
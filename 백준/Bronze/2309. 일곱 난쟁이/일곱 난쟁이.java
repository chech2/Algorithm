import java.io.*;
import java.util.*;
public class Main {

    static int total;
    static int[] people, selected;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /*
        note
            난쟁이 9명 중 7먕을 골라 100만들기
            1. 모든 난쟁이의 조함 => 9C7
            2. 모든 난쟁이 합 - 2명 골라서 빼기

    */
    public static void main(String[] args) throws Exception{
        people = new int[9];
        selected = new int[2];

        for (int i = 0; i < 9; i++) {
            people[i] = Integer.parseInt(br.readLine());
            total += people[i];
        }
        Arrays.sort(people);
        combi(0, 0, 0);
    }

    public static void combi(int start, int cnt, int sum){
        if(cnt == 2){
            if(total - sum == 100){
                for (int i = 0; i < 9; i++) {

                    if(selected[0] == people[i]) continue;
                    if(selected[1] == people[i]) continue;
                    sb.append(people[i]).append("\n");

                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            selected[cnt] = people[i];
            combi(i + 1, cnt + 1, sum + people[i]);
        }
    }

}
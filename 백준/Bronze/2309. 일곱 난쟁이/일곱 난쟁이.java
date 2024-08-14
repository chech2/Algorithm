import java.io.*;
import java.util.*;
public class Main {

    static int[] people, selected;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        people = new int[9];
        selected = new int[7];

        for (int i = 0; i < 9; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(people);
        combi(0, 0, 0);
    }

    public static void combi(int start, int cnt, int sum){
        if(cnt == 7){
            if(sum == 100){
                for (int i = 0; i < 7; i++) {
                    sb.append(selected[i]).append("\n");
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
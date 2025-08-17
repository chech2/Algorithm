import java.io.*;
import java.util.*;

public class Main {

    static int[] numbers, selected, answer;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        numbers = new int[9];
        selected = new int[7];
        answer = new int[7];

        for (int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);
        combi(0, 0, 0);
        
        for (int i = 0; i < 7; i++) sb.append(answer[i]).append("\n");
        bw.append(sb);
        bw.close();
    }

    static void combi(int cnt, int start, int sum) {
        if (cnt == 7) {
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    answer[i] = selected[i];
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            selected[cnt] = numbers[i];
            combi(cnt + 1, i + 1, sum + numbers[i]);
        }
    }
}
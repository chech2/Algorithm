import java.io.*;
import java.util.*;

public class Main {

    static int n, m, total, answer;
    static int[] states;

    public static void main(String[] args) throws Exception {
        preSetting();
        if (m < total) binarySearch();
        
        System.out.println(answer);
    }

    static void binarySearch() {
        int s, e, budget, sub;

        s = 0;
        e = answer;
        while (s <= e) {
            budget = (s + e) / 2;
            sub = calculation(budget);

            if (m < total - sub) e = budget - 1;
            else s = budget + 1;

            if (total - sub <= m) answer = budget;
        }
    }

    static int calculation(int maxBudget) {
        int sum = total;

        for (int i = 0; i < n; i++) {
            if (maxBudget < states[i]) sum -= maxBudget;
            else sum -= states[i];
        }

        return sum;
    }

    static void preSetting() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        states = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            states[i] = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, states[i]);
            total += states[i];
        }
        m = Integer.parseInt(br.readLine());
    }
}
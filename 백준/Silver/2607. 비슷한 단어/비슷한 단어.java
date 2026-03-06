import java.io.*;

public class Main {

    static String[] words;
    static int n, cnt;
    static int[][] alphas;

    public static void main(String[] args) throws Exception {
        preSetting();
        int answer = 0;

        for (int i = 1; i < n; i++) answer += wordChecker(i, alphas[i]);
        System.out.println(answer);
    }

    private static int wordChecker(int idx, int[] alpha) {
        int diff = cnt - words[idx].length();
        int category = 1;
        int sub = 0;

        if (1 < Math.abs(diff)) return 0;
        if (diff == 1 || diff == -1) category = 0;

        for (int j = 0; j < 26; j++) {
            sub += Math.abs(alphas[0][j] - alpha[j]);
        }

        if(category == 0 && 1 < sub) return 0;
        if(category == 1 && 2 < sub) return 0;

        return 1;
    }

    private static void preSetting() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        alphas = new int[n][26];
        words = new String[n];

        int idx;
        char[] charWord;
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            charWord = words[i].toCharArray();

            for (int j = 0; j < charWord.length; j++) {
                idx = charWord[j] - 'A';
                alphas[i][idx]++;
            }
        }
        cnt = words[0].length();
    }
}

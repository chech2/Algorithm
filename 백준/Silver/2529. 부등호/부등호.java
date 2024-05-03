import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static long minVal, maxVal;
    static char[] operation;
    static boolean[] visited = new boolean[10];
    static int[] selected, minArr, maxArr;
    static int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        input();
        perm(0, 0);
        print();
    }

    public static void print(){
        StringBuilder minSB = new StringBuilder();
        StringBuilder maxSB = new StringBuilder();

        for (int i = 0; i < n + 1; i++) {
            minSB.append(minArr[i]);
            maxSB.append(maxArr[i]);
        }
        System.out.println(maxSB);
        System.out.println(minSB);
    }

    public static void perm(int cnt, long num){
        if(cnt == n + 1){
            if(num < minVal) {
                minArr = selected.clone();
                minVal = num;
            }
            if(maxVal < num) {
                maxArr = selected.clone();
                maxVal = num;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(visited[i]) continue;

            selected[cnt] = number[i];
            if(cnt != 0) {
                if (operation[cnt - 1] == '<' && selected[cnt - 1] > selected[cnt]) continue;
                else if (operation[cnt - 1] == '>' && selected[cnt - 1] < selected[cnt]) continue;
            }
            visited[i] = true;
            perm(cnt + 1, num * 10 + selected[cnt]);
            visited[i] = false;
        }
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        operation = new char[n];
        selected = new int[n + 1];
        minVal = Long.MAX_VALUE;
        maxVal = Long.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            operation[i] = st.nextToken().charAt(0);
        }
    }
}
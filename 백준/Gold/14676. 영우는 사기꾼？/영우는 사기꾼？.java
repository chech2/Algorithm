import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final String isOk = "King-God-Emperor";
    static final String isLier = "Lier!";
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, k;
    static int[] p, cnt;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        input();
        check();

    }

    public static void check() throws Exception{
        int compare, mode;

        for (int i = 0; i < k; i++) {
            strToken();
            mode = Integer.parseInt(st.nextToken());
            compare = Integer.parseInt(st.nextToken());

            if(!isPossible(mode, compare)) {
                System.out.println(isLier);
                return;
            }
            play(mode, compare);
        }

        System.out.println(isOk);
    }
    public static boolean isPossible(int mode, int now){
        if((mode == 2 && cnt[now] <= 0) || (mode == 1 && p[now] != 0)) {
            return false;
        }
        return true;
    }

    public static void play(int mode, int now){

        // 1. 건설하는 경우
        if(mode == 1) {
            if(cnt[now] == 0) {
                for (int j = 0; j < list[now].size(); j++) {
                    p[list[now].get(j)]--;
                }
            }
            cnt[now]++;
        }
        // 2. 파괴하는 경우
        else {
            if(cnt[now] == 1) {
                for (int j = 0; j < list[now].size(); j++) {
                    p[list[now].get(j)]++;
                }
            }
            cnt[now]--;
        }
    }

    public static void input() throws Exception{
        strToken();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        cnt = new int[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList();
        }

        int start, end;
        for (int i = 0; i < m; i++) {
            strToken();
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            p[end]++;
        }
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

}
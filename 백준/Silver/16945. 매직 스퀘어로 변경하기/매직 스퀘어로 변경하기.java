import java.io.*;
import java.util.*;
public class Main {
    static int ans;
    static int[] map, numbers;// = new int[9];
    static boolean[] visited;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception{
        input();
        perm(0);
        System.out.println(ans);
    }

    public static void perm(int cnt){
        if(9 <= cnt){
//            System.out.println(Arrays.toString(numbers));
            if(isMagicSqure()) ans = Math.min(ans, ismin());
            return;
        }

        for (int i = 1; i < 10; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            numbers[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    public static int ismin(){
        int result = 0;
        for (int i = 0; i < 9; i++) {
            result += Math.abs(map[i] - numbers[i]);
        }
        return result;
    }

    public static boolean isMagicSqure(){
        int[] r, l, d;
        r = new int[3];
        l = new int[3];
        d = new int[2];

        for (int i = 0; i < 3; i++) {
            r[0] += numbers[i];
            r[1] += numbers[3 * 1 + i];
            r[2] += numbers[3 * 2 + i];

            l[i] = numbers[i] + numbers[3 * 1 + i] + numbers[3 * 2 + i];
            d[0] += numbers[i * 4];
            d[1] += numbers[2 * i + 2];
        }

        if(r[0] == r[1] && r[1] == r[2]  && r[2] == l[0] && l[0] == l[1] && l[1] == l[2] && l[2] == d[0] && d[0] == d[1]) return true;
        return false;
    }


    public static void input() throws Exception{
        map = new int[9];
        numbers = new int[9];
        visited = new boolean[10];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i * 3 + j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
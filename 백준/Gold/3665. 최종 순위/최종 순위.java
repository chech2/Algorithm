import java.util.*;
import java.io.*;
public class Main {
    static int T, n, m;
    static int[] lastyear, thisyear, up, down;
    static final String mola = "?";
    static final String no = "IMPOSSIBLE";

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input();
            sb.append(findRank()).append("\n");
        }
        System.out.println(sb);
    }

    public static String findRank(){
        String ans = "";
        int[] rank = new int[n + 1];
        int[] molacheck = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            thisyear[i] = lastyear[i] + up[i] + down[i];
//            System.out.println(thisyear[i]);
            if(n < thisyear[i] || thisyear[i] < 1) return no;
            else {
                molacheck[thisyear[i]]++;
                rank[thisyear[i]] = i;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if(molacheck[i] != 1) return no;
            ans += rank[i] + " ";

        }
//        System.out.println("rank " + Arrays.toString(rank));
//        System.out.println("rank " + Arrays.toString(rank));
        return ans;
    }

    public static void strToken() throws Exception{
        st = new StringTokenizer(br.readLine());
    }

    public static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        lastyear = new int[n + 1];
        thisyear = new int[n + 1];
        up = new int[n + 1];
        down = new int[n + 1];

        strToken();
        for (int i = 1; i < n + 1; i++) {
            lastyear[Integer.parseInt(st.nextToken())] = i;
        }

        m = Integer.parseInt(br.readLine());

        int idx1, idx2;
        for (int i = 0; i < m; i++) {
            strToken();
            idx1 = Integer.parseInt(st.nextToken());
            idx2 = Integer.parseInt(st.nextToken());
//            System.out.println(idx1 + "팀: " + lastyear[idx1] + "등, " + idx2 + "팀: " + lastyear[idx2] + "등");
            //작년 idx1: 승, idx2: 패
            if(lastyear[idx1] < lastyear[idx2]) {
//                System.out.println(">>>>>");
                up[idx2]--;
                down[idx1]++;
            }else{
                up[idx1]--;
                down[idx2]++;
            }
        }

//        System.out.println("작년: " + Arrays.toString(lastyear));
//        System.out.println("up: " + Arrays.toString(up));
//        System.out.println("down: " + Arrays.toString(down));
    }
}
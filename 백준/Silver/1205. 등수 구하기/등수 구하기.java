import java.io.*;
import java.util.*;

public class Main {

    static int n, p, score;
    static Integer[] scores;
    public static void main(String[] args) throws Exception{
        preSetting();
        if(!findCnt()){
            System.out.println(-1);
        } else{
            System.out.println(findRank());
        }
    }

    private static boolean findCnt(){
        int s, e, m, r;
        r = -1;
        s = 0;
        e = n;

        while(s <= e){
            m = (s + e) / 2;

            if(scores[m] < score){
                e = m - 1;
            } else if(score < scores[m]){
                s = m + 1;
            } else {
                r = m;
                s = m + 1;
            }
        }
        r++;
        if(p < r) return false;

        return true;
    }

    private static int findRank(){
        int s, e, m, l;
        l = -1;
        s = 0;
        e = n;

        while(s <= e){
            m = (s + e) / 2;

            if(scores[m] < score){
                e = m - 1;
            } else if(score < scores[m]){
                s = m + 1;
            } else {
                l = m;
                e = m - 1;
            }
        }
        l++;

        return l;
    }

    private static void preSetting() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        scores = new Integer[n + 1];

        if(n != 0) st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }
        scores[n] = score;
        Arrays.sort(scores, Collections.reverseOrder());
    }
}

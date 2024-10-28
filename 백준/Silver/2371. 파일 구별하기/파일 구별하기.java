import java.util.*;
import java.io.*;
public class Main {
    static final String EMPTY = "0 ";
    static int n, k;
    static ArrayList<Integer>[] files;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        pre_setting();
        int ans = -1;
//        int ans = binary_search();
        for(int i = 1; i < k; i++){
            if(is_divided(i)) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);;
    }

//    static int binary_search(){
//        int s, e, m, ans;
//
//        s = 0;
//        e = k;
//        ans = -1;
//
//        while(s < e){
//            m = (s + e) / 2;
//            System.out.println(m);
//            if(is_divided(m)){
//                ans = m;
//                s = m;
//            }else{
//                ans = m;
//                e = m;
//            }
//        }
//        return ans;
//    }

    static boolean is_divided(int standard){
        Map<String, Integer> map = new HashMap<>();

        String now;
        for(int i = 0; i < n; i++){
            now = "";

            if(files[i].size() < standard) {
                for (int j = 0; j < files[i].size(); j++) now += files[i].get(j) + " ";
//                for(int j = files[i].size(); j < standard; j++) now += EMPTY;

            }else{
                for(int j = 0; j < standard; j++) now += files[i].get(j) + " ";
            }

            map.put(now, 1);
        }
        if(map.size() == n) return true;
        return false;
    }

    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());
        files = new ArrayList[n];

        int now;
        for(int i = 0; i < n; i++){
            files[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            k = Math.max(k, st.countTokens());

            while(st.hasMoreTokens()){
                now = Integer.parseInt(st.nextToken());
                if(now != - 1) files[i].add(now);
            }
        }
    }
}
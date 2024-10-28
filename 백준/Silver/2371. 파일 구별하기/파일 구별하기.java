import java.util.*;
import java.io.*;
public class Main {
    static final String EMPTY = "0 ";
    static int n, k, ans;
    static Map<Integer, String>[] test;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        pre_setting();

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

        int empty = 0;
        for(int i = 0; i < n; i++){
            if(test[i].containsKey(standard)) {
                map.put(test[i].get(standard), 1);
            }else{
                empty++;
            }
        }
        if(map.size() + empty == n) return true;
        return false;
    }

    static void pre_setting() throws Exception{
        n = Integer.parseInt(br.readLine());
        test = new HashMap[n];

        int now, idx;
        String str, cur;
        for(int i = 0; i < n; i++){
            test[i] = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            k = Math.max(k, st.countTokens());

            str = "";
            idx = 1;
            while(st.hasMoreTokens()){

                cur = st.nextToken();
                str += cur + " ";
                now = Integer.parseInt(cur);
                if(now != - 1) {
                    test[i].put(idx++, str);
                }
            }
        }
    }
}
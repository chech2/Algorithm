import java.util.*;
import java.io.*;
public class Main {
    static final String EMPTY = "0 ";
    static int n, k, ans;
    static ArrayList<Integer>[] files;
    static Map<Integer, String>[] test;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        pre_setting();

        for(int i = 1; i < k; i++){
            if(is_divided(i)) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);;
    }

    static boolean is_divided(int standard){
        Map<String, Integer> map = new HashMap<>();

        String now;
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
        files = new ArrayList[n];
        test = new HashMap[n];

        int now, idx;
        String str, cur;
        for(int i = 0; i < n; i++){
            files[i] = new ArrayList<>();
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
                    files[i].add(now);
                    test[i].put(idx++, str);
                }
            }
        }
    }
}
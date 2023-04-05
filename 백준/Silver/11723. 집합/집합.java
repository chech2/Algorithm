import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<Integer> set = new HashSet<>();
    static List<Integer> defaultNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        int now = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
//            System.out.println(i);
            if(!tmp.equals("all") && !tmp.equals("empty"))
                now = Integer.parseInt(st.nextToken());
            if("add".equals(tmp)){
                set.add(now);

            }else if("remove".equals(tmp)){
                set.remove(now);

            }else if("check".equals(tmp)){
                if(set.contains(now)){
                    sb.append("1\n");
                }else sb.append("0\n");

            }else if("toggle".equals(tmp)){
                if(set.contains(now)){
                    set.remove(now);
                }else set.add(now);

            }else if("all".equals(tmp)){
                set.addAll(defaultNum);
            }else if("empty".equals(tmp)){
                set.clear();
            }
        }
        System.out.println(sb);
    }
}
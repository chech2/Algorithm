import java.io.*;

public class Main {

    static int n;
    static String s, t;
    static String[] strs;
    public static void main(String[] args) throws Exception{
        preSetting();
        findWord();

        System.out.println(s);
        System.out.println(t);
    }

    private static void findWord(){
        int answer = 0;
        int compare;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <n; j++){
                compare = compareStrs(strs[i], strs[j]);
                if(answer < compare) {
                    s = strs[i];
                    t = strs[j];
                    answer = compare;
                }
            }
        }
    }

    private static int compareStrs(String s1, String s2){
        if(s1.equals(s2)) return 0;

        int answer = 0;
        for(int i = 0; i < Math.min(s1.length(), s2.length()); i++){
            if(s1.charAt(i) != s2.charAt(i)) break;

            answer++;
        }
        return answer;
    }
    private static void preSetting() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        strs = new String[n];

        for(int i = 0; i < n; i++){
            strs[i] = br.readLine();
        }
    }
}

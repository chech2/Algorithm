import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long c;
    static long[] number;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());

        number = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Long.parseLong(st.nextToken());
            if (number[i] == c) {
                flag = true;
                break;
            }
        }
        Arrays.sort(number);

        //2개의 물품으로 구매 가능한 경우
        if(!flag) select();

        // 1 or 2 or 3개의 물품으로 구매 가능한 경우
        if(flag) bw.append("1");
        else bw.append("0");

        bw.flush();
        bw.close();
    }

    public static void select(){
        int start = 0;
        int end = n - 1;
        long select2;

        while (start < end) {
            select2 = number[start] + number[end];

            // 두개로 가능한 경우
            if (select2 == c) {
                flag = true;
                return;
            } 
            else if(c < select2) end--;
            else{
                for (int i = 0; i < n - 1; i++) {
                    if(i == start || i == end) break;
                    if(c - select2 == number[i]) {
                        flag = true;
                        return;
                    }
                }
                start++;
            }
        }
    }
}
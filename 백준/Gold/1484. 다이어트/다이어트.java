import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int x, y, c; // x: 현재 몸무게, y: 이전 몸무게, c: x^2 - y
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        c = Integer.parseInt(br.readLine());

        x = 1; // 현재 몸무게
        y = 1; // 과거 몸무게
        int tmp = 0;
        while(true){
            tmp = x * x - y * y;
            
            if(c < tmp && x - y == 1) break;

            if(tmp <= c){
                if(tmp == c) {
                    flag = true;
                    bw.append(x + "\n");
                }
                x++;
            }else {
                y++;
            }
        }
        if(!flag) bw.append("-1");
        bw.flush();
        bw.close();
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int maxNum, row, col;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        maxNum = -1;
        for (int i = 1; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(maxNum < now){
                    maxNum = now;
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(maxNum);
        System.out.println(row + " " + col);
    }

}
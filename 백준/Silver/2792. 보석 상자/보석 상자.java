import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int children, color, ans;
    static int[] colors;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        children = Integer.parseInt(st.nextToken());
        color = Integer.parseInt(st.nextToken());
        colors = new int[color];

        for (int i = 0; i < color; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            ans = Math.max(colors[i], ans);
        }

        //보석의 색상 수와 학생수가 일치할 경우 분배할 필요 없음
        if(children != color) {
            int start = 1;
            int end = ans - 1;
            int mid;
            while(start <= end){
                mid = (start + end) / 2;

                //질투심을 mid로 감소시킬 수 있는 경우
                if(isPossible(mid)){
                    end = mid - 1;
                    ans = mid;
                }
                //감소 시킬 수 없는 경우
                else {
                    start = mid + 1;
                }
            }
        }
        bw.append(ans + " ");
        bw.flush();
        bw.close();
    }
    public static boolean isPossible(int number){
        int smallCnt = 0, bigCnt = 0;
        for (int i = 0; i < color; i++) {
            if(colors[i] <= number){
                smallCnt++;
                continue;
            }
            bigCnt += colors[i] / number;
            if(colors[i] % number != 0) bigCnt++;
        }
        if(smallCnt + bigCnt <= children) return true;
        return false;
    }
}
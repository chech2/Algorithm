import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int a,b,c;
    static PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int a = (int)(Math.pow(q.poll(),2));
            int b = (int)(Math.pow(q.poll(),2));
            int c = (int)(Math.pow(q.poll(),2));


            if(a == 0){ //변의 길이는 0이 될 수 없음
                break;
            }
            if(c == a + b)
                sb.append("right\n");
            else
                sb.append("wrong\n");
        }
        System.out.println(sb);

    }
}
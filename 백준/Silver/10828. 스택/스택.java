import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
            else if(command.equals("pop")){
                if(list.size() == 0) sb.append(-1).append("\n");
                else sb.append(list.removeLast()).append("\n");
            }
            else if(command.equals("size")) {
                sb.append(list.size()).append("\n");
            }
            else if(command.equals("empty")) {
                if(list.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else {
                if(list.isEmpty()) sb.append(-1).append("\n");
                else sb.append(list.getLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
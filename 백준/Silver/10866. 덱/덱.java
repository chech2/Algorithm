import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int SIZE, N;
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        SIZE = 0;
        int num = 0;

        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String CMD = st.nextToken();
            if(CMD.contains("push")) {
                num = Integer.parseInt(st.nextToken());
                SIZE++;
            }

            if(CMD.equals("push_front")) list.addFirst(num);
            else if (CMD.equals("push_back")) list.addLast(num);
            else if (CMD.equals("pop_front")) {
                if(SIZE == 0) sb.append(-1).append("\n");
                else{
                    sb.append(list.getFirst()).append("\n");
                    list.removeFirst();
                    SIZE--;
                }
            }else if (CMD.equals("pop_back")) {
                if(SIZE == 0) sb.append(-1).append("\n");
                else{
                    sb.append(list.getLast()).append("\n");
                    list.removeLast();
                    SIZE--;
                }
            }else if (CMD.equals("size")) {
                sb.append(SIZE).append("\n");
            }else if (CMD.equals("empty")) {
                if(SIZE == 0) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if (CMD.equals("front")) {
                if(SIZE == 0) sb.append(-1).append("\n");
                else{
                    sb.append(list.getFirst()).append("\n");
                }
            }else {
                if(SIZE == 0) sb.append(-1).append("\n");
                else{
                    sb.append(list.getLast()).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int TC, N;
    static ArrayDeque<String> Q;
    static char[] Operation, Qchar;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            boolean flag = true;
            Q = new ArrayDeque<>();
            int Rcnt = 0;

            Operation = br.readLine().toCharArray();

            N = Integer.parseInt(br.readLine());
            Qchar = br.readLine().toCharArray();

            for (int i = 1; i < Qchar.length - 1; i++) {
                if (Qchar[i] != ',') {
                    int tmp = 0;
                    while (Qchar[i] != ',' && i < Qchar.length - 1) {
                        tmp = tmp * 10 + Qchar[i] - '0';
                        i++;
                    }
                    Q.add(String.valueOf(tmp));
                }
            }

            for (int i = 0; i < Operation.length; i++) {
                if (Operation[i] == 'R') {
                    Rcnt++;
                } else {
                    if (Q.isEmpty()) {
                        flag = false;
                        sb.append("error\n");
                        break;
                    }
                    if(Rcnt % 2 == 0)
                        Q.poll();
                    else
                        Q.pollLast();
                }
            }
            if (flag) {
                sb.append("[");
                while (!Q.isEmpty()) {
                    if(Rcnt % 2 == 0)
                        sb.append(Q.poll());
                    else
                        sb.append(Q.pollLast());
                    if (!Q.isEmpty())
                        sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}
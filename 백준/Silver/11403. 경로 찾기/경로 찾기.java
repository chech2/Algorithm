import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static int[][] arr, result;
    static int N;
    static Queue<node> queue = new ArrayDeque<node>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    queue.add(new node(i, j));
                }
            }
        }

        while (!queue.isEmpty()){
            node now = queue.poll();

            if(result[now.i][now.j] != 1){
                result[now.i][now.j] = 1;
                for (int i = 0; i < N; i++) {
                    if(arr[now.j][i] == 1){
                        queue.add(new node(now.i, i));
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    static class node{
        int i, j;
        node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
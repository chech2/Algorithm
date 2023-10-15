import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N, M, K;
    static int[][] map, food;
    static Deque<tree> trees = new ArrayDeque<>();
    static Deque<tree> parent = new ArrayDeque<>();
    //상 하 좌 우 우상, 우좌, 좌상, 좌하 => 8방 탐색
    static int [] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int [] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        food = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                food[i][j] = 5;
            }
        }

        int treeX, treeY, treeAge;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            treeX = Integer.parseInt(st.nextToken());
            treeY = Integer.parseInt(st.nextToken());
            treeAge = Integer.parseInt(st.nextToken());

            trees.add(new tree(treeAge, treeX, treeY, true));
        }
        trees = trees.stream()
                .sorted(new treeSet())
                .collect(Collectors.toCollection(ArrayDeque::new));


        for (int i = 0; i < K; i++) {
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(trees.size());

    }
    public static void spring(){
        int size = trees.size();
        tree now;
        for (int i = 0; i < size; i++) {
            now = trees.poll();

            //나이만큼 양분을 먹을 수 있는 경우
            if(now.age <= food[now.r][now.c]){
                food[now.r][now.c] -= now.age;
                now.age++;
                if(now.age % 5 == 0) parent.add(now);
            }else
                now.aliveStatus = false;
            trees.add(now);
        }
    }
    public static void summer(){
        int size = trees.size();
        tree now;
        for (int i = 0; i < size; i++) {
            now = trees.poll();

            //사망
            if(!now.aliveStatus) {
                food[now.r][now.c] += now.age / 2;
            }else trees.add(now);
        }
    }

    //가을, 번식
    public static void autumn(){
        int size = parent.size();
        tree now;
        for (int i = 0; i < size; i++) {
            now = parent.poll();

            // 번식하는 나무의 나이가 5배수
            if(now.age % 5 == 0 ){
                int r = now.r;
                int c = now.c;
                for (int j = 0; j < 8; j++) {
                    int nextR = r + dx[j];
                    int nextC = c + dy[j];
                    if(nextR <= 0 || nextR > N || nextC <= 0 || nextC > N) continue;
                    trees.addFirst(new tree(1, nextR, nextC, true));
                }
            }
//            trees.add(now);
        }
    }
    public static void winter(){
        for (int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++){
                food[i][j] += map[i][j];
            }
        }
    }

    public static class treeSet implements Comparator<tree> {
        @Override
        public int compare(tree o1, tree o2) {
            return o1.age - o2.age;
        }
    }

    public static class tree{
        int age, r, c;
        boolean aliveStatus;
        tree(int age, int r, int c, boolean aliveStatus){
            this.age = age;
            this.r = r;
            this.c = c;
            this.aliveStatus = aliveStatus;
        }
    }

}
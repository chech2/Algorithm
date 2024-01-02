import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, w;
    static double limit;
    static poi[] coordinate;
    static double[] d;
    static ArrayList<node>[] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());       // 발전소의 개수
        w = Integer.parseInt(st.nextToken());       // 현재 사용된 전선의 개수
        limit = Double.parseDouble(br.readLine());  // 제한 길이
        coordinate = new poi[n + 1];                // 발전소의 위치정보를 저장하는 배열
        d = new double[n + 1];                      // 1번 발전소와의 최단 거리 저장 배열
        map = new ArrayList[n + 1];                 // 간선 정보를 저장할 ArrayList[]

        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        for (int i = 1; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        int x, y;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            coordinate[i] = new poi(x, y);
        }

        int n1, n2;
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            map[n2].add(new node(n1, 0));
            map[n1].add(new node(n2, 0));
        }

        //현재 존재하는 전선을 이용한 최단 경로 구하기
        makeLine();
        dijk();
        System.out.println((long)Math.floor(d[n] * 1000));
    }
    public static double distance(int n1, int n2){
        long x = coordinate[n1].x - coordinate[n2].x;
        long y = coordinate[n1].y - coordinate[n2].y;
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    public static void makeLine(){
        double len;
        for (int now = 1; now < n + 1; now++) {
            for (int next = now + 1; next < n + 1; next++) {
                len = distance(now, next);
                if(len <= limit) {
                    map[now].add(new node(next, len));
                    map[next].add(new node(now, len));
                }
            }
        }
    }

    public static void dijk(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);

        int now, nextNum;
        double nextLen;
        node next;
        while(!q.isEmpty()){
            now = q.poll();
            nextNum = 0;
            nextLen = Integer.MAX_VALUE;


            //현재 노드에서 갈 수 있는 최단 노드와 거리 찾기
            for (int i = 0; i < map[now].size(); i++) {
                // 이동할 수 있는 후보 노드
                next = map[now].get(i);

                //최단 거리 갱신
                if(d[now] + next.len < d[next.number]){
                    d[next.number] = d[now] + next.len;
                    q.add(next.number);
                }

            }
        }
    }



    static class poi{
        int x, y;
        poi(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class node{
        int number;
        double len;
        node(int number, double len){
            this.number = number;
            this.len = len;
        }
    }

}
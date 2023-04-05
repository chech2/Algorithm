import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    //행방향.열방향 2번 체크: 1) 높이가 모두 같은 경우 2) 다른 경우
    //다르다면 1) 높이가 1낮아지는 경우 2) 높이가 1 높아지는 경우 3) 높이가 2이상 차이나는 경우
    //한줄에 여러개의 경사로가 있을 수 있음

    static int map[][];
    static int TC, N, X, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            result = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                result += colCheck(i);
                result += rowCheck(i);
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int rowCheck(int num) {
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if(i == N - 1 || map[num][i] != map[num][i + 1]){
                high.add(map[num][i]);
                size.add(++cnt);
                cnt = 0;
            }else{
                cnt++;
            }
        }

        for (int i = 0; i < size.size() - 1; i++) {
            //같은 칸의 경우 같은 size와 high번지에 소속되어 있으므로 고려 대상 아님
            //한단계 차이인 경우 (오름차순)
            if(high.get(i) + 1 == high.get(i + 1)){
                size.set(i, size.get(i) - X);
                //위에서 작은쪽 칸을 경사로 건설에 사용하였음
                //칸이 모자르다면 음수일 것이고, 아니라면 양수일 것임
                if(size.get(i) < 0) return 0;
            }
            //한단계 차이 (내림차순)
            else if(high.get(i) == high.get(i + 1) + 1){
                size.set(i + 1, size.get(i + 1) - X);
                if(size.get(i + 1) < 0) return 0;
            }else{ //같은 칸도 아니고 1칸 차이도 아닌 경우 => 경사로 건설 불가
                return 0;
            }
        }
        //전부다 고려했는데 못가는 건설 불가능한 경우가 존재하지 않았음
        return 1;
    }

    private static int colCheck(int num) {
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if(i == N - 1 || map[i][num] != map[i + 1][num]){
                high.add(map[i][num]);
                size.add(++cnt);
                cnt = 0;
            }else{
                cnt++;
            }
        }

        for (int i = 0; i < size.size() - 1; i++) {
            //같은 칸의 경우 같은 size와 high번지에 소속되어 있으므로 고려 대상 아님
            //한단계 차이인 경우 (오름차순)
            if(high.get(i) + 1 == high.get(i + 1)){
                size.set(i, size.get(i) - X);
                //위에서 작은쪽 칸을 경사로 건설에 사용하였음
                //칸이 모자르다면 음수일 것이고, 아니라면 양수일 것임
                if(size.get(i) < 0) return 0;
            }
            //한단계 차이 (내림차순)
            else if(high.get(i) == high.get(i + 1) + 1){
                size.set(i + 1, size.get(i + 1) - X);
                if(size.get(i + 1) < 0) return 0;
            }else{ //같은 칸도 아니고 1칸 차이도 아닌 경우 => 경사로 건설 불가
                return 0;
            }
        }
        //전부다 고려했는데 못가는 건설 불가능한 경우가 존재하지 않았음
        return 1;
    }

    static void print(ArrayList<Integer> out){
        for (int i = 0; i < out.size(); i++) {
            System.out.print(out.get(i) + " ");
        }
        System.out.println("--");
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int R, C, Time;
    static ArrayList<Integer> cleaner = new ArrayList<>();
    static int [][] map;
    //상하좌우
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static Queue<int []> q = new ArrayDeque<>();
//    static ArrayList<int[]> Particulates = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Time = Integer.parseInt(st.nextToken());
        map = new int [R + 1][C + 1];

        for (int i = 1; i < R + 1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < C + 1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
//                if(map[i][j] > 0)
//                    Particulates.add(new int[]{i,j});
                if(map[i][j] == -1)
                    //y좌표는 항상 1이므로 관리할 필요 없음
                    cleaner.add(i);
            }
        }
        ////////////////입력값 세팅 완료////////////////////////////////////////////

        //Time동안 일이 진행
        for (int t = 0; t < Time; t++){
            //미세먼지 확산
            diffusion();
            //print();
//            System.out.println("확산완료");
            //공청기 가동
            //반시계
            counterclockwise(cleaner.get(0));
            //시계
            clockwise(cleaner.get(1));
//            print();
//            System.out.println("공청기 가동 완료");
        }

        //t초의 시간이 지난 후 미세먼지의 량 계산하기
        int result = 0;
        for (int i = 1; i < R + 1; i++){
            for (int j = 1; j < C + 1; j++) {
                result += map[i][j];
            }
        }
        System.out.println((result + 2));

    }

    //공청기 가동 함수
    private static void counterclockwise(int cleanerX) {
        //공청기 위의 칸의 미세머지 제거
        map[cleanerX - 1][1] = 0;

        //반시계 방향으로 미세먼지 이동
        //아래로 내리기
        for (int i = cleanerX - 2; 0 < i; i--){
            map[i + 1][1] = map[i][1];
        }
        //왼쪽으로 땡기기
        for(int i = 2; i < C + 1; i++){
            map[1][i - 1] = map[1][i];
        }
        //위로 올리기
        for (int i = 2; i < cleanerX + 1; i++){
            map[i - 1][C] = map[i][C];
        }
        //오른쪽으로 당기기
        for(int i = C - 1; 1 < i; i--){
            map[cleanerX][i + 1] = map[cleanerX][i];
        }
        map[cleanerX][2] = 0;
    }






    private static void clockwise(int cleanerX) {
        //공청기 위의 칸의 미세머지 제거
        map[cleanerX + 1][1] = 0;

        //반시계 방향으로 미세먼지 이동
        //위로 올리기
        for (int i = cleanerX + 2; i < R + 1; i++){
            map[i - 1][1] = map[i][1];
        }
        //왼쪽으로 땡기기
        for(int i = 2; i < C + 1; i++){
            map[R][i - 1] = map[R][i];
        }
        //아래로 내리기
        for (int i = R - 1; cleanerX - 1 < i; i--){
            map[i + 1][C] = map[i][C];
        }
        //오른쪽으로 당기기
        for(int i = C - 1; 1 < i; i--){
            map[cleanerX][i + 1] = map[cleanerX][i];
        }

        map[cleanerX][2] = 0;
    }


    //미세먼지 확산 관련 함수////////////////////////////////////////
    private static void diffusion() {
        //확산을 위한 미세먼지 정보 입력
        insertParticulatesInfo();
        while(!q.isEmpty()){
            //확산 개수
            int diffusionCnt = 0;

            //r,c,확산량
            int [] now = q.poll();
            int x = now[0]; // r
            int y = now[1];
            int prevValue = now[2];

            //4방 탐색 시작
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //map내부이고, 공기청정기가 존재하는 위치가 아닌 경우
                if(nx > 0 && nx <= R && ny >0 && ny <= C){
                    if(map[nx][ny] != -1){
                        diffusionCnt++;
                        map[nx][ny] += prevValue/5;
                    }
                }
            }
            map[x][y] -= (prevValue/5)*diffusionCnt;
        }
    }

    private static boolean isValid(int x, int y, int idx){
        //map내부이고, 공기청정기가 존재하는 위치가 아닌 경우
        if(1 <= x + dx[idx] && x + dx[idx] < R + 1
                && 1 <= y + dy[idx] && y + dy[idx] < C + 1
                && map[x + dx[idx]][y + dy[idx]] != -1)
            return true;
        return false;
    }

    //확산할 미세먼지의 정보 입력
    private static void insertParticulatesInfo() {
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if(map[i][j] == 0 || map[i][j] == -1 || map[i][j] < 5) continue;
//                int diffAmount = map[i][j] / 5;
                q.add(new int []{i, j, map[i][j]});
            }
        }
    }
    //미세먼지 확산 관련 함수 끝////////////////////////////////////////

    public static void print() {
        System.out.println();
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
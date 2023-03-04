import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, sharkNum;
    static int fishbowl[][];
    static ArrayList<shark> sharks = new ArrayList<>();
    static int dx[] = {0, -1, 1, 0,  0};
    static int dy[] = {0, 0,  0, 1, -1};

    static PriorityQueue<shark> duplicate = new PriorityQueue<>((o1,o2) -> o1.sharkNo - o2.sharkNo);


    public static class shark{
        int r;
        int c;
        int speed;
        int dir;
        int size;
        int sharkNo;

        public shark(int r, int c, int speed, int dir, int size, int sharkNo) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
            this.sharkNo = sharkNo;

        }


    }


    public static void move() {
        for (int i = 0; i < sharks.size(); i++) {
            shark now = sharks.get(i);
            //이미 죽은 상어 이므로 볼 필요 없음
            if (now.size == 0) continue;

            //이동 전 기존 위치 해제
            fishbowl[now.r][now.c] = 0;

            //상하
            if (now.dir == 1 || now.dir == 2) {
                now.r += now.speed % ((R - 1) * 2) * dx[now.dir];
                while (now.r < 1 || now.r > R) {
                    if (now.r > R) {
                        now.r = R - (now.r - R);
                        now.dir = 1;
                    }
                    if (now.r < 1) {
                        now.r = 1 + (1 - now.r);
                        //now.r = 2 * R + now.r;
                        now.dir = 2;
                    }
                }
            }
            //우좌
            else {
                now.c += (now.speed % ((C - 1) * 2) * dy[now.dir]);
                while (now.c < 1 || now.c > C) {

                    if (now.c > C) {
                        now.c = C - (now.c - C);
                        now.dir = 4;
                    }
                    if (now.c < 1) {
                        now.c = 1 + (1 - now.c);
//                        now.c = 2 * C + now.c;
                        now.dir = 3;
                    }
                }
            }
            //변경된 위치에 상어가 다른 상어가 존재하지 않는다면 일단 표시
            if (fishbowl[now.r][now.c] == 0) fishbowl[now.r][now.c] = now.sharkNo;

            //변경된 위치에 다른 상어 존재하면 동족 포식을 위한 임시 저장
            else {
                duplicate.add(sharks.get(i));
            }
        }
    }

    public static void DeathCertificate(int sharkNum){
        //만약 배열에 상어가 표시되어 있다면 삭제
//        sharkprint();
        int tmpR = sharks.get(sharkNum - 1).r;
        int tmpC = sharks.get(sharkNum - 1).c;
        if(fishbowl[tmpR][tmpC] == sharkNum)
            fishbowl[tmpR][tmpC] = 0;

        //배열에 표시되어 있는 상어의 넘버는 0과의 구분을 위해 +1되어 있으므로 -1
        //&& 살아있는 상어와의 구분을 위해 상어 번호를 제외한 모든 값을 0으로 변경
        sharkNum--;
        sharks.get(sharkNum).r = 0;
        sharks.get(sharkNum).c = 0;
        sharks.get(sharkNum).speed = 0;
        sharks.get(sharkNum).dir = 0;
        sharks.get(sharkNum).size = 0;
    }

    //동족 포식
    public static void cannibalism(){
        //큰 상어가 작은 상어 잡아먹기
        while (!duplicate.isEmpty()) {
            shark now = duplicate.poll();

            //순서대로 상어를 이동시켰기 때문에 이젠 상어가 떠났을 수 있음! <= 상어 입력하고 종료
            if(fishbowl[now.r][now.c] == 0){
                fishbowl[now.r][now.c] = now.sharkNo;
                continue;
            }

            //찐으로 1칸 가지고 2마리가 싸우는 경우
            else if (fishbowl[now.r][now.c] != now.sharkNo) {
                //num == 상대 상어
                int num = fishbowl[now.r][now.c] - 1;

                //죽일 대상 선택 후 죽이기
                if (sharks.get(num).size < now.size) {
                    //사망 처리하러 들어가서 -1작업을 해줄 예정
                    DeathCertificate(num + 1);
                    fishbowl[now.r][now.c] = now.sharkNo;
                }else{
                    DeathCertificate(now.sharkNo);
                }
            }
        }
    }

    public static int fishing(int kingpoi){
        //낚시왕이 현재 존재하는 열에서 아래로 행 탐색

        int result = 0;
        for (int j = 1; j < R + 1; j++) {
            int nowNum = fishbowl[j][kingpoi];
            //칸에 상어가 존재하지 않는 경우
            if(nowNum == 0) continue;

            //상어가 존재하는 경우
            result = sharks.get(nowNum - 1).size;

            //죽은 상어로 처리
            DeathCertificate(nowNum);
            //상어 잡았으면 낚시 중지
            break;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        fishbowl = new int [R + 1][C + 1];
        sharkNum = Integer.parseInt(st.nextToken());
        int fishking = 0;

        //아무것도 없는 0과 구분을 위하여 상어 번호는 1번부터 부여
        // => 따라서 상어 리스트 접근 시 -1 해줘야 됨 (0번인덱스부터 차례대로 접근되므로)

        for (int i = 1; i < sharkNum + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            sharks.add(new shark(r, c, speed, dir, size, i));
            fishbowl[r][c] = i; //상어의 번호 입력
        }
////////////////////////////////입력값 세팅 완료////////////////////////////////////////////////

//        System.out.println("초기 상태");
//        print();
        for (int kingX = 1; kingX < C + 1; kingX++) {
            //낚시
            fishking += fishing(kingX);
            //상어 이동
            move();
            //동족 포식
            cannibalism();

//            System.out.println("상어 이동 완료");
//            print();
        }
    System.out.println(fishking);
    }


    //상황 체크 함수들
    public static void sharkprint(){
        for (int i = 0; i < sharkNum; i++){
            shark now = sharks.get(i);
            System.out.printf("Num: %d, x: %d, y: %d, size: %d\n", now.sharkNo, now.r, now.c, now.size);
        }
    }
    public static void print() {
        System.out.println();
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                System.out.print(fishbowl[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
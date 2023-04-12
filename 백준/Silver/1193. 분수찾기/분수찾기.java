import java.util.Scanner;

public class Main {

    //우, 왼쪽 아래 대각선, 하, 오른쪽 위 대각선
    static int dx[] = {0, 1, 1, -1};
    static int dy[] = {1, -1, 0, 1};

    static int N;

    //static int map[][] = new [10000000][10000000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        move();
    }

    private static void move() {
        int tmp = 1, i = 0, x = 1, y = 1;
        boolean dirFlag = false;

        while(tmp != N){
            x += dx[i];
            y += dy[i];
            if(i == 0 || i == 2){
                i++;
            }else if(x <= 1 || y <= 1){
                if(i == 3) i = 0;
                else i++;
            }
            tmp++;
        }
        System.out.println(x + "/" + y);

    }


}
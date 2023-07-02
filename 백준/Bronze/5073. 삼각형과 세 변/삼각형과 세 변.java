import java.util.Scanner;

public class Main {
    static int a, b, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            //종료 코드
            if(a + b + c == 0) break;

            //삼각형 불가능
            int max = Math.max(a, Math.max(b, c));
            if((max == c && max >= a + b) || (max == b && max >= a + c) || (max == a && max >= c + b)) System.out.println("Invalid");

            //삼각형의 타입 선택
            else if(a == b && b == c) System.out.println("Equilateral");
            else if(a == b || b == c || c == a) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}
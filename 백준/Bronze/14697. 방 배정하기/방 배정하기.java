import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] rooms = new int [3];
    static int student, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        student = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            if (student % rooms[i] == 0) {
                result = 1;
                break;
            }
        }
        if(result == 0){
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if(select2rooms(rooms[i], rooms[j])) break;
                }
                if(result == 1) break;
            }
        }
        if(result == 0){
            for (int i = 1; i < student / rooms[0] + 1; i++) {
                for (int j = 1; j < student / rooms[1] + 1; j++) {
                    for (int k = 1; k < rooms[2]; k++) {
                        if(rooms[0] * i + rooms[1] * j + rooms[2] * k == student){
                            result = 1;
                            break;
                        }
                    }
                    if(result == 1) break;
                }
                if(result == 1) break;
            }
        }
        System.out.println(result);
    }

    public static boolean select2rooms(int room1, int room2){
        for (int i = 1; i < student / room1 + 1; i++) {
            for (int j = 1; j < student / room2 + 1; j++) {
                if(room1 * i + room2 * j == student){
                    result = 1;
                    return true;
                }
            }
        }
        return false;
    }
}
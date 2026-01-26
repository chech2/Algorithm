import java.io.*;
import java.util.*;

public class Main {

    static int n, answer;
    static char game;
    static Set<String> player;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        preSetting();

        if(game == 'Y'){
            answer = player.size();
        } else if(game == 'F'){
            answer = player.size() / 2;
        } else {
            answer = player.size() / 3;
        }

        System.out.println(answer);
    }

    private static void preSetting() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        game = st.nextToken().charAt(0);

        player = new HashSet<>();

        for (int i = 0; i < n; i++) {
            player.add(br.readLine());
        }
    }
}

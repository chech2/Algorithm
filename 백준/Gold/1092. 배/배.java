import java.io.*;
import java.util.*;
public class Main {

    static int n, m;
    static int[] crain;
    static ArrayList<Integer> box;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        if (input()) System.out.println(searh());
        else System.out.println(-1);

    }

    public static int searh(){
        int boxidx, crainidx;
        int sum = 0;

        while(box.size() != 0) {
            crainidx = n - 1;
            boxidx = 0;

            while(0 <= crainidx) {
                if(boxidx == box.size()) break;
                else if (box.get(boxidx) <= crain[crainidx]) {
                    box.remove(boxidx);
                    crainidx--;
                }
                else boxidx++;
            }

            sum++;
        }
        return sum;
    }
    public static boolean input() throws Exception{
        n = Integer.parseInt(br.readLine());
        crain = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) crain[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) box.add(Integer.parseInt(st.nextToken()));

        Collections.sort(box);
        Collections.reverse(box);
        Arrays.sort(crain);

        if(crain[n - 1] < box.get(0)) return false;
        else return true;
    }

}
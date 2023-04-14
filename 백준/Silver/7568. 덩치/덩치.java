import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int result[];
    static ArrayList<person> people = new ArrayList<>();

    static class person{
        int idx, cm, kg;

        person(int idx, int cm, int kg){
            this.idx = idx;
            this.cm = cm;
            this.kg = kg;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        result = new int[N];
        Arrays.fill(result, 1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cm = Integer.parseInt(st.nextToken());
            int kg = Integer.parseInt(st.nextToken());

            people.add(new person(i, cm, kg));
        }
        for (int i = 0; i < N; i++) {
            person p = people.get(i);
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                
                person other = people.get(j);
                if(cmCheck(p, other) && kgCheck(p, other)){
                    result[p.idx]++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static boolean cmCheck(person p, person other) {
        if(other.cm > p.cm) return true;
        return false;
    }
    private static boolean kgCheck(person p, person other) {
        if(other.kg > p.kg) return true;
        return false;
    }
}
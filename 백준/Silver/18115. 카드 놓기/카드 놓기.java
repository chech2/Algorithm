import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

        Deque<String> A = new LinkedList<>(); //수열
        Deque<String> set = new LinkedList<>(); //원래 카드 
        Deque<String> result = new LinkedList<>(); //카드 연습 결과

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        
        int N =Integer.parseInt(br.readLine());
        st =new StringTokenizer (br.readLine());
        for (int i = 1; i < N + 1; i++) {
            A.addFirst(st.nextToken());
            result.add((String.valueOf(i)));
        }
        String now;
        for (int i = 0; i < N; i++) {
            now = A.removeFirst();
        	if(now.equals("1")) {
                set.addFirst(result.removeFirst());
            }
            else if(now.equals("2")) {
            	String tmp =  set.remove();
                set.addFirst(result.removeFirst());
                set.addFirst(tmp);
            }else {
            	set.addLast(result.removeFirst());
            }
        }
        for (String string : set) {
        	sb.append(string + " ");
		}
        System.out.println(sb);
	}

}





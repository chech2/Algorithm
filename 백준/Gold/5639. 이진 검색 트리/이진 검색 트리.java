import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static class Node{
		//1개의 노드는 본인의 값과 왼쪽 자식, 오른쪽 자식을 가진다.
		//값이 작으면 오른쪽, 크면 왼쪽이 된다
		int num;
		Node right;
		Node left;		
		
		public Node(int num) {
			this.num = num;
		}
		
		public void add(int t) {
			if(t < num) {
				if(left == null) left = new Node(t);
				else left.add(t);
			}else {
				if(right == null) right = new Node(t);
				else right.add(t);
			}
		
		}
	}
	
	private static void PostOrder(Node node) {
		if(node == null) return;
		
		//오른쪽부터 보기
		PostOrder(node.left);
		PostOrder(node.right);
		System.out.println(node.num);
	}	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node tree = new Node(Integer.parseInt(br.readLine()));
		String tmp;
		while(true) {
			tmp = br.readLine();
			if(tmp == null || tmp.equals("")) break;
				tree.add(Integer.parseInt(tmp));
		}
	
		PostOrder(tree); 
	}

}
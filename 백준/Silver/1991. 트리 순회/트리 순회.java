import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N;
    static StringBuilder[] sb = new StringBuilder[3];
    public static class node{
        char now;
        node left, right;

        node(char now){
            this.now = now;
        }
    }

    public static class TREE{
        node root;

        public void createNode(char now, char left, char right){
            if(root == null) {
                root = new node(now);
                if(left != '.') root.left = new node(left);
                if(right != '.') root.right = new node(right);

            }else {
                searchNode(root, now, left, right);
            }
        }
        public void searchNode(node node, char now, char left, char right){
            if(node == null) return;
            // 찾고자 하는 노드가 현재 노드가 맞는 경우
            if (node.now == now) {
                if (left != '.') node.left = new node(left);     // 왼쪽 자식이 존재하는 경우
                if (right != '.') node.right = new node(right);  // 오른쪽 자식이 존재하는 경우
            }
            // 찾고자 하는 노드가 현재 노드가 아닌 경우
            else {
                searchNode(node.left, now, left, right);  // 왼쪽 재귀 탐색
                searchNode(node.right, now, left, right);  // 오른쪽 재귀 탐색
            }
        }
        public static void preorder(node node){
            if(node != null) {
                sb[0].append(node.now);
                if (node.left != null) preorder(node.left);
                if (node.right != null) preorder(node.right);
            }
        }
        public static void inorder(node node){
            if(node != null) {
                if (node.left != null) inorder(node.left);
                sb[1].append(node.now);
                if (node.right != null) inorder(node.right);
            }
        }
        public static void postorder(node node){
            if(node != null) {
                if (node.left != null) postorder(node.left);
                if (node.right != null) postorder(node.right);
                sb[2].append(node.now);

            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        TREE tree = new TREE();
        for (int i = 0; i < 3; i++) sb[i] = new StringBuilder();

        // 순서대로 각 인덱스가 A ~ N개의 노드를 의미함 (A == 1)
        char[] input;
        for (int i = 1; i < N; i++) {
            input = br.readLine().toCharArray();
            tree.createNode(input[0], input[2], input[4]);
        }
        tree.preorder(tree.root);
        tree.inorder(tree.root);
        tree.postorder(tree.root);

        System.out.println(sb[0]);
        System.out.println(sb[1]);
        System.out.println(sb[2]);
    }
}
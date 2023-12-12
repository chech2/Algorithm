import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<node>[] graph;
    static boolean[] visited;
    static int rootNode, totalNode, gigaNode;
    static long trunkLen, branchLen;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        totalNode = Integer.parseInt(st.nextToken());
        rootNode = Integer.parseInt(st.nextToken());

        graph = new ArrayList[totalNode + 1];
        visited = new boolean[totalNode + 1];

        for (int i = 0; i < totalNode + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int  node1, node2, value;
        for (int i = 0; i < totalNode - 1; i++) {
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            graph[node1].add(new node(node2, value));
            graph[node2].add(new node(node1, value));
        }

        //기가노드 찾기
        findGigaNode(rootNode);

        //기둥의 길이 구하기
        Arrays.fill(visited, false);
        trunkDfs(rootNode, 0);


//        Arrays.fill(visited, false);
        if(1 < graph[gigaNode].size())
            branchDfs(gigaNode, 0);

        System.out.println(trunkLen + " " + branchLen);
    }

    //기가노드 찾기
    static void findGigaNode(int start){
        visited[start] = true;
        int childcnt = 0;

        for (int i = 0; i < graph[start].size(); i++) {
            node next = graph[start].get(i);

            if(visited[next.number]) continue;
            childcnt++;
            if(1 < childcnt){
                gigaNode = start;
                return;
            }
            findGigaNode(next.number);
        }
//        visited[start] = false;
        if(gigaNode == 0) {
            gigaNode = start;
        }
    }

    //기둥 구하기
    static void trunkDfs(int start, long trunk){
        visited[start] = true;
        if(start == gigaNode){
            trunkLen = trunk;
            return;
        }
        for (int i = 0; i < graph[start].size(); i++) {
            node next = graph[start].get(i);

            if(visited[next.number]) continue;
            trunkDfs(next.number, trunk + next.value);
        }
//        visited[start] = false;
    }

    //가장 긴 가지 길이 구하기
    static void branchDfs(int start, long branch){
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            node next = graph[start].get(i);

            if(visited[next.number]) continue;
            branchDfs(next.number, branch + next.value);

        }
        branchLen = Math.max(branchLen, branch);
//        visited[start] = false;
    }


    static class node{
        //value: 간선 간의 가중치, number: 현 노드의 번호
        int value, number;
        node(int number, int value){
            this.number = number;
            this.value = value;
        }
    }
}
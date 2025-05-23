import java.util.*;

class Solution {
    int n;
    List<Integer>[] graph;
    boolean[] visited;
    int[] d;
    public int solution(int n, int[][] edge) {
        preSetting(n, edge);
        int answer = bfs();
        
        return answer;
    }
    
    int bfs(){
        PriorityQueue<node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        q.add(new node(1, 1));
        visited[1] = true;

        
        int next, answer;
        node now;
        answer = 0;
        while(!q.isEmpty()){
            now = q.poll();
            
            answer = Math.max(answer, now.d);
            d[now.d] += 1;
            for(int i = 0; i < graph[now.n].size(); i++){
                next = graph[now.n].get(i);
                if(visited[next]) continue;

                visited[next] = true;
                q.add(new node(next, now.d + 1));
            }
        }
        return d[answer];
    }
    
    void preSetting(int n, int[][] edge){
        this.n = n;
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        d = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();
        
        int a, b;
        for(int i = 0; i < edge.length; i++){
            a = edge[i][0];
            b = edge[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
    }
    
    class node{
        int n, d;
        
        node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
}
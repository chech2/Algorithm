import java.util.*;

class Solution {
    
    int root, n;
    ArrayList<Integer>[] graph;
    int[][] inOut = new int[1000000][2];
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        n = findEdgeInfo(edges);
        root = findRoot();        
        graph = makeGraph(edges);
        
        for(int i = 0; i < graph[root].size(); i++){
            answer[search(graph[root].get(i))]++;
        }
        
        answer[0] = root;
        return answer;
    }
    
    int search(Integer node){
        inOut[node][1]--;
        if(inOut[node][0] == 0 && inOut[node][1] == 0) return 2;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        visited[node] = true;
        q.add(node);
        
        int next, now;
        while(!q.isEmpty()){
            now = q.poll();
                        
            // 막대 그래프: 나가는 간선 ( inOut[now][0] ) : 0, 들어가는 간선 ( inOut[now][1] ) : 1
            if(inOut[now][0] == 0 && inOut[now][1] == 1) return 2;
            // 8자 그래프 : 나가는 간선 ( inOut[now][0] ) : 2, 들어가는 간선 ( inOut[now][1] ) : 2
            if(inOut[now][0] == 2 && inOut[now][1] == 2) return 3;
            
            for(int i = 0; i < graph[now].size(); i++){
                next = graph[now].get(i);
                if(now == next) return 1;
                if(root == next || visited[next]) continue;
                
                visited[next] = true;
                q.add(next);
                
            }
        }
        return 1;
    }
    
    int findRoot(){
        for(int i = 1; i < n + 1; i++) {
            if(inOut[i][0] - inOut[i][1] > 1) {
                return i;
            } 
        }
        return 0;
    }
    
    int findEdgeInfo(int[][] edges){
        int s, e, n = 0;
        for(int i = 0; i < edges.length; i++){
            s = edges[i][0];
            e = edges[i][1];
            
            inOut[s][0]++;
            inOut[e][1]++;
            n = Math.max(n, Math.max(s, e));
        }
        
        return n;
    }
    
    ArrayList[] makeGraph(int[][] edges){
        ArrayList[] makingGraph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            makingGraph[i] = new ArrayList<Integer>();
        }
        
        int s, e;
        for(int i = 0; i < edges.length; i++){
            s = edges[i][0];
            e = edges[i][1];
            
            makingGraph[s].add(e);
        }
        
        return makingGraph;
    }
}
import java.util.*;

class Solution {
    List<Integer>[] tree;
    boolean[] visited;
    int[] d;
    public int solution(int n, int[][] edge) {
        preSetting(n, edge);
        int answer = bfs();
        
        return answer;
    }
    
    int bfs(){
        int ans, max;
        Queue<Integer> q = new ArrayDeque();
        q.add(1);
        visited[1] = true;
        
        int next, now;
        while(!q.isEmpty()){
            now = q.poll();
            
            for(int i = 0; i < tree[now].size(); i++){
                next = tree[now].get(i);
                
                if(visited[next]) continue;
                visited[next] = true;
                d[next] = d[now] + 1;

                q.add(next);
            }
        }
        
        Arrays.sort(d);
        ans = 0;
        max = d[d.length - 1];
        for(int i = d.length - 1; 0 < i; i--){
            
            if(d[i] < max) break;
            ans++;
        }
        return ans;
    }
    
    void preSetting(int n, int[][] edge){
        tree = new ArrayList[n + 1];
        d = new int[n + 1]; 
        visited = new boolean[n + 1];
        visited[1] = true;
        
        for(int i = 0; i < n + 1; i++) tree[i] = new ArrayList<>();
        
        int a, b;
        for(int i = 0; i < edge.length; i++){
            a = edge[i][0];
            b = edge[i][1];
            
            tree[a].add(b);
            tree[b].add(a);            
        }
    }
}
import java.util.*;

class Solution {
    int[] d;
    PriorityQueue<shelter> q = new PriorityQueue<>((shelter a, shelter b) -> a.t - b.t);
    Set<Integer> gates, summits;
    List<shelter>[] graph;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        pre_setting(n, paths, gates, summits);
        return dijkstra(summits);
    }
    
    void pre_setting(int n, int[][] paths, int[] gates, int[] summits){
        graph = new ArrayList[n + 1];
        d = new int[n + 1];
        this.gates = new HashSet<>();
        this.summits = new HashSet<>();
        Arrays.sort(summits);
        
        Arrays.fill(d, Integer.MAX_VALUE);
        for(int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < summits.length; i++) this.summits.add(summits[i]);
        for(int i = 0; i < gates.length; i++){
            this.gates.add(gates[i]);
            q.add(new shelter(gates[i], 0));
            d[gates[i]] = 0;
        }
        
        int s, e, t;
        for(int i = 0; i < paths.length; i++){
            s = paths[i][0];
            e = paths[i][1];
            t = paths[i][2];

            // s가 출입구인 경우 s만, e가 산봉우리인 경우 s만
            // e가 출입구인 경우 e만, s가 산봉우리인 경우 e만
            if(isGate(s) || isSummit(e)) graph[s].add(new shelter(e, t));
            else if(isGate(e) || isSummit(s)) graph[e].add(new shelter(s, t));
            else {    
                graph[s].add(new shelter(e, t));
                graph[e].add(new shelter(s, t));
            }
        }
    }
    
    int[] dijkstra(int[] summits){
        shelter now, next;
        int dis;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            // now.t: 현재 가중치, d[now.n]: 이동할 위치의 가중치
            // 만약 continue를 하지 않을 경우, 최소 갱신이 되지 않음
            // 왜? 큐에는 이전에 들어온 값이 남아있을 수 있음, 
            // 그래서 최소 갱신이 된 값이 있을 경우 다시 연산하지 않도록 제외해야 됨
            if(d[now.n] < now.t) continue;

            for(int i = 0; i < graph[now.n].size(); i++){
                next = graph[now.n].get(i);
                
                // d[now.n]: 지금까지 시간 중 가장 긴 시간
                // next.t: 가장 긴 사간이 될 수도 있는 후보
                dis = Math.max(d[now.n], next.t);
                if(dis < d[next.n]){
                    d[next.n] = dis;
                    q.add(new shelter(next.n, dis));
                }
            }
        }
        
        int idx, val;
        idx = 0; 
        val = Integer.MAX_VALUE;
        for(int i = 0; i < summits.length; i++){
        
            if(d[summits[i]] < val){
                idx = summits[i];
                val = d[summits[i]];
            }
        }
        
        return new int[]{idx, val};
    }
    
    boolean isGate(int node){
        if(gates.contains(node)) return true;
        return false;
    }
    
    boolean isSummit(int node){
        if(summits.contains(node)) return true;
        return false;
    }
    
    class shelter{
        int n, t;
        
        shelter(int n, int t){
            this.n = n;
            this.t = t;
        }
    }
}
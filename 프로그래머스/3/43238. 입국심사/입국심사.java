import java.util.*;

class Solution {
    int n, size;
    int[] times;

    public long solution(int n, int[] times) {
        preSetting(n, times);
        
        return simsa();
    }
    
    long simsa(){
       long s, m, e;
       s = 0;
       e = Long.MAX_VALUE;

       while(s <= e){
           m = (s + e) / 2;

           if(isT(m)) e = m - 1;
           else s = m + 1; 
       }
       return s;
    }
    
    boolean isT(long t){
        long p = 0;
        
        for(int i = 0; i < size; i++){
            p += t / times[i];
            
            if(n <= p) break;
            
        }
        if(n <= p) return true;
        return false;
    }
    
    class node {
        int m;
        long t;
        
        node(int m, long t){
            this.m = m;
            this.t = t;
        }
    }
    
    void preSetting(int n, int[] times){
        this.n = n;
        this.times = times;
        this.size = times.length;
        Arrays.sort(this.times);
    }
}
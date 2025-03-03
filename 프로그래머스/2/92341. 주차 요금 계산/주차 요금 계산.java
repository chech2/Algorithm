import java.util.*;

class Solution {
    Map<Integer, parking> sortedRecords;
    Map<Integer, parking> records = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        setRecords(records);
        calculateFee(fees);
        
        sortedRecords = new TreeMap<>(this.records);
        int[] answer = new int[this.records.size()];
        
        int idx = 0;
        for(Map.Entry<Integer, parking> entry : sortedRecords.entrySet()){
           answer[idx++] = entry.getValue().f;
        }
        
        return answer;
    }
    
     void calculateFee(int[] fees) {
        int sF, sT, aT, aF;
        sT = fees[0];
        sF = fees[1];
        aT = fees[2];
        aF = fees[3];
         
        records.forEach((k, v) -> {
            int fee = sF;
            
            if(0 <= v.m) v.forceDeparture();
            if(0 < v.duringT - sT) {
                v.duringT -= sT;
                fee += v.duringT / aT * aF;
                if(v.duringT % aT != 0) fee += aF;
            }
            v.setF(fee);
        });     
    }
    
    void setRecords(String[] r){
        int num;
        String[] record;
        
        for(int i = 0; i < r.length; i++){
            record = r[i].split(" ");
            num = Integer.parseInt(record[1]);
            
            if(records.containsKey(num)) records.get(num).addRecord(record);
            else records.put(num, new parking(record));
        }
    }
}

class parking{
    int deadline = 1439;
    
    int duringT, m, n, f;

    parking(String[] record){
        this.n = Integer.parseInt(record[1]);
        this.m = setM(record[0]);
        duringT = 0;
    }
    
    void addRecord(String[] record){
        int outM = setM(record[0]);
        
        if(record[2].equals("IN")){
            this.m = outM;
            
        }else{
            duringT += (outM - m);
            this.m = -1;
        }
    }
    
    void forceDeparture(){
        duringT += (deadline - m);
    }
    
    void setF(int f){
        this.f = f;
    };

    private int setM(String t){
        String[] time = t.split(":");
    
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}   
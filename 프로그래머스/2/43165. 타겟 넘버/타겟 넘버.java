class Solution {
    int target, ans;
    int[] numbers;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        int answer = 0;
        recur(0, 0);
        return ans;
    }
    
    void recur(int cnt, int num){
        if(cnt == numbers.length){
            if(num == target) ans++;
            return;
        }
        recur(cnt + 1, num + numbers[cnt]);
        recur(cnt + 1, num - numbers[cnt]);

    }
}
class Solution {
    public int solution(int[] common) {
         int answer = 0;
        int a = common[0];
        int b = common[1];
        int c = common[2];

        if(2 * b == a + c) //등차
        {
            answer = a +  (b - a) * common.length; 
        }else{
        	answer = a * (int)(Math.pow((b / a), common.length));
        }
        
        return answer;
    }
}
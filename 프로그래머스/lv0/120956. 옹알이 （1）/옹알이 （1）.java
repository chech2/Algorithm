class Solution {
    public int solution(String[] babbling) {
		String [] meosseuk = { "aya", "ye", "woo", "ma"};
        int answer = 0;
        boolean flag;
        
        for (int i = 0; i < babbling.length; i++) {
        	flag = true;
        	for (int j = 0; j < 4; j++) {
				if(babbling[i].contains(meosseuk[j])) {
					babbling[i]=babbling[i].replace(meosseuk[j], "!"); // babbling[i].replace(...)을 통해 babbling[i]가 바뀌는 것이 아니라 변경된 다른 객체가 출력되어지는 것
				}
			}
        	for (int j = 0; j < babbling[i].length(); j++) {
				if(!babbling[i].subSequence(j, j+1).equals("!")) {
					flag = false;
					break;	
				}
        	}
        	if(flag)
        		answer++;
		}
        return answer;
	}
}

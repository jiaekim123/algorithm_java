package nextbignum;

class Solution {
    public int solution(int n) {
        int answer = 0;
        char[] binaryNum = Integer.toBinaryString(n).toCharArray();
        int count = countOneInBinaryNum(binaryNum);
        
        for (int i = 1;; i++) {
        	int newNumCount = countOneInBinaryNum(Integer.toBinaryString(n+i).toCharArray());
        	if (newNumCount == count) {
        		answer = n + i;
        		break;
        	}
        }
        
        return answer;
    }
    
    private int countOneInBinaryNum(char[] binaryNum) {
    	int count = 0;
        for (char c : binaryNum) {
        	if (c == '1') count++;
        }
        return count;
    }
}
public class NextBigNum {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(15));
	}
}

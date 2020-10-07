package sort.biggest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // 1. string array에 int[] 넣기 
        List<String> numList = new ArrayList<String>();
        for(int num : numbers) {
        	numList.add(String.valueOf(num));
        }
        
        // 2. 내림차순 정리하기
        Collections.sort(numList, new Descending());
        
        // 3. 중복 숫자 제거하기
        for (String strNum : numList) {
        	answer += strNum;
        }
        
        // 4. 만약 앞자리가 00일 경우 0제거
        while ((answer.startsWith("0") && (answer.length()!=1))) {
        	answer = answer.substring(1);
        }
        
        return answer;
    }
}

class Descending implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return (o2+o1).compareTo(o1+o2);
	}
	
}

public class biggest {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(new int [] {6,10,2}));
		System.out.println(solution.solution(new int [] {0,0,0}));

	}

}

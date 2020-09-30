package hash.hashmap2;

import java.util.HashSet;
import java.util.Set;

/**
 * Programmers - 전화번호 목록 (해시) 
 * 해시 카테고리지만 해시로 풀지 않는 문제. String의 startWith으로 해결할 것.
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[i].startsWith(phone_book[j]) || phone_book[j].startsWith(phone_book[i]))
					return false;
			}
		}
		return answer;
    }
}

class Telephone {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(solution.solution(new String[] {"123","456","789"}));
        System.out.println(solution.solution(new String[] {"12", "123", "1235", "567", "88"}));
    }
}
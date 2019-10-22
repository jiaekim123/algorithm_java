package programmers.hash;

import java.util.Set;

/**
 * Programmers - 전화번호 목록 (해시)
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */

 class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phoneSet = new HashSet<String>();
        for(String phone_number : phone_book){
            if (!phoneSet.contains(phone_number)){
                phoneSet.add(phone_number);
            } else {
                return false;
            }
        }
        return true;
    }
}

public class Telephone {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"119", "97674223", "1195524421"}));
    }
}
package hash.spy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 1. 해시 값을 채워 넣는다 HashMap<String(종류), Integer(개수)>
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String[] clothe : clothes) {
        	map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1); // clothe [1] : 종류
        }
        
        // 2. 해시 값에서 종류 별 의류 갯수를 통해 answer값을 계산하여 채운다.
        // 계산  A종류가 3개, B종류가 2개 있을 경우 -> A에서 3C1(입거나) + 1 (안입거나), B에서 2C1선택(입거나) + 1(안입거나) - 아얘 안입거나 
        Iterator<Integer> iter = map.values().iterator();
        while (iter.hasNext()) {
        	answer = answer * (iter.next() + 1);
        }
        
        return answer - 1;
    }
}

public class SpyHash {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(new String[][] { { "yellow_hat", "headgear" },
				{ "blue_sunglasses", "eyewear" }, { "green_turban", "headgear" } }));
		System.out.println(solution.solution(new String[][] { { "yellow_hat", "headgear" },
			{ "blue_sunglasses", "headgear" }, { "green_turban", "headgear" } }));

	}
}

package devmatching.test2;

import java.util.ArrayList;
import java.util.List;

class Solution {
	List<int[][]> orderGroupList; 
    public int solution(int n, int[][] groups) {
        int answer = 1001;
        boolean[] isLight = new boolean[n];
        orderGroupList = new ArrayList<int[][]>();
		
        // groups조합의 순서가 있는 경우의 수를 구한다.
        int[][] orderGroup = new int[groups.length][2];
		boolean[] visited = new boolean[groups.length];
		perm(groups, orderGroup, visited, 0);
		
		// 조합 중 최소 count값을 찾는다.
		for (int[][] group : orderGroupList) {
			int count = countAllOn(group, isLight);
			if (answer > count) {
				answer = count;
			}
		}
		
        return answer;
    }
    private boolean isLightAllOn(boolean[] isLight) {
    	for (boolean light : isLight) {
    		if (light == false) {
    			return false;
    		}
    	}
    	return true;
    }
   
    private int countAllOn(int[][] groups, boolean[] isLight) {
    	int result = 0;
    	for (int i = 0; i < groups.length; i++) {
			for (int j = groups[i][0]; j < groups[i][1]; j++) {
				isLight[j] = true;
			}
			result++;
			if (isLightAllOn(isLight)) {
				return result;
			}
		}
    	return result;
    }
    private void perm(int[][] groups,  int[][] orderGroup, boolean[] visited, int depth) {
        if (depth == groups.length) {
        	orderGroupList.add(orderGroup);
        	return;
        }
     
        for (int i=0; i<groups.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                orderGroup[depth][0] = groups[i][0];
                orderGroup[depth][1] = groups[i][1];
                perm(groups, orderGroup, visited, depth + 1);       
                orderGroup[depth][0] = 0;
                orderGroup[depth][1] = 0;
                visited[i] = false;
            }
        }
    }
}

public class Test2 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(10, new int[][]{{1,5}, {2,7}, {4,8}, {3,6}}));
		System.out.println(solution.solution(10, new int[][]{{6,7}, {1,4}, {2,4}}));
		System.out.println(solution.solution(10, new int[][]{{1,50}, {1,100}, {51,100}}));

	}
}

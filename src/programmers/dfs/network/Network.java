package dfs.network;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        // 모든 노드에 dfs로 방문, 만약  visited가 false면 (방문한적이 없을 경우) answer++ 
        for(int i = 0; i<computers.length; i++) {
        	if (visited[i] == false) answer++; 
        	dfs(computers, visited, i);        	
        }
        
        return answer;
    }
    
    private void dfs (int[][] computers, boolean[] visited, int node) {
    	visited[node] = true;
    	
    	// 노드와 연결된 노드에 방문
    	for(int i = 0; i<computers.length; i++) {
    		if(visited[i] == false && computers[node][i] == 1) {
    			dfs(computers, visited, i);
    		}
    	}
    }
}

public class Network {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(3, new int[][] {{1,1,0}, {1,1,0}, {0,0,1}}));
		System.out.println(solution.solution(3, new int[][] {{1,1,0}, {1,1,1}, {0,1,1}}));
	}
}

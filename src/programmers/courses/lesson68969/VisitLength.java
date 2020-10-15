package courses.lesson68969;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[] dirsChar = dirs.toCharArray();
        int[][] visited = new int[dirsChar.length+1][dirsChar.length+1];
        
        int x = 5, y = 5;
        
        return answer;
    }
}

public class VisitLength {
	public static void main(String[] args) {
		System.out.println(new Solution().solution("ULURRDLLU"));
	}
}

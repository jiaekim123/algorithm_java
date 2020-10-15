package devmatching.test1;
import java.util.*;

class Solution {
    public String solution(String p, int n) {
        String answer = null;
        String timeUnit = p.split(" ")[0];
        String time = p.split(" ")[1];

        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        int sec = Integer.parseInt(time.split(":")[2]);
        
        sec += n;
        
        if (timeUnit.equals("PM")) hour += 12;
        
        if (sec >= 60) {
        	min += sec/60;
        	sec = sec%60;
        }
    	if (min >= 60) {
    		hour += min/60;
    		min = min%60;
    	}
    	
		if (hour >= 24) {
			hour = hour%24;
		}
        answer = String.format("%02d:%02d:%02d", hour, min, sec);
        return answer;
    }
}

public class Test1 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("PM 01:00:00", 10));
		System.out.println(solution.solution("PM 11:59:59", 1));
		System.out.println(solution.solution("PM 15:29:59", 10));
		System.out.println(solution.solution("PM 15:29:59", 100000));

	}
}

package courses.lesson68981;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String[] participant, String[] completion) {
        List<String> participantList = new ArrayList<String>(Arrays.asList(participant));
        
        for (String player : completion) {
            participantList.remove(participantList.indexOf(player));
        }
        
        return participantList.get(0);
    }
}

public class NotFinishedPlayer {
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
	}
}

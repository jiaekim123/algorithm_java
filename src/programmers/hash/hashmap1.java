package hash;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *  Programers - Hash
 *  완주하지 못한 선수
 */

 class Solution {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = new HashMap<String, Integer>();
        Map<String, Integer> participantMap = new HashMap<String, Integer>();
        String answer = null;        

        for(String player : completion){
        	if(completionMap.get(player)==null) {
            	completionMap.put(player, 1);
        	} else {
        		completionMap.put(player, completionMap.get(player)+1);
        	}
        }

        for(String player : participant){
        	if(participantMap.get(player)==null) {
        		participantMap.put(player, 1);
        	} else {
        		participantMap.put(player, participantMap.get(player)+1);
        	}
        }
        
        for(Entry<String, Integer> player: participantMap.entrySet()) {
        	if(completionMap.get(player.getKey())!=
        			participantMap.get(player.getKey())){
        		answer = player.getKey();
        		return answer;
        	}
        }
        return answer;

    }
    public static void main(String[] args) {
    	String[] participant = {"mislav", "stanko", "mislav", "ana"};
    	String[] completion = {"stanko", "ana", "mislav"};
    	System.out.print(solution(participant, completion));
	}
}
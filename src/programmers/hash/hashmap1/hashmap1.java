package hash.hashmap1;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *  Programers - Hash
 *  완주하지 못한 선수
 */

 class Solution {
 	private final static String failed_message = "FAILED";
	 public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> participantMap = new HashMap<String, Integer>();

        for(String player : participant){
        	if(participantMap.get(player)==null) {
        		participantMap.put(player, 1);
        	} else {
        		participantMap.replace(player, participantMap.get(player)+1);
        	}
        }

        for(String player : completion){
        	if(participantMap.get(player)==1) {
            	participantMap.remove(player);        		
        	} else {
        		participantMap.replace(player, participantMap.get(player)-1);
        	}
        }
        
        for(Entry<String, Integer> entry :participantMap.entrySet()) {
        	return entry.getKey();
        }
        
        return failed_message;
        

    }
    public static void main(String[] args) {
    	String[] participant = {"mislav", "mislav", "mislav", "ana"};
    	String[] completion = {"ana", "mislav", "mislav"};
    	System.out.print(solution(participant, completion));
	}
}
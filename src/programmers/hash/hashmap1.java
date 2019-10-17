import java.util.HashSet;
import java.util.Set;

/**
 *  Programers - Hash
 *  완주하지 못한 선수
 */

 class Solution {
    public static String solution(String[] participant, String[] completion) {
        Set<String> playerSet = new HashSet<String>();
        Set<String> participantSet = new HashSet<String>();
        String duplicationPlayer = null;
        String answer = null;        

        for(String player : completion){
            playerSet.add(player);
        }

        for(String player : participant){
        	if(!participantSet.contains(player)) {
        		participantSet.add(player);	
        	} else {
        		duplicationPlayer = player;
        	}
            if(!playerSet.contains(player)){
                answer = player;
            }
        }
        if(answer == null && duplicationPlayer !=null) {
        	return duplicationPlayer;
        } else {
        	System.out.println("wrong input");
        }
        return answer;
    }
    public static void main(String[] args) {
    	String[] participant = {"mislav", "stanko", "mislav", "ana"};
    	String[] completion = {"stanko", "ana", "mislav"};
    	System.out.print(solution(participant, completion));
	}
}
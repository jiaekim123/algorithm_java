import java.util.*;

// result is success but runtime is too long.
// you just calculate only max, min number. not solt.
public class Backjoon10818{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        int count = scanner.nextInt();
        List<Integer> numList = new ArrayList<Integer>();
            
        for(int i = 0 ; i <count ; i++){
            int number = scanner.nextInt();
            numList.add(number); 
        }
        Collections.sort(numList);
        System.out.println(numList.get(0)+" "+numList.get(numList.size()-1));
        scanner.close();
    }

}


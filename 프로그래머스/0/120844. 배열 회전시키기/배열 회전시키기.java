import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<numbers.length; i++) {
            dq.addLast(numbers[i]);
        }
        
        if (direction.equals("right")) {
            dq.addFirst(dq.removeLast());
        } else {
            dq.addLast(dq.removeFirst());
        }
        
        int[] answer = dq.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
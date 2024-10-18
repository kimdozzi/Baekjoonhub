import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Deque<Integer> stk = new LinkedList<>();
        for(int i=0; i<prices.length; i++) {
            while(!stk.isEmpty() && prices[stk.peekLast()] > prices[i]) {
                int idx = stk.pollLast();
                result[idx] = i - idx;
            }
            // 값을 넣는게 아니라 인덱스 값을 넣음.(해당 가격의 위치정보)
            stk.add(i);
        }
        
        while(!stk.isEmpty()) {
            int idx = stk.pollLast();
            result[idx] = prices.length - idx - 1;
        }
        return result;
    }
}   
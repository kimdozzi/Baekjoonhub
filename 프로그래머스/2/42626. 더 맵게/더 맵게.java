import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville) {
            pq.add(n);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            int n = pq.poll();
            int m = pq.poll();
            int sum = n + (m * 2);
            pq.add(sum);
            answer++;
        }
        return pq.peek() < K ? -1 : answer;
    }
}
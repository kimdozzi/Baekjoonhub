import java.util.*;
class Pair{ 
    int val;
    int idx;
    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    static Queue<Pair> q;
    public int solution(int[] priorities, int location) {
        int answer = 1;
        q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            q.add(new Pair(priorities[i], i));
        }
        while(!q.isEmpty()) {
            Pair current = q.poll();
            if (!search(current.val, current.idx)) {
                q.add(new Pair(current.val, current.idx));
                continue;
            }
            if (current.idx == location) {
                return answer;
            } else {
                answer++;
            }
        }
        
        return answer;
    }
    private static boolean search(int val, int idx) {
        Iterator<Pair> iter = q.iterator();
        while(iter.hasNext()) {
            Pair current = iter.next();
            // 자신이 아닌 수 중에 자기자신보다 큰 값이 존재한다면
            if (idx != current.idx && val < current.val) 
                return false;
        }
        return true;
    }
}








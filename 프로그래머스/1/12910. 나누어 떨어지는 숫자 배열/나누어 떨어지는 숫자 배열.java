import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % divisor == 0) list.add(arr[i]);
        }
        Collections.sort(list);
        int[] ans = list.stream().mapToInt(Integer::intValue).toArray();
        if (list.size() > 0) return ans;
        return new int[]{-1};
    }
}
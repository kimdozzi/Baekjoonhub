import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for(int i=0; i<num_list.length; i++) {
            if (i < n) {
                list2.add(num_list[i]);
            } else {
                list1.add(num_list[i]);
            }
        }
        List<Integer> list = new ArrayList<>(list1);
        list.addAll(list2);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
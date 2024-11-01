import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int number = stages.length;
        Map<Integer, Double> map = new HashMap<>();
        int[] vis = new int[N+1];
        double[] ans = new double[N+1];
         
        for(int i=0; i<stages.length; i++) {
            if (stages[i] > N) continue;
            vis[stages[i]]++;
        }
        
        for(int i=1; i<=N; i++) {
            if (vis[i] != 0) 
                ans[i] = ((double)vis[i] / number);
            else 
                ans[i] = 0;
            number -= vis[i];
            map.put(i, ans[i]);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2)-> map.get(o2).compareTo(map.get(o1)));
        
        List<Integer> res = new ArrayList<>();
        for (int key : keySet) {
            System.out.println(key + " " + map.get(key));
            res.add(key);
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
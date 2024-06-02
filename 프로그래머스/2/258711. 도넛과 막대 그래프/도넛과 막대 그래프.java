import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {};
        Map<Integer, int[]> nodeCnt = new HashMap<>();
        int[] ans = {0,0,0,0};

        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0];
            int b = edge[1];
            if (!nodeCnt.containsKey(a)) {
                nodeCnt.put(a, new int[]{0,0});
            }
            if (!nodeCnt.containsKey(b)) {
                nodeCnt.put(b, new int[]{0,0});
            }

            nodeCnt.get(a)[0]++;
            nodeCnt.get(b)[1]++;
        });

        int[] counts;
        for (int key : nodeCnt.keySet()) {
            counts = nodeCnt.get(key);

            // 들어오는 노드 0개, 나가는 노드 2개 (생성된 노드)
            if (counts[0] >= 2 && counts[1] == 0) {
                ans[0] = key;
            // 들어오는 정점 1개 이상, 나가는 노드 0개 (막대 그래프)
            } else if (counts[0] == 0 && counts[1] > 0) {
                ans[2]++;
            } else if (counts[0] == 2 && counts[1] >= 2) {
                ans[3]++;
            }
        }
        ans[1] = nodeCnt.get(ans[0])[0] - ans[2] - ans[3];

        for (int i=0; i< ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        return ans;
        
    }
}
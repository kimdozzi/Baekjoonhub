import java.util.*;

class Solution {
 static List<Info>[] A;
    static int[] intensity;
    static int[] infos;
    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        A = new List[n + 1];

        for (int i = 0; i <= n; i++) A[i] = new ArrayList<>();
        intensity = new int[n + 1];
        infos = new int[n + 1];

        for (int gate : gates) {
            infos[gate] = -1;
        }

        for (int summit : summits) {
            infos[summit] = -2;
        }

        Arrays.fill(intensity, Integer.MAX_VALUE);

        for (int i = 0; i < paths.length; i++) {
            int s = paths[i][0];
            int e = paths[i][1];
            int w = paths[i][2];

            if (infos[s] == -1 || infos[e] == -2) {
                A[s].add(new Info(e, w));
            } else if (infos[e] == -1 || infos[s] == -2) {
                A[e].add(new Info(s, w));
            } else {
                A[s].add(new Info(e, w));
                A[e].add(new Info(s, w));
            }
        }

        dijkstra();
        Arrays.sort(summits);

        int[] result = new int[]{0, Integer.MAX_VALUE};

        for (int summit : summits) {
            if (intensity[summit] < result[1]) {
                result[1] = Math.min(result[1], intensity[summit]);
                result[0] = summit;
            }
        }
        return result;
    }

    static void dijkstra() {
        Queue<Info> pq = new PriorityQueue<>(Comparator.comparing(o -> o.wei));

        for (int i = 0; i < infos.length; i++) {
            int info = infos[i];

            if (info == -1) {
                pq.offer(new Info(i, 0));
                intensity[i] = 0;
            }
        }

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (intensity[info.idx] < info.wei) continue;
            for (Info next : A[info.idx]) {
                if (intensity[next.idx] > Math.max(intensity[info.idx], next.wei)) {
                    intensity[next.idx] = Math.max(intensity[info.idx], next.wei);
                    pq.offer(next);
                }
            }
        }
    }

    static class Info {
        int idx, wei;

        public Info(int idx, int wei) {
            this.idx = idx;
            this.wei = wei;
        }
    }
}
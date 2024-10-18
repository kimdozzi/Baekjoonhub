import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // jobs 배열을 작업 요청 시간(jobs[i][0])을 기준으로 오름차순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 작업 소요 시간(jobs[i][1])을 기준으로 하는 최소 힙(우선순위 큐) 생성
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int total = 0;    // 모든 작업의 요청부터 종료까지 걸린 시간의 합
        int end = 0;      // 현재 작업이 끝나는 시간
        int jobsIdx = 0;  // jobs 배열의 현재 인덥스
        int count = 0;    // 처리 완료된 작업의 수
        
        // 모든 작업이 처리될 때까지 반복
        while (count < jobs.length) {
            // 현재 시간(end)에 처리할 수 있는 모든 작업을 우선순위 큐에 추가
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }
            
            if (pq.isEmpty()) {
                // 처리할 수 있는 작업이 없으면 다음 작업의 시작 시간으로 이동
                end = jobs[jobsIdx][0];
            } else {
                // 처리할 수 있는 작업 중 가장 소요 시간이 짧은 작업 선택
                int[] cur = pq.poll();
                // 현재 작업의 요청부터 종료까지 걸린 시간을 계산하여 total에 추가
                total += cur[1] + end - cur[0];
                // 현재 시간 업데이트
                end += cur[1];
                // 처리 완료된 작업 수 증가
                count++;
            }
        }
        
        // 평균 시간 계산 및 반환 (소수점 이하는 버림)
        return total / jobs.length;
    }
}
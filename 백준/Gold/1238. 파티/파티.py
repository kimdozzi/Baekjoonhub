import collections
import sys
from heapq import heappop, heappush
si = sys.stdin.readline
INF = float('inf') # 무한대 설정

n,m,x = map(int,si().split())
graph = [[] for _ in range(n+1)]

# 최단거리를 갱신할 배열


for _ in range(m) :
    u,v,w = map(int, si().split())
    # u에서 v로 갈때 드는 비용 w
    graph[u].append((v,w))

def dijkstra(start) :
    q = []
    heappush(q, (0, start))
    distance[start] = 0 # 시작점 초기화
    while q :
        # 가장 최단 거리인 노드까지의 비용, 현재 노드
        dist, now = heappop(q)
        if distance[now] != dist : continue
        for node in graph[now] :
            # cost = 현재 위치의 비용 + 이동할 노드의 비용
            cost = dist + node[1]
             # 현재 위치의 비용 + 이동할 노드의 비용 < 이동할 노드의 위치가 기존에 갖고 있던 비용
            if cost < distance[node[0]] :
                distance[node[0]] = cost
                heappush(q, (cost, node[0]))

distance = [INF] * (n + 1)
res = collections.defaultdict(int)
dijkstra(x)
for i in range(1,n+1) :
    if i == x : continue
    res[i] += distance[i]

for i in range(1,n+1) :
    if i == x : continue
    distance = [INF] * (n + 1)
    dijkstra(i)
    res[i] += distance[x]

print(max(res.values()))


import sys, heapq
si = sys.stdin.readline
dirs=[[0,1],[0,-1],[1,0],[-1,0]]
m,n=map(int,si().split())
graph=[list(map(int,list(si().rstrip()))) for _ in range(n)]
dist=[[float('inf')] * m for _ in range(n)]

def dijkstra() :
    q = []
    heapq.heappush(q, (0,0,0))
    dist[0][0] = 0

    while q :
        cost, r, c = heapq.heappop(q)

        if cost > dist[r][c] : continue

        for i in range(4) :
            nr = r + dirs[i][0]
            nc = c + dirs[i][1]
            if not (0<=nr<n and 0<=nc<m) : continue

            if cost + graph[nr][nc] < dist[nr][nc] :
                dist[nr][nc] = cost + graph[nr][nc]
                heapq.heappush(q, (dist[nr][nc],nr,nc))

dijkstra()

print(dist[n-1][m-1])
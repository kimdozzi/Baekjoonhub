import sys
si = sys.stdin.readline
n,m=map(int,si().split())
graph=[list(map(int, si().split())) for _ in range(n)]
services = [list(map(int, si().split())) for _ in range(m)]

def floyd(graph) :
    for k in range(n) :
        for i in range(n) :
            for j in range(n) :
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
floyd(graph)

for service in services :
    u,v,w = service
    if graph[u-1][v-1] <= w :
        print("Enjoy other party")
    else :
        print("Stay here")
import sys
sys.setrecursionlimit(10**6)
si = sys.stdin.readline


def dfs(start, flag) :
    global graph

    visited[start] = flag

    for i in graph[start] :
        if visited[i] == 0 :
            ans = dfs(i, -flag)
            if not ans :
                return False
        else :
            if visited[start] == visited[i] :
                return False
    return True

T = int(si())

for _ in range(T) :
    v, e = map(int,si().split())
    graph = [[] for _ in range(v+1)]
    visited = [0] * (v+1)
    for _ in range(e) :
        a,b=map(int,si().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(1,v+1) :
        if visited[i] == 0:
            result = dfs(i, 1)
            if not result:
                break
    print("YES") if result else print("NO")
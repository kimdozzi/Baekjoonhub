import sys
sys.setrecursionlimit(10**6)
si = sys.stdin.readline

n,m=map(int,si().split())
parent = [i for i in range(n)]

def find(x) :
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b) :
    a=find(a)
    b=find(b)
    if a==b:return -1

    if a>b :
        parent[b] = a
    else :
        parent[a] = b

for i in range(m) :
    a,b = map(int,si().split())
    res = union(a,b)
    if res == -1 :
        print(i+1)
        exit(0)

print(0)

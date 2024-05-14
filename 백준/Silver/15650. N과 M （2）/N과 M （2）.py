import sys,itertools
si = sys.stdin.readline
n,m=map(int,si().split())
arr = [i for i in range(1,n+1)]
for i in itertools.combinations(arr,m) :
    print(*i, sep=' ')
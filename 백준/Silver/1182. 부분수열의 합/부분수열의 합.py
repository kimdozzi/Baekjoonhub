import sys
import itertools
si = sys.stdin.readline

N,S=map(int,si().split())
arr=list(map(int,si().split()))
ans = 0

cnt = 1
while cnt :
    if cnt == N + 1: break
    for i in itertools.combinations(arr, cnt) :
        if sum(list(i)) == S :
            ans += 1
    cnt += 1

print(ans)


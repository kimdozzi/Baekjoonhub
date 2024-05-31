import sys
from collections import deque
si = sys.stdin.readline

k,n = map(int,si().split())
arr = [int(si()) for _ in range(k)]
lo, hi = 1, max(arr)

while lo <= hi :
    mid = (lo+hi)//2
    total = 0

    for i in range(len(arr)) :
        total += arr[i]//mid

    if total >= n :
        lo = mid+1
    else :
        hi = mid-1

print(hi)
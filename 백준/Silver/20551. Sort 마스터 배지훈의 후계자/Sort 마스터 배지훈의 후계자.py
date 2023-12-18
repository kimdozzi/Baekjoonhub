import bisect
import sys
si = sys.stdin.readline

n,m=map(int,si().split())
arr=[int(si()) for i in range(n)]
arr.sort()
def func(x) :
    global arr
    lo, hi = -1, len(arr)

    while lo+1 < hi :
        mid = (lo+hi) // 2

        if x > arr[mid] :
            lo = mid
        else :
            hi = mid

    print(hi)


for i in range(m) :
    x = int(si())

    ans = bisect.bisect_left(arr, x)
    if ans >= n :
        print(-1)
    elif arr[ans] == x :
        print(ans)
    else :
        print(-1)

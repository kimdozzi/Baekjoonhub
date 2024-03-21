import sys
si = sys.stdin.readline

n,m=map(int,si().split())
arr=list(map(int,si().split()))
lo,hi=0,max(arr)

def check(mid) :
    cnt = 0
    for i in range(len(arr)) :
        if arr[i] > mid :
            cnt+=arr[i]-mid
    return cnt >= m

while lo+1<hi :

    mid = (lo+hi)//2

    if check(mid):
        lo = mid
    else :
        hi = mid

print(lo)
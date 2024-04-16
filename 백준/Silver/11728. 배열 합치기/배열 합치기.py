import sys
si = sys.stdin.readline

a,b=map(int,si().split())
lst=list(map(int,si().split()))
arr=list(map(int,si().split()))
ans=[]


lo1, lo2 = 0, 0
while len(lst) > lo1 and len(arr) > lo2 :
    if lst[lo1] > arr[lo2] :
        ans.append(arr[lo2])
        lo2 += 1
    else :
        ans.append(lst[lo1])
        lo1 += 1

if lo1 >= len(lst) :
    while len(arr) > lo2 :
        ans.append(arr[lo2])
        lo2 += 1

elif lo2 >= len(arr) :
    while len(lst) > lo1 :
        ans.append(lst[lo1])
        lo1 += 1

print(*ans,sep= ' ')
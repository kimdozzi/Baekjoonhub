import math
import sys
si = sys.stdin.readline
n=int(si())
for _ in range(n) :
    arr=list(map(int,si().split()))
    x = sum(arr[1:]) / arr[0]
    res=[]
    for i in range(1,len(arr)) :
        if arr[i] > x :
          res.append(arr[i])

    print(f"{len(res)/arr[0]*100:.3f}%")

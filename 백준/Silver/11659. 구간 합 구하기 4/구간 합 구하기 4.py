import sys
si = sys.stdin.readline

n,m=map(int,si().split())
arr=list(map(int,si().split()))
prefix_sum=[0] * (len(arr)+1)
for i in range(len(arr)) :
    prefix_sum[i+1] = prefix_sum[i] + arr[i]

for _ in range(m):
    start,end=map(int,si().split())
    print(prefix_sum[end]-prefix_sum[start-1])



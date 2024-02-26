import sys
si = sys.stdin.readline
n=int(si())
a=list(map(int,si().split()))
b=list(map(int,si().split()))
a.sort()
b.sort(reverse=True)
res=[]
for i in range(len(a)) :
    res.append(a[i]*b[i])
print(sum(res))
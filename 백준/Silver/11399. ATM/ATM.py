import sys
si = sys.stdin.readline

n = int(si())
arr = list(map(int, si().split()))
arr.sort()
ans = 0
for i in range(1,len(arr)+1) :
    ans += sum(arr[:i])
print(ans)
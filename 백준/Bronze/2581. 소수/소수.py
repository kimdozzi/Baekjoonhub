import sys
si = sys.stdin.readline

n=int(si())
m=int(si())
arr = []

def is_prime(x) :
    for i in range(2, x) :
        if x % i == 0 :
            return False
    return True

for i in range(n, m+1) :
    if i == 1 : continue
    if is_prime(i) :
        arr.append(i)

if not arr :
    print(-1)
else :
    print(sum(arr))
    print(arr[0])

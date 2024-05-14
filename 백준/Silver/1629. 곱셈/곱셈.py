a,b,c = map(int,input().split())

def power(a,n) :
    global c

    if n == 0 :
        return 1

    x = power(a,n//2)

    if n % 2 == 0 :
        return (x * x) % c
    else:
        return (x * x * a) % c


ans = power(a,b)
print(ans)
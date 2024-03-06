import sys
si = sys.stdin.readline


def main() :
    n=int(si())
    arr = [tuple(map(int,si().split())) for _ in range(n)]
    ans = float('inf')

    for s in range(1, 1<<n) :
        a,b=1,0
        for j in range(n) :
            if (s & (1<<j)) != 0 :
                a *= arr[j][0]
                b += arr[j][1]

        ans = min(ans, abs(a-b))
    print(ans)


if __name__ == "__main__" :
    main()


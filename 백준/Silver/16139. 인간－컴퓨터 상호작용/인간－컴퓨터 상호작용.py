import sys
si = sys.stdin.readline


def main():
    S = si().rstrip()
    q = int(si())
    prefix = [[0]*26 for _ in range(len(S))]
    for i in range(len(S)) :
        for j in range(26) :
            if ord(S[i])-97==j :
                prefix[i][j] = prefix[i-1][j]+1
            else :
                prefix[i][j] = prefix[i - 1][j]

    for _ in range(q) :
        a, l, r = si().split()
        if int(l) == 0 :
            ans = prefix[int(r)][ord(a) - 97]
        else :
            ans = prefix[int(r)][ord(a) - 97] - prefix[int(l) - 1][ord(a) - 97]

        print(ans)


if __name__ == "__main__":
    main()


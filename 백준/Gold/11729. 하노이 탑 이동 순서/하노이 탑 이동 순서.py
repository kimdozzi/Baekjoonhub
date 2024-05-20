import sys
si = sys.stdin.readline
arr = []

def move(start, to) :
    arr.append((start, to))

def hanoi(N, start, to, via) :
    if N == 1 :
        move(start, to)
    else :
        hanoi(N-1, start, via, to)
        move(start, to)
        hanoi(N-1, via, to, start)

def main():
    N = int(si())
    hanoi(N, '1', '3', '2')
    print(len(arr))
    for i in arr :
        print(*i, sep=' ')

if __name__ == "__main__":
    main()


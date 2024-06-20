import sys
input = sys.stdin.readline
# sys.setrecursionlimit(1_000_000)
# from collections import defaultdict, deque, Counter
# from bisect import bisect_left, bisect_right
# from heapq import heappop, heappush, heapify
# from math
# from itertools import permutations
# float('inf') # float('-inf')

# 다음 순열을 구하는 복잡도는 O(N)
# 전체 순열을 모두 구하면 O(N! * N)

def next_permutation(arr) :
    # 1. 오름차순이 아닌 부분 - 1번째 idx를 찾음
    # 7 2 6 4 5 3 1
    # 0 1 2 3 4 5 6
    i = n - 1
    while i > 0 and arr[i-1] > arr[i] :
        i -= 1
    if i <= 0 : return False
    # 2. arr[i]보다 크면서 가장 오른쪽에 있는 수 찾음
    j = n - 1
    while arr[j] <= arr[i-1] : j -= 1
    # 3. 교환
    arr[i-1], arr[j] = arr[j], arr[i-1]

    # 4. i ~ N-1까지 스왑
    j = n - 1
    while i < j :
        arr[i], arr[j] = arr[j], arr[i]
        i += 1; j -= 1

    return True


n=int(input())
arr=list(map(int,input().split()))
if next_permutation(arr) :
    print(' '.join(map(str, arr)))
else : 
    print(-1)
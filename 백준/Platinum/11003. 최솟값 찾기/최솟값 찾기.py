import sys
from collections import deque
si = sys.stdin.readline

# 수열을 순회하면서 항을 덱에 넣기 전에 덱에서 항보다 크거나 같은 값들을 뒤에서부터 모두 제거
# 이렇게 하면 현재 항보다 큰 수들을 무시

# 현재 항을 덱의 뒤에 넣는다.

# 구간의 조건에 만족하지 않는 수들을 덱의 앞에서부터 모두 제거

# 이러면 덱의 front가 해당 구간의 최솟값이 되고, 큐에 있는 원소들은 단조성을 가지게 된다.

n, l = map(int, si().split())
arr = list(map(int, si().split()))
q = deque()
res = []

for i in range(len(arr)) :
    while q and q[-1][0] >= arr[i] :
        q.pop()

    while q and q[0][1] < i - l + 1 :
        q.popleft()

    q.append((arr[i], i))
    print(q[0][0], end = ' ')


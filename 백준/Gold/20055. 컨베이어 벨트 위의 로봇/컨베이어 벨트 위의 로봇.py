import sys
from collections import deque
si = sys.stdin.readline
n,k = map(int ,si().split())
belt = deque(list(map(int, si().split())))
robot = deque([0 for _ in range(n)])

idx = 1
while True :
    # 1. 벨트(내구도) 회전 + 로봇 회전 . 처음에 올려진 로봇은 없음
    belt.rotate(1)
    robot.rotate(1)

    # 2. N번 벨트에 있다면(내리는 위치) 내려진다.
    robot[n-1] = 0

    # 3. 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
    for i in range(n-2,-1,-1) :
        if robot[i] and not robot[i+1] and belt[i+1] >= 1 :
            belt[i+1] -= 1
            robot[i], robot[i+1] = 0, 1

        robot[n-1] = 0

    # 4. 올리는 위치의 칸의 내구도가 0이 아니면(1이상) 올리는 위치에 로봇을 올린다.
    if robot[0] == 0 and belt[0] >= 1 :
        belt[0] -= 1
        robot[0] = 1

    # 5. 내구도가 0인 칸의 개수가 k개 이상이면, 종료
    if belt.count(0) >= k : break

    idx += 1

print(idx)
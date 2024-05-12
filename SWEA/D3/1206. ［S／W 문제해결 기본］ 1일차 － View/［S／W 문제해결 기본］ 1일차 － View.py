
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, 11):
    n = int(input())
    buildings = list(map(int, input().split()))
    cnt = 0
    for i in range(2, n-2) :
        left = max(buildings[i - 1], buildings[i - 2])
        right = max(buildings[i + 1], buildings[i + 2])
        best = max(left, right)
        if buildings[i] > best  :
            cnt += buildings[i] - best

    print(f'#{test_case} {cnt}')

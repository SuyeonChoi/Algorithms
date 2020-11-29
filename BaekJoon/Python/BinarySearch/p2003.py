import sys
input = sys.stdin.readline
N, M = map(int, input().split())
numList = list(map(int, input().split()))
cnt = 0
low, high = 0, 0
_sum = 0
while high <= N:
    if _sum == M:
        _sum -= numList[low]
        low += 1
        cnt += 1
    elif _sum > M:
        _sum -= numList[low]
        low += 1
    else:
        if high == N:
            break
        _sum += numList[high]
        high += 1
print(cnt)
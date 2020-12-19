
N, M = map(int, input().split())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

K = int(input())
arrSum = []
for k in range(K):
    i, j, x, y = map(int, input().split())
    _sum = 0
    curR, curC = i-1, j-1
    while curR <= x and curC <= y:
        if curC == (M-1):
            curC = 0
        _sum += arr[curR][curC]
        curR += 1
        curC += 1
    arrSum.append(_sum)
print(arrSum)
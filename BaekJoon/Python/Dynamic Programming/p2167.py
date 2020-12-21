import sys
input = sys.stdin.readline
N, M = map(int, input().split())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

K = int(input())
dp = [[0]*(M+1) for i in range(N+1)]
for i in range(1, N+1):
    for j in range(1, M+1):
        dp[i][j] = arr[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]
# print(dp)
for k in range(K):
    i, j, x, y = map(int, input().split())
    print(dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1])

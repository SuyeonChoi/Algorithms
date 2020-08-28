N, M = map(int, input().split())
maze = [list(map(int, input().split())) for _ in range(N)]
dp = [[0 for _ in range(M)] for _ in range(N)]

for i in range(N):
    for j in range(M):
        if i == 0 and j == 0:
            dp[i][j] = maze[i][j]
            continue
        if i == 0:
            dp[i][j] = dp[i][j-1] + maze[i][j]
            continue
        if j == 0:
            dp[i][j] = dp[i-1][j] + maze[i][j]
            continue
        dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + maze[i][j]

print(dp[N-1][M-1])
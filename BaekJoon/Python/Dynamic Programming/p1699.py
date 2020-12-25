import sys
import math
input = sys.stdin.readline
N = int(input())
dp = [0] * (N+1)
dp[1] = 1
for i in range(2, N+1):
    if int(math.sqrt(i)) == math.sqrt(i):
        dp[i] = 1
    else:
        dp[i] = dp[i-1] + 1
        j = 1
        while j*j <= i:
            dp[i] = min(dp[i], dp[i-j*j] + 1)
            j += 1

print(dp[N])
N = int(input())
cards = list(map(int, input().split()))
dp = list()
for i in range(1, N+1):
    dp.append(i)
dp[0] = cards[0]*1
for i in range(1, N+1):
    for j in range(1, i+1):
        dp[i] = max(dp[i], dp[i-j]+cards[j])

print(dp)
print(dp[N])
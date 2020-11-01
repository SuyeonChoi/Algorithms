import sys
input = sys.stdin.readline

def combination(n, k):
    ans = 1
    for i in range(k):
        ans *= n
        n -= 1
    for i in range(1, k+1):
        ans //= i
    return ans

N, K = map(int, input().split())
if (N - K) < K:
    K = N - K
print(combination(N, K) % 10007)
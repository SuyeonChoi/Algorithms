import sys
input = sys.stdin.readline

N, K = map(int, input().split())
def combination(n, k):
    ans = 1
    for i in range(k):
        ans *= n
        n -= 1
    for i in range(1, k+1):
        ans //= i
    return ans

print(combination(N, K))
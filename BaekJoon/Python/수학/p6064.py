import sys
input = sys.stdin.readline
T = int(input())

def solve(m, n, x, y):
    if x == m:
        x = 0
    if y == n:
        y = 0
    for i in range(x, m*n, m):
        if i % n == y:
            return i
    return -1

for i in range(T):
    M, N, x, y = map(int, input().split())
    print(solve(M, N, x, y))
import sys
input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
decreasing = [0] * N

for i in range(N):
    decreasing[i] = 1
    for j in range(i):
        if A[i] < A[j]:
            decreasing[i] = max(decreasing[i], decreasing[j]+1)

print(max(decreasing))
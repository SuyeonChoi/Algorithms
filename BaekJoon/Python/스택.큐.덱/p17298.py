import sys
input = sys.stdin.readline
N = int(input())
sequence = list(map(int, input().split()))
result = [-1] * N

stack = []
for i in range(N-1, -1, -1):
    while stack and sequence[stack[-1]] <= sequence[i]:
        stack.pop()
    if stack:
        result[i] = sequence[stack[-1]]
    stack.append(i)

print(" ".join(list(map(str, result))))

import sys
input =sys.stdin.readline

N = int(input())
buildings = [int(input()) for _ in range(N)]
stack = []

answer = 0
result = [0] * N
for i in range(N-1, -1, -1):
    isWatched = 0
    endIndex = N
    while stack:
        idx, watched = stack[-1]
        if buildings[i] > buildings[idx]:
            stack.pop()
            isWatched += (1+watched)
            endIndex = idx
        else:
            break
    stack.append((i, isWatched))
    result[i] = isWatched
    answer += isWatched

print(answer)

import sys
input =sys.stdin.readline

N = int(input())
buildings = [int(input()) for _ in range(N)]
stack = []
# left_stack = []
# right_stack = []
# for i in reversed(buildings):


result = [0] * N
for i in range(N-1, -1, -1):
    isWatched = 0
    endIndex = N
    while stack:
        idx, watched = stack[-1]
        if buildings[i] > buildings[idx]:
            stack.pop()
            isWatched += 1
            endIndex = idx
        else:
            break
    if endIndex != N:
        isWatched += result[endIndex]
    stack.append((i, isWatched))
    result[i] = isWatched

answer = 0
for i in range(N):
    answer += result[i]
print(answer)


# print(" ".join(list(map(str, result))))
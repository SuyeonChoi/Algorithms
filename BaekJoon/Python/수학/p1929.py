import sys
input = sys.stdin.readline
M, N = map(int, input().split())
state = [True] * (N+1)
state[1] = False
for i in range(2, N+1):
    if i * i > N:
        break
    if not state:
        continue
    for j in range(i*i, N+1, i):
        state[j] = False

for i in range(M, len(state)):
    if state[i]:
        print(i)


import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
deque = deque()
for i in range(N):
    deque.append(i+1)
pick = list(map(int, input().split()))
cnt = 0
for i in range(M):
    idx = list(deque).index(pick[i])
    while deque[0] != pick[i]:
        if idx <= len(deque) // 2:#왼쪽이동
            deque.append(deque.popleft())
            cnt += 1
        else:
            deque.appendleft(deque.pop())
            cnt += 1
    deque.popleft()
print(cnt)

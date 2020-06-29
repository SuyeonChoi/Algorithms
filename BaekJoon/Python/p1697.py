from collections import deque
N, K = map(int, input().split())
queue = deque()
queue.append(N)
dist = [-1 for i in range(100002)]
dist[N] = 0
while dist[K] == -1:
    x = queue.popleft()
    for dx in -1, 1, x:
        nx = x + dx
        if nx < 0 or nx > 100000:
            continue
        if dist[nx] != -1:
            continue
        dist[nx] = dist[x] + 1
        queue.append(nx)

print(dist[K])
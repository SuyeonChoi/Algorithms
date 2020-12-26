from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
adj = [[] for _ in range(N+1)]
hack = [0] * (N+1)
for i in range(M):
    u, v = map(int, input().split())
    adj[v].append(u)

for v in range(1, N+1):
    if not len(adj[v]):
        hack[v] = 1
        continue
    vis = [0] * (N+1)
    queue = deque()
    queue.append(v)
    vis[v] = 1
    cnt = 1
    # using BFS
    while queue:
        cur = queue.popleft()
        for nxt in adj[cur]:
            if vis[nxt] == 0:
                queue.append(nxt)
                vis[nxt] = 1
                cnt += 1
    hack[v] = cnt

_max = max(hack)
for i in range(N+1):
    if hack[i] == _max:
        print(i, end=' ')

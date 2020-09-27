from collections import deque
import sys
input = sys.stdin.readline

def bfs(v, adj):
    vis = [-1] * (v+1)
    queue = deque()
    queue.append(1)
    vis[1] = 0
    while queue:
        cur = queue.popleft()
        for i in range(len(adj[cur])):
            nxt = adj[cur][i]
            if vis[nxt] == -1:
                vis[nxt] = vis[cur] + 1
                queue.append(nxt)
    return vis


V = int(input())
e = int(input())
adj = [[] for _ in range(V+1)]

for i in range(e):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

friend = bfs(V, adj)
cnt = 0
for i in friend:
    if i <= 2 and i > 0:
        cnt += 1
print(cnt)
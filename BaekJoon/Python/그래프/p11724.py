import sys
from collections import deque
input = sys.stdin.readline

def bfs(v, adj):
    vis = [0] * (v + 1)
    cnt = 0
    for i in range(1, len(vis)):
        if vis[i] == 1:
            continue
        queue = deque()
        queue.append(i)
        vis[i] = 1
        while queue:
            cur = queue.popleft()
            for j in range(1, len(adj[cur-1])):
                nx = adj[cur-1][j]
                if vis[nx]:
                    continue
                queue.append(nx)
                vis[nx] = 1
        cnt += 1
    return cnt


V, E = map(int, input().split())
adj = [[i+1] for i in range(V)]
for i in range(E):
    u, v = map(int, input().split())
    adj[u-1].append(v)
    adj[v-1].append(u)

print(bfs(V, adj))
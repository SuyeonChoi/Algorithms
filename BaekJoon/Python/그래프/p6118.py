from collections import deque
def bfs(adj, N):
    vis = [-1] * (N+1)
    queue = deque([1])
    vis[1] = 0
    _max = 0
    while queue:
        cur = queue.popleft()
        for i in range(len(adj[cur])):
            nxt = adj[cur][i]
            if vis[nxt] != -1:
                continue
            vis[nxt] = vis[cur] + 1
            queue.append(nxt)
            if vis[nxt] > _max:
                _max = vis[nxt]
    return vis, _max


N, M = map(int, input().split())
adj = [[] for _ in range(N+1)]
for i in range(M):
    v, e = map(int, input().split())
    adj[v].append(e)
    adj[e].append(v)


dis, _max = bfs(adj, N)
cnt = 0
for i in dis:
    if i == _max:
        cnt += 1
print(dis.index(_max), _max, cnt)


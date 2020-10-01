from collections import deque

N, M = map(int, input().split())
indeg = [0] * N
adj = [[] for _ in range(N)]
for i in range(M):
    u, v = map(int, input().split())
    indeg[v-1] += 1
    adj[u-1].append(v-1)

def topo_sort():
    result = []
    queue = deque()
    for i in range(len(indeg)):
        if indeg[i] == 0:
            queue.append(i)
    while queue:
        cur = queue.popleft()
        result.append(str(cur+1))
        for nxt in adj[cur]:
            indeg[nxt] -= 1
            if indeg[nxt] == 0:
                queue.append(nxt)
    return ' '.join(result)
print(topo_sort())
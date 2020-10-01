from collections import deque
N, M = map(int, input().split())
adj = [[] for _ in range(N)]
indeg = [0] * N
result = []
for i in range(M):
    pd = list(map(int, input().split()))
    for j in range(2, len(pd)):
        adj[pd[j-1]-1].append(pd[j]-1)
        indeg[pd[j]-1] += 1
# print(indeg)
# print(adj)
def topo_sort():
    queue = deque()
    for i in range(len(indeg)):
        if indeg[i] == 0:
            queue.append(i)
    while queue:
        cur = queue.popleft()
        result.append(cur+1)
        for nxt in adj[cur]:
            indeg[nxt] -= 1
            if indeg[nxt] == 0:
                queue.append(nxt)
    return result

topo_sort()
if len(result) != N:
    print(0)
else:
    for i in result:
        print(i)

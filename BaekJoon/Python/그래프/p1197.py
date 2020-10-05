import heapq
V, E = map(int, input().split())
adj = [[] for _ in range(V)]
chk = [False] * V
for i in range(E):
    a, b, c = map(int, input().split())
    adj[a-1].append((b, c))
    adj[b-1].append((a, c))

def prim():
    cnt = 0
    ans = 0
    PQ = []
    for i in range(len(adj[0])):
        heapq.heappush(PQ, (adj[0][i][1], 1, adj[0][i][0]))
    # print(heapq.heappop(PQ))
    chk[0] = True
    # prim(PQ)
    while True:
        cost, v1, v2 = heapq.heappop(PQ)
        if chk[v2-1]:
            continue
        chk[v2-1] = True
        cnt += 1
        ans += cost
        if cnt == V-1:
            break
        for i in range(len(adj[v2])):
            if not chk[adj[v2][i][0]]:
                heapq.heappush(PQ, (adj[v2][i][1], v2, adj[v2][i][0]))
    return ans
# print(chk)
print(prim())
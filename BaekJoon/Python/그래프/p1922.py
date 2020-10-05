import heapq
N = int(input())
M = int(input())
adj = [[] for _ in range(N+1)]
chk = [0] * (N+1)
for i in range(M):
    a, b, c = map(int, input().split())
    adj[a].append((b, c))
    if a != b:
        adj[b].append((a, c))

def prim(adj, chk):
    cnt = 0
    ans = 0
    PQ = []
    for nxt in adj[1]:
        heapq.heappush(PQ, (nxt[1], 1, nxt[0]))
    chk[1] = 1
    while True:
        cost, v1, v2 = heapq.heappop(PQ)
        if chk[v2]:
            continue
        cnt += 1
        ans += cost
        chk[v2] = 1
        if cnt == N-1:
            break
        for nxt in adj[v2]:
            if not chk[nxt[0]]:
                heapq.heappush(PQ, (nxt[1], v2, nxt[0]))
    return ans

print(prim(adj, chk))
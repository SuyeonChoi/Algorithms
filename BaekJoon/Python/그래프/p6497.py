import sys, heapq
input = sys.stdin.readline

def prim(adj, chk):
    cnt = 0
    ans = 0
    PQ = []
    for nxt in adj[0]:
        heapq.heappush(PQ, (nxt[0], 0, nxt[1]))
    chk[0] = 1
    while True:
        cost, v1, v2 = heapq.heappop(PQ)
        if chk[v2]:
            continue
        ans += cost
        cnt += 1
        chk[v2] = 1
        if cnt == m-1:
            break
        for nxt in adj[v2]:
            if not chk[nxt[1]]:
                heapq.heappush(PQ, (nxt[0], v2, nxt[1]))
    return ans

while True:
    m, n = map(int, input().split())
    if m == 0 and n == 0:
        break
    adj = [[] for _ in range(m)]
    chk = [0] * m
    totalCost = 0
    for i in range(n):
        a, b, c = map(int, input().split())
        adj[a].append((c, b))
        adj[b].append((c, a))
        totalCost += c
    if m == 1:
        print(0)
    else:
        print(totalCost - prim(adj, chk))
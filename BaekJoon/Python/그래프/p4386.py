import sys
import math, heapq
input = sys.stdin.readline
n = int(input())
stars = []
for i in range(n):
    stars.append(tuple(map(float, input().split())))
adj = [[] for _ in range(n)]
for i in range(n):
    x1, y1 = stars[i]
    for j in range(n):
        if i == j:
            continue
        x2, y2 = stars[j]
        cost = math.sqrt(math.pow((x2-x1), 2) + math.pow((y2-y1), 2))
        adj[i].append((j, cost))
chk = [0] * n

def prim(adj, chk):
    cnt = 0
    ans = 0
    PQ = []
    for nxt in adj[0]:
        heapq.heappush(PQ, (nxt[1], 0, nxt[0]))
    chk[0] = 1
    while True:
        cost, v1, v2 = heapq.heappop(PQ)
        if chk[v2]:
            continue
        chk[v2] = 1
        cnt += 1
        ans += cost
        if cnt == n-1:
            break
        for nxt in adj[v2]:
            heapq.heappush(PQ, (nxt[1], v2, nxt[0]))
    return format(ans, ".2f")

print(prim(adj, chk))
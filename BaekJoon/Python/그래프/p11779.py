import heapq, sys
input = sys.stdin.readline
n = int(input())
m = int(input())
INF = 1000000000
adj = [[] for _ in range(n+1)]
d = [INF] * (n+1)
pre = [0] * (n+1)
for i in range(m):
    a, b, c = map(int, input().split())
    adj[a].append((b, c))

start, end = map(int, input().split())
pq = []
d[start] = 0
heapq.heappush(pq, (d[start], start))
while pq:
    dist, idx = heapq.heappop(pq)
    if d[idx] != dist:
        continue
    for nxt in adj[idx]:
        nidx, cost = nxt
        if cost+dist < d[nidx]:
            d[nidx] = cost+dist
            heapq.heappush(pq, (d[nidx], nidx))
            pre[nidx] = idx
print(d[end])
path = []
cur = end
while cur != start:
    path.append(cur)
    cur = pre[cur]
path.append(cur)
print(len(path))
print(' '.join(map(str, reversed(path))))
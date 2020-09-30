from collections import deque
import sys
input = sys.stdin.readline
N = int(input())
parent = [-1] * N
parent[0] = 1
adj = [[] for _ in range(N)]

def bfs(root, adj):
    queue = deque([root])
    while queue:
        cur = queue.popleft()
        for nxt in adj[cur]:
            if parent[nxt] == -1:
                parent[nxt] = cur
                queue.append(nxt)

for i in range(N-1):
    u, v = map(int, input().split())
    adj[u-1].append(v-1)
    adj[v-1].append(u-1)

bfs(0, adj)
for i in range(1, N):
    print(parent[i]+1)

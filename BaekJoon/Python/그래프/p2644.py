from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
a, b = map(int, input().split())
m = int(input())
family = [[] for _ in range(n+1)]

for i in range(m):
    u, v = map(int, input().split())
    family[u].append(v)
    family[v].append(u)

queue = deque()
visited = [-1] * (n+1)
queue.append(a)
visited[a] = 0
ans = 0
while queue:
    cur = queue.popleft()
    for nxt in family[cur]:
        if visited[nxt] == -1:
            visited[nxt] = visited[cur] + 1
            queue.append(nxt)
print(visited[b])

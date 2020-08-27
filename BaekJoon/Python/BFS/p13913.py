import sys
from collections import deque
input = sys.stdin.readline
N, K = map(int, input().split())
visited = [[-1]*2 for _ in range(100001)]
visited[N][0] = 0
route = deque()
queue = deque()
queue.append(N)
def BFS():
    while queue:
        x = queue.popleft()
        if x == K:
            return
        for nx in x+1, x-1, 2*x:
            if nx < 0 or nx > 100000:
                continue
            if visited[nx][0] == -1:
                queue.append(nx)
                visited[nx][0] = visited[x][0] + 1
                visited[nx][1] = x
    return

def makeRoute():
    route.appendleft(K)
    idx = visited[K][1]
    if N == K:
        return list(route)
    for i in range(visited[K][0] - 1):
        route.appendleft(idx)
        idx = visited[idx][1]
    route.appendleft(N)
    return list(route)
BFS()
print(visited[K][0])
print(' '.join(map(str, makeRoute())))
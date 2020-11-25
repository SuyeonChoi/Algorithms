from collections import deque
import sys
input = sys.stdin.readline


def bfs(country, queue, vis, n):
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = dx + x, dy + y
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if country[nx][ny] == 0 or vis[nx][ny] != 0:
                continue
            queue.append((nx, ny))
            vis[nx][ny] = 1
            country[nx][ny] = country[x][y]
    return vis, country


def markIsland(n, country):
    queue = deque()
    vis = [[0 for _ in range(n)] for _ in range(n)]
    islandNum = 1
    for i in range(n):
        for j in range(n):
            if (country[i][j] == 1) and (vis[i][j] == 0):
                vis[i][j] = 1
                country[i][j] = islandNum
                queue.append((i, j))
                vis, country = bfs(country, queue, vis, n)
                islandNum += 1
    return country


def makeBridge(country, x, y, n):
    queue = deque()
    queue.append((x, y))
    islandNum = country[x][y]
    vis = [[0 for _ in range(n)] for _ in range(n)]
    vis[x][y] = 0
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = dx + x, dy + y
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if country[nx][ny] != islandNum and country[nx][ny] != 0:
                return vis[x][y]
            if vis[nx][ny] != 0 or country[nx][ny] == islandNum:
                continue
            queue.append((nx, ny))
            vis[nx][ny] = vis[x][y] + 1
    return n+1

def findMinimum(n, country):
    vis = [[n+1 for _ in range(n)] for _ in range(n)]
    _min = n*n+1
    for i in range(n):
        for j in range(n):
            if country[i][j] != 0 and vis[i][j] == n+1:
                vis[i][j] = makeBridge(country, i, j, n)
                if vis[i][j] < _min:
                    _min = vis[i][j]
    return _min


def solution():
    N = int(input())
    country = []
    for i in range(N):
        country.append(list(map(int, input().split())))
    country = markIsland(N, country)
    return findMinimum(N, country)


print(solution())


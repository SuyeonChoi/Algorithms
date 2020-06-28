from collections import deque

R, C = map(int, input().split())
maze = list()
queue = deque()
JR = 0
JC = 0
fire = [[-1] * C for _ in range(R)]
escape = [[-1] * C for _ in range(R)]
for i in range(R):
    line = list(input())
    for j in range(C):
        if line[j] == 'F':
            queue.append((i, j))
            fire[i][j] = 0
        elif line[j] == 'J':
            JR = i
            JC = j
            escape[i][j] = 0
    maze.append(line)

def BFS():
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = dx + x, dy + y
            if nx < 0 or nx >= R or ny < 0 or ny >= C or maze[nx][ny] == '#' or fire[nx][ny] >= 0:
                continue
            queue.append((nx, ny))
            fire[nx][ny] = fire[x][y] + 1

def possible():
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = dx + x, dy + y
            if nx < 0 or nx >= R or ny < 0 or ny >= C:
                return escape[x][y] + 1
            if escape[nx][ny] >= 0 or maze[nx][ny] == '#':
                continue
            if fire[nx][ny] != -1 and fire[nx][ny] <= escape[nx][ny] + 1:
                continue
            queue.append((nx, ny))
            escape[nx][ny] = escape[x][y] + 1
    return 'IMPOSSIBLE'

BFS()
queue.append((JR, JC))
print(possible())

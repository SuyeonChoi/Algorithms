from collections import deque

N, M = map(int, input().split())
paper = [list(map(int, input().split())) for _ in range(N)]


num = 0
visited = [[0]*M for _ in range(N)]
max_area = 0

for row in range(N):
    for col in range(M):
        #도화지에 있는 모든 그림 찾아내기
        if paper[row][col] == 1 and visited[row][col] == 0:
            num += 1
            #그림의 크기 알아내기
            queue = deque()
            queue.append((row, col))
            visited[row][col] = 1
            area = 1
            while queue:
                x, y = queue.popleft()
                for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
                    nx, ny = x+dx, y+dy
                    if nx<0 or nx>=N or ny < 0 or ny >= M:
                        continue
                    if paper[nx][ny] == 1 and visited[nx][ny] == 0:
                        queue.append((nx, ny))
                        visited[nx][ny] = 1
                        area += 1
            max_area = max(max_area, area)




#그림의 개수
print(num)
#가장 넓은 그림의 넓이
print(max_area)



from collections import deque
import itertools

def solution(n):
    triangle = []
    if n == 1:
        return [1]
    for i in range(n):
        tmp = [0]*(i + 1)
        triangle.append(tmp)

    queue = deque()
    queue.append((0, 0))
    cnt = 1
    dir = 'D'
    while queue:
        x, y = queue.popleft()
        if triangle[x][y] != 0:
            break
        triangle[x][y] = cnt
        if dir == 'D':
            if x + 1 < n and triangle[x + 1][y] == 0:
                queue.append((x + 1, y))
            else:
                queue.append((x, y+1))
                dir = 'R'
        elif dir == 'R':
            if y + 1 <= x and triangle[x][y+1] == 0:
                queue.append((x, y+1))
            else:
                queue.append((x-1, y-1))
                dir = 'U'
        else:
            if x - 1 >= 0 and triangle[x - 1][y - 1] == 0:
                queue.append((x - 1, y - 1))
            else:
                queue.append((x+1, y))
                dir = 'D'
        cnt += 1



    return list(itertools.chain(*triangle))

print(solution(1))
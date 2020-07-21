import heapq
N, M = map(int, input().split())
# office = [list(map(int, input().split())) for _ in range(N)]
office = []
priority = []
heap = []
for i in range(N):
    temp = list(map(int, input().split()))
    office.append(temp)
    for j in range(M):
        if 0 < temp[j] < 6:
            # priority.append(temp[j])
            heapq.heappush(heap, (-temp[j], (i, j)))
def search(x, y):
    global office
    if office[x][y] == 0:
        office[x][y] = '#'
    if office[x][y] == 6:
        return -1

while heap:
    temp = heapq.heappop(heap)
    camera = -temp[0]
    x, y = temp[1]
    if camera == 5:
        for up in reversed(range(x)):
            if search(up, y) == -1:
                break
        for down in range(x+1, N):
            if search(down, y)== -1:
                break
        for left in reversed(range(y)):
            if search(x, left) == -1:
                break
        for right in range(y+1, M):
            if search(x, right) == -1:
                break
    elif camera == 4:
        cnt = 0
        check = [0 for _ in range(4)]
        for up in reversed(range(x)):
            if office[up][y] == 0:
                cnt += 1
            if office[up][y] == 6:
                break
        check[0] = cnt
        cnt = 0
        for down in range(x + 1, N):
            if office[down][y] == 0:
                cnt += 1
            if office[down][y] == 6:
                break
        check[1] = cnt
        cnt = 0
        for left in reversed(range(y)):
            if office[x][left] == 0:
                cnt += 1
            if office[x][left] == 6:
                break
        check[2] = cnt
        cnt = 0
        for right in range(y + 1, M):
            if office[x][right] == 0:
                cnt += 1
            if office[x][right] == 6:
                break
        check[3] = cnt
        for i in range(3):
            i = check.index(max(check))
            if i == 0:
                for up in reversed(range(x)):
                    if search(up, y) == -1:
                        break
            elif i == 1:
                for down in range(x + 1, N):
                    if search(down, y) == -1:
                        break
            elif i == 2:
                for left in reversed(range(y)):
                    if search(x, left) == -1:
                        break
            else:
                for right in range(y + 1, M):
                    if search(x, right) == -1:
                        break
            del check[i]
    elif camera == 3:
        check = [0 for _ in range(4)]
        u = 0
        for up in reversed(range(x)):
            if office[up][y] == 0:
                u += 1
            if office[up][y] == 6:
                break
        d = 0
        for down in range(x + 1, N):
            if office[down][y] == 0:
                d += 1
            if office[down][y] == 6:
                break
        l = 0
        for left in reversed(range(y)):
            if office[x][left] == 0:
                l += 1
            if office[x][left] == 6:
                break
        r = 0
        for right in range(y + 1, M):
            if office[x][right] == 0:
                r += 1
            if office[x][right] == 6:
                break
        check[0] = u+l
        check[1] = l+d
        check[2] = d+r
        check[3] = r+u
        for i in range(4):
            i = check.index(max(check))
            if i == 0:
                for up in reversed(range(x)):
                    if search(up, y) == -1:
                        break
                for left in reversed(range(y)):
                    if search(x, left) == -1:
                        break
            elif i == 1:
                for down in range(x + 1, N):
                    if search(down, y) == -1:
                        break
                for left in reversed(range(y)):
                    if search(x, left) == -1:
                        break
            elif i == 2:
                for down in range(x + 1, N):
                    if search(down, y) == -1:
                        break
                for right in range(y + 1, M):
                    if search(x, right) == -1:
                        break
            else:
                for right in range(y + 1, M):
                    if search(x, right) == -1:
                        break
                for up in reversed(range(x)):
                    if search(up, y) == -1:
                        break
            del check[i]
    elif camera == 2:
        cnt = 0
        check = [0 for _ in range(2)]
        for up in reversed(range(x)):
            if office[up][y] == 0:
                cnt += 1
            if office[up][y] == 6:
                break
        for down in range(x + 1, N):
            if office[down][y] == 0:
                cnt += 1
            if office[down][y] == 6:
                break
        check[0] = cnt
        cnt = 0
        for left in reversed(range(y)):
            if office[x][left] == 0:
                cnt += 1
            if office[x][left] == 6:
                break
        for right in range(y + 1, M):
            if office[x][right] == 0:
                cnt += 1
            if office[x][right] == 6:
                break
        check[1] = cnt
        i = check.index(max(check))
        if i == 0:
            for up in reversed(range(x)):
                if search(up, y) == -1:
                    break
            for down in range(x + 1, N):
                if search(down, y) == -1:
                    break
        else:
            for left in reversed(range(y)):
                if search(x, left) == -1:
                    break
            for right in range(y + 1, M):
                if search(x, right) == -1:
                    break
    else:
        cnt = 0
        check = [0 for _ in range(4)]
        for up in reversed(range(x)):
            if office[up][y] == 0:
                cnt += 1
            if office[up][y] == 6:
                break
        check[0] = cnt
        cnt = 0
        for down in range(x + 1, N):
            if office[down][y] == 0:
                cnt += 1
            if office[down][y] == 6:
                break
        check[1] = cnt
        cnt = 0
        for left in reversed(range(y)):
            if office[x][left] == 0:
                cnt += 1
            if office[x][left] == 6:
                break
        check[2] = cnt
        cnt = 0
        for right in range(y + 1, M):
            if office[x][right] == 0:
                cnt += 1
            if office[x][right] == 6:
                break
        check[3] = cnt
        i = check.index(max(check))
        if i == 0:
            for up in reversed(range(x)):
                if search(up, y) == -1:
                    break
        elif i == 1:
            for down in range(x + 1, N):
                if search(down, y) == -1:
                    break
        elif i == 2:
            for left in reversed(range(y)):
                if search(x, left) == -1:
                    break
        else:
            for right in range(y + 1, M):
                if search(x, right) == -1:
                    break

result = 0
for i in range(N):
    for j in range(M):
        if office[i][j] == 0:
            result += 1


print(result)


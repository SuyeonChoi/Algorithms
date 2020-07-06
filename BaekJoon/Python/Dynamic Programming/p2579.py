length = int(input())
stairs = [int(input()) for i in range(length)]
point = [[0]*2 for _ in range(length)]
point[0][0] = stairs[0]
for i in range(1, length):
    point[i][0] = max(point[i-2][0], point[i-2][1]) + stairs[i]
    point[i][1] = point[i-1][0] + stairs[i]

print(max(point[length-1][0], point[length-1][1]))
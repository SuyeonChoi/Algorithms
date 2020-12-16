import sys
input = sys.stdin.readline
N = int(input())
room = [[0, 0] for _ in range(N)]
for i in range(N):
    start, end = map(int, input().split())
    room[i][0] = start
    room[i][1] = end

#회의가 끝나는 시간이 빠른 순으로
#끝나는 시간이 같다면 시작 시간이 빠른 순으로 정렬
room = sorted(room, key=lambda x:(x[1], x[0]))
t = 0
ans = 0
for start, end in room:
    if start < t:
        continue
    ans += 1
    t = end

# print(room)
print(ans)
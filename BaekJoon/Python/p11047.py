N, K = map(int, input().split())
money = list()
for i in range(N):
    money.append(int(input()))

count = 0
for i in reversed(range(N)):
    if K // money[i] > 0:
        count += K // money[i]
        K -= K//money[i]*money[i]

print(count)

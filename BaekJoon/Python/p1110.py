N = int(input())
original = N
count = 0
while True:
    count += 1
    first = N // 10
    second = N % 10
    new = int(str(second)+str((first+second)%10))
    if new == original:
        break
    else:
        N = new
print(count)
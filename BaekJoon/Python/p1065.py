N = int(input())
count = 0
for i in range(1, N+1):
    list = [int(j) for j in str(i)]
    if len(list) <= 2:
        count += 1
    else:
        check = 0
        for k in range(len(list)-2):
            if list[k+1]-list[k] != list[k+2]-list[k+1]:
                check += 1
        if check == 0:
            count += 1

print(count)
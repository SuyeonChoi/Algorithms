cups = [1, 2, 3]
temp1 = 0
temp2 = 0
M = int(input())

while M>0:
    x, y = map(int, input().split())
    for i in range(0, 3):
        if cups[i] == x:
            temp1 = i
        if cups[i] == y:
            temp2 = i
    temp3 = cups[temp1]
    cups[temp1] = cups[temp2]
    cups[temp2] = temp3
    M = M-1

print(cups[0])
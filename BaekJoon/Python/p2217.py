number = int(input())
ropes = [0 for i in range(number)]
max = 0

for i in range(number):
    ropes[i] = int(input())

ropes.sort()
for i in range(number):
    if(max<ropes[i]*(number-i)):
        max = ropes[i]*(number-i)

print(max)
import sys
input = sys.stdin.readline

K = int(input())

stack = []
for i in range(K):
    num = int(input())
    if num == 0:
        stack.pop()
    else:
        stack.append(num)

result = 0
for i in stack:
    result += i

print(result)
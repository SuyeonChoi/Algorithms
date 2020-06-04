num = int(input())
stack = []
command = []
for i in range(num):
    command.append(input().split())

for i in range(num):
    if command[i][0] == 'push':
        stack.append(command[i][1])
        i = i+1
    elif command[i][0] == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[len(stack)-1])
            del stack[len(stack)-1]
    elif command[i][0] == 'size':
        print(len(stack))
    elif command[i][0] == 'empty':
        if len(stack) == 0:
            print('1')
        else:
            print('0')
    else:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[len(stack)-1])

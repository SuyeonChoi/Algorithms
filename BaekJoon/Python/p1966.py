test_case = int(input())

for i in range(test_case):
    N, M = map(int, input().split())
    weight = list(map(int, input().split()))
    priority = list(range(len(weight)))
    priority[M] = 'P'
    count = 0
    while True:
        if weight[0] == max(weight):
            if priority[0] == 'P':
                count += 1
                print(count)
                break
            else:
                count += 1
                weight.pop(0)
                priority.pop(0)

        else:
            weight.append(weight.pop(0))
            priority.append(priority.pop(0))
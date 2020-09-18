def solution(bridge_length, weight, truck_weights):
    stack = []
    tmp = 0
    time = 0
    while truck_weights:
        if stack and stack[0][1] == bridge_length:
            truck = stack.pop(0)
            tmp -= truck[0]
        if (tmp + truck_weights[0]) <= weight:
            truck = truck_weights.pop(0)
            tmp += truck
            stack.append([truck, 0])
        for j in range(len(stack)):
            stack[j][1] += 1
        # print(stack)
        time += 1

    while stack:
        if stack[0][1] == bridge_length:
            stack.pop(0)
        for j in range(len(stack)):
            stack[j][1] += 1
        time += 1
        # print(stack)
    return time

print(solution(5, 5,[1, 1, 1, 1, 1, 2, 2, 2, 2]	))
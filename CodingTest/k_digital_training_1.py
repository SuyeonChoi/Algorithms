def solution(num):
    while True:
        numList = list(map(int, str(num)))
        if len(numList) % 2:
            numList = [0] * (len(numList) + 1)
            numList[0] = 1
            num = int(''.join(map(str, numList)))
        n = len(numList) // 2
        frontMul = numList[0]
        rearMul = numList[-1]
        for i in range(1, n):
            frontMul *= numList[i]
        for i in range(len(numList)-2, n-1, -1):
            rearMul *= numList[i]
        if frontMul == rearMul:
            return num
        num += 1

print(solution(101))

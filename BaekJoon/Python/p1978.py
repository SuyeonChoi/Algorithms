def isPrime(param):
    if(param == 1):
        return False
    else:
        for i in range(2, param):
            if(param % i == 0):
                return False
        return True

N = int(input())
count = 0
num_list = list(map(int, input().split()))
for i in range(N):
    if True == isPrime(num_list[i]):
        count += 1

print(count)

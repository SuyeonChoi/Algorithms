num = int(input())
calculation = [0 for i in range(num+1)]
for i in range(2, num+1):
    calculation[i] = calculation[i-1]
    if i % 3 == 0:
        calculation[i] = min(calculation[i], calculation[i//3])
    if i % 2 == 0:
        calculation[i] = min(calculation[i], calculation[i//2])
    calculation[i] += 1
print(calculation[num])
import sys
input = sys.stdin.readline
n = int(input())
employee = dict()
for i in range(n):
    name, record = map(str, input().split())
    if record == 'enter':
        employee[name] = True
    else:
        del employee[name]

print('\n'.join(sorted(list(employee.keys()), reverse=True)))
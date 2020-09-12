import sys
input = sys.stdin.readline
_str = input().rstrip('\n')
explode = input().rstrip('\n')
stack = []
for s in _str:
    idx = 0
    if stack and explode[stack[-1][1]] == s:
        idx = stack[-1][1] + 1
    elif len(stack) == 0 and s == explode[0]:
        idx = 1
    elif stack and explode[0] == s:
        idx = 1
    stack.append((s, idx))
    if idx == len(explode):
        for i in range(len(explode)):
            stack.pop()
result = ''
for s, c in stack:
    result += s
if result:
    print(result)
else:
    print('FRULA')

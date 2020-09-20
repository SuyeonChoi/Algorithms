
def solution():
    _string = list(input())
    stack = []
    check = []
    num = 0
    for s in _string:
        if s == '(' or s == '[':
            stack.append(s)
            check.append(0)
        elif s == ')':
            if (not stack) or stack[-1] != '(':
                return 0
            stack.pop()
            c = check.pop()
            if c:
                c *= 2
            else:
                c += 2
            if check:
                check[-1] += c
            else:
                num += c
        elif s == ']':
            if (not stack) or stack[-1] != '[':
                return 0
            stack.pop()
            c = check.pop()
            if c:
                c *= 3
            else:
                c += 3
            if check:
                check[-1] += c
            else:
                num += c
    if stack:
        return 0
    return num

print(solution())
def solution(s):
    word = list(s)
    p, s = 0, 0
    for w in word:
        if w == 'p' or w == 'P':
            p += 1
        elif w == 'y' or w=='Y':
            s += 1
    if p == s:
        return True
    else:
        return False

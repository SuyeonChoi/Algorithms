from collections import deque
def solution(skill, skill_trees):
    seq = list(skill)
    cnt = 0
    for tree in skill_trees:
        tree_seq = deque(list(tree))
        idx = 0
        isPossible = True
        while tree_seq:
            cur = tree_seq.popleft()
            if cur in seq and seq[idx] != cur:
                isPossible = False
                break
            if seq[idx] == cur:
                if idx >= len(seq)-1:
                    break
                idx += 1
        if isPossible:
            cnt += 1
    return cnt


print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))
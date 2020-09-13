_string = input()
result = []

for i in range(1, len(_string)+1):
    for j in range(0, len(_string)-i+1):
        tmp = _string[j:j+i]
        result.append(tmp)
# print(result)
# print(len(result))
# print(set(result))
print(len(set(result)))
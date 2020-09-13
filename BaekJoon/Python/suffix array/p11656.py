
S = input()
suffix_array = []
for i in range(len(S)):
    suffix_array.append(S[i:len(S)])

suffix_array.sort()
for i in suffix_array:
    print(i)
# print(suffix_array)
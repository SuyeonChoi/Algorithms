alphabet = list(input())
alphabet.append('')
alphabet.append('')
count = 0
index = 0
while index < len(alphabet):
    if alphabet[index] == '':
        break
    if alphabet[index] == 'c' and alphabet[index+1] == '=':
        count += 1
        index += 2
    elif alphabet[index] == 'c' and alphabet[index+1] == '-':
        count += 1
        index += 2
    elif alphabet[index] == 'd' and alphabet[index+1] == 'z' and alphabet[index+2] == '=':
        count+= 1
        index += 3
    elif alphabet[index] == 'd' and alphabet[index+1] == '-':
        count += 1
        index += 2
    elif alphabet[index] == 'l' and alphabet[index+1] == 'j':
        count += 1
        index += 2
    elif alphabet[index] == 'n' and alphabet[index+1] == 'j':
        count += 1
        index += 2
    elif alphabet[index] == 's' and alphabet[index + 1] == '=':
        count += 1
        index += 2
    elif alphabet[index] == 'z' and alphabet[index+1] == '=':
        count += 1
        index += 2
    else:
        count += 1
        index += 1
print(count)
# for i in range(len(alphabet)-1):
#
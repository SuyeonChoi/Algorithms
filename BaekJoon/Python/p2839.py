n = int(input())
three = 0
five = 0
while True:
    if n%5 == 0:
        five = n/5;
        print(int(three+five))
        break
    elif n<=0:
        print(-1)
        break
    three = three+1;
    n = n-3

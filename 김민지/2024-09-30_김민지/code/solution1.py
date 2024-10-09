s_num = []

for i in range(1, 29):
    number = int(input())
    s_num.append(number)
    
for i in range(1, 31):
    if i not in s_num:
        print(i)
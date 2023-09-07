a = input().split()
hour = int(a[0])
min = int(a[1])
second = int(a[2])
dur = int(input())
second += dur
secondRemain = int(second / 60)
second = second % 60
min += secondRemain
minRemain = int(min / 60)
min = min % 60
hour += minRemain
hour = hour % 24
print(f"{hour} {min} {second}")
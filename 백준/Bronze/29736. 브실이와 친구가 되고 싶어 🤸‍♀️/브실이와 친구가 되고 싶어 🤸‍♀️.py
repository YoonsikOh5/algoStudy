ab = input().split()
a = int(ab[0])
b = int(ab[1])
kx = input().split()
k = int(kx[0])
x = int(kx[1])

resultsum = 0

mink = k - x
maxk = k + x

left = max(mink, a)
right = min(maxk, b)

result = (right - left + 1)
if (result <= 0):
  print("IMPOSSIBLE")
else :
  print(result)
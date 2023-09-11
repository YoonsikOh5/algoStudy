n = int(input())

str = ["Never gonna give you up","Never gonna let you down","Never gonna run around and desert you","Never gonna make you cry","Never gonna say goodbye","Never gonna tell a lie and hurt you","Never gonna stop"]

isAllright = True
for i in range(n):
   cur = input()
   isRight = False
   for cstr in str:
       if cstr == cur:
           isRight = True
   if isRight==False:
      isAllright = False
if isAllright:
  print("No")
else:
  print("Yes")
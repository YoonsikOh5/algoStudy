t = int(input())
for i in range(t):
  arr = input().split()
  tele = int(arr[0]) * int(arr[1])
  euro = int(arr[2]) * int(arr[3])
  if euro > tele:
    print("Eurecom")
  elif tele > euro:
    print("TelecomParisTech")
  elif euro == tele:
    print("Tie")
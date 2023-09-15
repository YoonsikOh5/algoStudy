a, b, c = map(int, input().split())
ra = a * b / c
rb = a / b * c

if ra >= rb:
  print(int(ra))
else:
  print(int(rb))
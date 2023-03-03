import math
import sys

n = int(input())
start = 1

for i in range(2, n+1):
    start *= i

sys.stdout.write(str(start))
sys.stdout.flush()